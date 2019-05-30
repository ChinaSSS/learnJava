package com.网络编程.即时聊天服务器;

import java.io.Serializable;

public class Message implements Serializable {

    private int type;
    private String From;
    private String To;
    private String Info;

    public Message() {

    }

    public Message(int type, String from, String to, String info) {
        this.type = type;
        From = from;
        To = to;
        Info = info;
    }

    public int getType() {
        return type;
    }

    public String getFrom() {
        return From;
    }

    public String getTo() {
        return To;
    }

    public String getInfo() {
        return Info;
    }


    public void setType(int type) {
        this.type = type;
    }

    public void setFrom(String from) {
        From = from;
    }

    public void setTo(String to) {
        To = to;
    }

    public void setInfo(String info) {
        Info = info;
    }

    @Override
    public String toString() {
        return "Message{" +
                "type=" + type +
                ", From='" + From + '\'' +
                ", To='" + To + '\'' +
                ", Info='" + Info + '\'' +
                '}';
    }
}
