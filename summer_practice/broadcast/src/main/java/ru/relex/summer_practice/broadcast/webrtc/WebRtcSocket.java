package ru.relex.summer_practice.broadcast.webrtc;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by Sasha on 22.07.2015.
 */

@ServerEndpoint("/rtc")
public class WebRtcSocket {

    private static Gson gson;
    private static JsonParser jsonParser;
    private static Hashtable<String, Session> streamers;
    private static Hashtable<String, Hashtable<String,Session>> viewers;

    static {
        gson = new GsonBuilder().create();
        jsonParser = new JsonParser();
        streamers = new Hashtable<>();
        viewers = new Hashtable<>();
    }

    @OnOpen
    public void onOpen(Session session){
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("type","session_id");
        jsonObject.addProperty("data", session.getId());
        try {
            session.getBasicRemote().sendText(gson.toJson(jsonObject));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnMessage
    public void onMessage(String message, Session session){
        System.out.println(message);
        WebRtcMessage webRtcMessage = gson.fromJson(message, WebRtcMessage.class);
        try {
            switch (webRtcMessage.getType()){
                case "streamer":
                    streamers.put(webRtcMessage.getRoom(), session);
                    break;
                case "offer":
                case "offer_candidate":
                    streamers.get(webRtcMessage.getRoom()).getBasicRemote().sendText(message);
                    break;
                case "disconnect_viewer":
                    viewers.get(webRtcMessage.getRoom()).remove(webRtcMessage.getViewer());
                    if (streamers.containsKey(webRtcMessage.getRoom())) {
                        streamers.get(webRtcMessage.getRoom()).getBasicRemote().sendText(message);
                    }
                    break;
                case "answer":
                case "answer_candidate":
                    viewers.get(webRtcMessage.getRoom()).get(webRtcMessage.getViewer()).getBasicRemote().sendText(message);
                    break;
                case "start_stream":
                    for (Map.Entry<String,Session> entry: viewers.get(webRtcMessage.getRoom()).entrySet()){
                        entry.getValue().getBasicRemote().sendText(message);
                    }
                    break;
                case "end_stream":
                    for (Map.Entry<String,Session> entry: viewers.get(webRtcMessage.getRoom()).entrySet()){
                        entry.getValue().getBasicRemote().sendText(message);
                    }
                    streamers.remove(webRtcMessage.getRoom());
                    viewers.remove(webRtcMessage.getRoom());
                    break;
                case "viewer":
                    if(!viewers.containsKey(webRtcMessage.getRoom())){
                        viewers.put(webRtcMessage.getRoom(),new Hashtable<String, Session>());
                    }
                    viewers.get(webRtcMessage.getRoom()).put(webRtcMessage.getViewer(), session);
                    if(streamers.containsKey(webRtcMessage.getRoom())){
                        JsonObject jsonObject = new JsonObject();
                        jsonObject.addProperty("type","start_stream");
                        session.getBasicRemote().sendText(gson.toJson(jsonObject));
                    }
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose(Session session){
        System.out.println("close");
    }
}
