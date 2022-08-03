package com.howtodoinjava.rest.hackathon.component;

import com.howtodoinjava.rest.hackathon.dto.ContactDetails;
import com.howtodoinjava.rest.hackathon.dto.PatientDemographics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InitializeValues {

    public Map<String, PatientDemographics> mapPatientDemographics = new HashMap<>();

    String[] arrPatName = {"atarpan","mudit","nikhil","ayushi","satish"};
    String[] arrTypeOfContact = {"emergency","primaryprovider","user"};



    public void intializeValues() {

         Map<String, String> mapContact = new HashMap<String,String>() {{
            put("atarpan^emergency","Mudit^muditsharma2017@gmail.com^+918174023399");
            put("atarpan^emergency2","Ayushi^ayushijain561@gmail.com^+919717112549");
            put("atarpan^primaryprovider","Nikhil^nikhilak479.abc@gmail.com^+918700623941");
            put("atarpan^user","Atarpan^atarpan.dasgupta@gmail.com^+919160121541");
            put("mudit^emergency","Ayushi^ayushijain561@gmail.com^+919717112549");
            put("mudit^emergency2","Satish^satish.k.gandhi@gmail.com^+919871127452");
            put("mudit^primaryprovider","Atarpan^atarpan.dasgupta@gmail.com^+919160121541");
            put("mudit^user","Mudit^muditsharma2017@gmail.com^+918174023399");
            put("nikhil^emergency","Satish^satish.k.gandhi@gmail.com^+919871127452");
            put("nikhil^emergency2","Atarpan^atarpan.dasgupta@gmail.com^+919160121541");
            put("nikhil^primaryprovider","Ayushi^ayushijain561@gmail.com^+919717112549");
            put("nikhil^user","Nikhil^nikhilak479.abc@gmail.com^+918700623941");
            put("ayushi^emergency","Nikhil^nikhilak479.abc@gmail.com^+918700623941");
            put("ayushi^emergency2","Atarpan^atarpan.dasgupta@gmail.com^+919160121541");
            put("ayushi^primaryprovider","Mudit^muditsharma2017@gmail.com^+918174023399");
            put("ayushi^user","Ayushi^ayushijain561@gmail.com^+919717112549");
//            put("satish^emergency","Nikhil^nikhilak479.abc@gmail.com^+918700623941");
//            put("satish^emergency2","Atarpan^atarpan.dasgupta@gmail.com^+919160121541");
//            put("satish^primaryprovider","Ayushi^ayushijain561@gmail.com^+919717112549");
//            put("satish^user","Satish^satish.k.gandhi@gmail.com^+919871127452");
             put("satish^emergency","Satish^satish.k.gandhi@gmail.com^+919871127452");
            put("satish^emergency2","Atarpan^satish.k.gandhi@gmail.com^+919871127452");
            put("satish^primaryprovider","Ayushi^satish.k.gandhi@gmail.com^+919871127452");
            put("satish^user","Satish^satish.k.gandhi@gmail.com^+919871127452");
        }};
        for(String patName : arrPatName) {
            PatientDemographics patientDemographics = new PatientDemographics();
            patientDemographics.setPatientName(patName);

            List<ContactDetails> lstContactDetails = new ArrayList<ContactDetails>();

            for(String typeOfContact: arrTypeOfContact) {
                System.out.println("contactkey"+patName + "^"+typeOfContact);
                String contactValues = mapContact.get(patName + "^"+typeOfContact);
                System.out.println("contactvalues"+contactValues);
                ContactDetails contactDetails = new ContactDetails();
                contactDetails.setContactType(typeOfContact);
                contactDetails.setContactName(contactValues.split("\\^")[0]);
                contactDetails.setContactEmail(contactValues.split("\\^")[1]);
                contactDetails.setContactPhone(contactValues.split("\\^")[2]);
                lstContactDetails.add(contactDetails);
            }
            patientDemographics.setContactDetails(lstContactDetails);
            mapPatientDemographics.put(patName,patientDemographics);
        }
    }
}
