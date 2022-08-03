package com.howtodoinjava.rest.hackathon.dto;

import java.util.List;

public class PatientDemographics {
    String patientName;
    List<ContactDetails> contactDetails;

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public List<ContactDetails> getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(List<ContactDetails> contactDetails) {
        this.contactDetails = contactDetails;
    }
}
