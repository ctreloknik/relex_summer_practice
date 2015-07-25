package ru.relex.summer_practice.broadcast.webrtc;

/**
 * Created by Sasha on 24.07.2015.
 */
public class WebRtcMessage {

    private String room;
    private String type;
    private String viewer;

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getViewer() {
        return viewer;
    }

    public void setViewer(String viewer) {
        this.viewer = viewer;
    }
}
