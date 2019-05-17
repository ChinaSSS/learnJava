package com.聊天;

import java.io.Serializable;

public class Message implements Serializable {

    private String from ;
    private String to;
    private int type;
    private String info;

    public Message(String from, String to, int type, String info) {
        this.from = from;
        this.to = to;
        this.type = type;
        this.info = info;
    }

    public Message() {

    }

    @Override
    public String toString() {
        return "Message{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", type=" + type +
                ", info='" + info + '\'' +
                '}';
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getType() {
        return type;
    }

    public String getInfo() {
        return info;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
