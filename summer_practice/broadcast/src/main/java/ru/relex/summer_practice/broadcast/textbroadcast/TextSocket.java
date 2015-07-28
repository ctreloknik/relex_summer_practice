package ru.relex.summer_practice.broadcast.textbroadcast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.hibernate.service.spi.InjectService;
import ru.relex.summer_practice.db.Lecture;
import ru.relex.summer_practice.db.Person;
import ru.relex.summer_practice.db.Question;
import ru.relex.summer_practice.service.LectureService;
import ru.relex.summer_practice.service.PersonService;
import ru.relex.summer_practice.service.QuestionService;
import ru.relex.summer_practice.service.RatingService;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import javax.inject.*;
import java.io.IOException;
import java.util.Date;
import java.util.Hashtable;
import java.util.Vector;

/**
 * Created by Sasha on 26.07.2015.
 */

@ServerEndpoint("/text")
public class TextSocket {

    @Inject
    private LectureService lectureService;
    @Inject
    private QuestionService questionService;
    @Inject
    private PersonService personService;
    @Inject
    private RatingService ratingService;

    private static Gson gson;
    private static JsonParser jsonParser;
    private static Hashtable<Long, Session> moderators;
    private static Hashtable<Long, Lecture> lectureCache;
    private static Hashtable<Long, Vector<Session>> viewers;
    private static Hashtable<Long, Person> personCache;
    private static Hashtable<Long, Question> questionCache;

    static {
        gson = new GsonBuilder().create();
        jsonParser = new JsonParser();
        moderators = new Hashtable<>();
        viewers = new Hashtable<>();
        lectureCache = new Hashtable<>();
        personCache = new Hashtable<>();
        questionCache = new Hashtable<>();
    }

    @OnOpen
    public void onOpen(Session session){
        System.out.println(session.getId() + " open");
    }

    @OnMessage
    public void onMessage(String message, Session session){
        System.out.println(message);
        TextMessage textMessage = gson.fromJson(message, TextMessage.class);
        try {
            switch (textMessage.getType()) {
                case "viewer":
                    if (!viewers.containsKey(textMessage.getLecture())) {
                        if(!lectureCache.containsKey(textMessage.getLecture())){
                            Lecture lecture = lectureService.getLectureByID(textMessage.getLecture());
                            if(lecture != null){
                                lectureCache.put(textMessage.getLecture(),lecture );
                            }
                        }
                        viewers.put(textMessage.getLecture(), new Vector<Session>());
                    }
                    viewers.get(textMessage.getLecture()).add(session);
                    if (moderators.containsKey(textMessage.getLecture()))
                    {
                        JsonObject jsonObject = new JsonObject();
                        jsonObject.addProperty("type","start_stream");
                        session.getBasicRemote().sendText(gson.toJson(jsonObject));
                    }
                    break;
                case "new_question":
                    if (!personCache.containsKey(textMessage.getPerson())){
                        Person person = personService.getUserById(textMessage.getPerson());
                        if (person != null) {
                            personCache.put(textMessage.getPerson(), person);
                        }
                    }
                    textMessage.setName(personCache.get(textMessage.getPerson()).getFullname());
                    textMessage.setDatetime(new Date());
                    Question question = new Question();
                    question.setQuestioner(personCache.get(textMessage.getPerson()));
                    question.setText(textMessage.getText());
                    question.setLecture(lectureCache.get(textMessage.getLecture()));
                    question.setDatetime(textMessage.getDatetime());
                    question.setModerated(false);
                    question = questionService.Create(question);
                    textMessage.setQuestion(question.getId());
                    questionCache.put(question.getId(), question);
                    if (moderators.containsKey(textMessage.getLecture())){
                        moderators.get(textMessage.getLecture()).getBasicRemote().sendText(gson.toJson(textMessage));
                    }
                    break;
                case "moderator":
                    if (!moderators.containsKey(textMessage.getLecture())){
                        moderators.put(textMessage.getLecture(),session);
                        if(viewers.containsKey(textMessage.getLecture())){
                            for (Session s: viewers.get(textMessage.getLecture())){
                                JsonObject jsonObject = new JsonObject();
                                jsonObject.addProperty("type","start_stream");
                                s.getBasicRemote().sendText(gson.toJson(jsonObject));
                            }
                        }
                    }
                    break;
                case "moder":
                    Question q = questionCache.get(textMessage.getQuestion());
                    q.setModerated(true);
                    q = questionService.Update(q);
                    questionCache.put(q.getId(), q);
                    TextMessage text = new TextMessage();
                    text.setDatetime(q.getDatetime());
                    text.setName(q.getQuestioner().getFullname());
                    text.setRating(q.getRating());
                    text.setType("moder_question");
                    text.setText(q.getText());
                    text.setQuestion(textMessage.getQuestion());
                    text.setLecture(textMessage.getLecture());
                    String sendStr = gson.toJson(text);
                    if (viewers.containsKey(textMessage.getLecture())){
                        for (Session session1 : viewers.get(textMessage.getLecture())){
                            session1.getBasicRemote().sendText(sendStr);
                        }
                    }
                    if(moderators.containsKey(textMessage.getLecture())) {
                        moderators.get(textMessage.getLecture()).getBasicRemote().sendText(sendStr);
                    }
                    break;
                case "unmoder":
                    questionService.Delete(textMessage.getQuestion());
                    questionCache.remove(textMessage.getQuestion());
                    break;
                case "disconnect_moderator":
                    moderators.remove(textMessage.getLecture());
                    break;
                case "disconnect_viewer":
                    viewers.get(textMessage.getLecture()).remove(textMessage.getPerson());
                    break;
                case "rating":
                    if(!personCache.containsKey(textMessage.getPerson())){
                        Person person = personService.getUserById(textMessage.getPerson());
                        if (person != null) {
                            personCache.put(textMessage.getPerson(), person);
                        }
                    }
                    if(moderators.containsKey(textMessage.getLecture())) {
                        if (!questionCache.containsKey(textMessage.getQuestion()))
                        {
                            questionCache.put(textMessage.getQuestion(),questionService.Read(textMessage.getQuestion()));
                        }
                        if (ratingService.AddRating(
                                personCache.get(textMessage.getPerson()),
                                questionCache.get(textMessage.getQuestion()),
                                textMessage.getRating())) {
                            textMessage.setRating(questionCache.get(textMessage.getQuestion()).getRating());
                            if (viewers.containsKey(textMessage.getLecture())) {
                                for (Session session1 : viewers.get(textMessage.getLecture())) {
                                    session1.getBasicRemote().sendText(gson.toJson(textMessage));
                                }
                            }
                            if (moderators.containsKey(textMessage.getLecture())) {
                                moderators.get(textMessage.getLecture()).getBasicRemote().sendText(gson.toJson(textMessage));
                            }
                        }
                    }

                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose(Session session){
        System.out.println(session.getId() + " close");
    }

}
