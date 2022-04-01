package com.company.models;
public class Email {

    private EmailType emailType;
    private String email;

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