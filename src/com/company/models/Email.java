package com.company.models;

import java.io.Serializable;

public class Email implements Serializable {

    private EmailType emailType;
    private String email;
    private static final long serialVersionUID = 1212315643L;

    public Email(EmailType emailType, String email) {
        this.emailType = emailType;
        this.email = email;
    }

    public Email(Email email) {
        this.emailType = email.emailType;
        this.email = email.email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EmailType getEmailType() {
        return emailType;
    }

    public void setEmailType(EmailType emailType) {
        this.emailType = emailType;
    }

    @Override
    public String toString() {
        return emailType + " " + email;
    }
}