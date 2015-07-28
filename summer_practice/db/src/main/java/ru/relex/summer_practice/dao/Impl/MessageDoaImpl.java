package ru.relex.summer_practice.dao.Impl;

import ru.relex.summer_practice.dao.MessageDao;
import ru.relex.summer_practice.db.Lecture;
import ru.relex.summer_practice.db.Message;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Sasha on 28.07.2015.
 */
public class MessageDoaImpl extends GenericCrudDaoImpl<Message, Long> implements MessageDao {

    public MessageDoaImpl(){
        super(Message.class);
    }

    @Override
    public List<Message> ReadAllByLecture(Lecture lecture) {
        String jpql = "SELECT m from Message m WHERE m.lecture = :lecture";
        HashMap<String,Object> parameters = new HashMap<>();
        parameters.put("lecture", lecture);
        return this.EexecuteQuery(jpql,parameters);
    }
}
