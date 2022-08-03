package com.howtodoinjava.rest.hackathon.component;

public interface TextMessageService {

    public void sendTextMessage(String to, String subject, String text);
    public String sendAlertTextMessage(String to, String user, String typeOfMessage);
}
