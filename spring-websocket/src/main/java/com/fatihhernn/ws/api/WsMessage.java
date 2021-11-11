package com.fatihhernn.ws.api;

public class WsMessage {
    private String message;
    private String sender;


    @Override
    public String toString() {
        return "WsMessage{" +
                "message='" + message + '\'' +
                ", sender='" + sender + '\'' +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
