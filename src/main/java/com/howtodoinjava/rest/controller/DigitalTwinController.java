package com.howtodoinjava.rest.controller;

import com.howtodoinjava.rest.hackathon.component.EmailService;
import com.howtodoinjava.rest.hackathon.component.InitializeValues;
import com.howtodoinjava.rest.hackathon.component.TextMessageService;
import com.howtodoinjava.rest.hackathon.dto.ContactDetails;
import com.howtodoinjava.rest.hackathon.dto.PatientDemographics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(path = "/alert")
public class DigitalTwinController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private TextMessageService textMessageService;

    @GetMapping("/")
    ResponseEntity<String> newTest() {
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }

    @GetMapping("/{patientName}")
    ResponseEntity<String> newEmployee(@PathVariable String patientName) {
        try {
            System.out.println("1");
            InitializeValues initializeValues = new InitializeValues();
            initializeValues.intializeValues();

            Map<String, PatientDemographics> mapPatientDemographics = initializeValues.mapPatientDemographics;
            PatientDemographics patientDemographics = mapPatientDemographics.get(patientName);
            for(ContactDetails contactDetails: patientDemographics.getContactDetails()){
                System.out.println("sending mail:"+contactDetails.getContactEmail()+"Mudit"+contactDetails.getContactType());
                emailService.sendAlertMessage(contactDetails.getContactEmail(),"Mudit",contactDetails.getContactType());

            }
//            textMessageService.sendAlertTextMessage("","Mudit","");

        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }
}
