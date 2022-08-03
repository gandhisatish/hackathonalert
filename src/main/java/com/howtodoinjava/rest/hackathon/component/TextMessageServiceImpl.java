package com.howtodoinjava.rest.hackathon.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

@Component
public class TextMessageServiceImpl implements TextMessageService {


    @Override
    public void sendTextMessage(String to, String subject, String text) {

    }

    @Override
    public String sendAlertTextMessage(String to, String user, String typeOfMessage) {
        sendSms();
        return "";
//        try {
//            // Construct data
//            System.out.println("sending text message");
//            String apiKey = "apikey=" + "Pc4tpAW5DCU-pkFbQmHsOYu5CBGebfMFL1B5kVSUOF";
//            String message = "&message=" + "This is your message";
//            String sender = "&sender=" + "DGTWN";
//            String numbers = "&numbers=" + "919871127452";
//
//            // Send data
//            HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
//            String data = apiKey + numbers + message + sender;
//            conn.setDoOutput(true);
//            conn.setRequestMethod("POST");
//            conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
//            conn.getOutputStream().write(data.getBytes("UTF-8"));
//            final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//            final StringBuffer stringBuffer = new StringBuffer();
//            String line;
//            while ((line = rd.readLine()) != null) {
//                stringBuffer.append(line);
//            }
//            System.out.println("line"+line);
//            rd.close();
//            System.out.println("Stringbuffer"+stringBuffer);
//            return stringBuffer.toString();
//        } catch (Exception e) {
//            System.out.println("Error SMS "+e);
//            return "Error "+e;
//        }
    }

    public String sendSms() {
        try {
            // Construct data
            String apiKey = "apikey=" + URLEncoder.encode("Pc4tpAW5DCU-pkFbQmHsOYu5CBGebfMFL1B5kVSUOF", "UTF-8");
            String message = "&message=" + URLEncoder.encode("This is your message", "UTF-8");
            String sender = "&sender=" + URLEncoder.encode("TXTLCL", "UTF-8");
            String numbers = "&numbers=" + URLEncoder.encode("919871127452", "UTF-8");

            // Send data
            String data = "https://api.textlocal.in/send/?" + apiKey + numbers + message + sender;
            URL url = new URL(data);
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);

            // Get the response
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            String sResult="";
            while ((line = rd.readLine()) != null) {
                // Process line...
                sResult=sResult+line+" ";
            }
            rd.close();
            System.out.println("sResult"+sResult);
            return sResult;
        } catch (Exception e) {
            System.out.println("Error SMS "+e);
            return "Error "+e;
        }
    }
}
