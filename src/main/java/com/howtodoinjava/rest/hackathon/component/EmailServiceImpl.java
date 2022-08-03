package com.howtodoinjava.rest.hackathon.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender emailSender;

    private String subject = "***Alert***";
    private String providerMessage = "Hello <point_ofcontact>,\n" +
            "\n" +
            "<patient_name> is in an emergency situation related to <emergency_type>. Request you to please respond immediately!\n" +
            "\n" +
            "\n" +
            "Contact: <patient_Mobile>\n" +
            "Ambulance: <ambulance_no>\n" +
            "\n" +
            "Thanks for reciprocating!\n" +
            "\n" +
            "Optum Digital Twin\n" +
            "User Central\n" +
            "\n" +
            "**Do Not Reply**";
    private String contactMessage = "Team,\n" +
            "\n" +
            "This is to state that the following person is under an emergency situation. Request you to please act immediately!\n" +
            "\n" +
            "Type of Emergency: <emergency_type>\n" +
            "Person Name: <patient_name>\n" +
            "Age: <age>\n" +
            "Gender: <gender>\n" +
            "Location: <location_link>\n" +
            "Mobile No: <patient_Mobile>\n" +
            "\n" +
            "Thanks for reciprocating!\n" +
            "\n" +
            "Optum Digital Twin\n" +
            "User Central\n" +
            "\n" +
            "**Do Not Reply**";

    public void sendSimpleMessage(
            String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("gandhi_satish@optum.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

    public void sendAlertMessage(String to, String user, String typeOfMessage){
        if(typeOfMessage!=null && (typeOfMessage.equalsIgnoreCase("emergency") || typeOfMessage.equalsIgnoreCase("user"))) {
            contactMessage = contactMessage
                            .replaceAll("<emergency_type>","Heart Condition")
                            .replaceAll("<patient_name>", "Mudit")
                            .replaceAll("<age>", "27Y")
                            .replaceAll("<gender>", "Male")
                            .replaceAll("<location_link>", "https://goo.gl/maps/t17ByrFhbVgXpkxv5")
                            .replaceAll("<patient_Mobile>","+919871127452");

            sendSimpleMessage(to, subject, contactMessage);
        }else {
            providerMessage = providerMessage
                    .replaceAll("<emergency_type>","Heart Condition")
                    .replaceAll("<patient_name>", "Mudit")
                    .replaceAll("<point_ofcontact>", "Hospital so and so")
                    .replaceAll("<ambulance_no>", "1001")
                    .replaceAll("<location_link>", "https://goo.gl/maps/t17ByrFhbVgXpkxv5")
                    .replaceAll("<patient_Mobile>","+919871127452");

            sendSimpleMessage(to, subject, providerMessage);
        }
    }
}
