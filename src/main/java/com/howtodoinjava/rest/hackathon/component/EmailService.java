package com.howtodoinjava.rest.hackathon.component;

public interface EmailService {

    public void sendSimpleMessage(String to, String subject, String text);
    public void sendAlertMessage(String to, String user, String typeOfMessage);
}
