package com.company.service;

import com.company.models.Contact;
import com.company.models.Email;
import com.company.models.EmailType;

public class EmailService {

    /**
     * adding email to given contact
     * @param choice - emailType
     * @param inputEmail - email
     * @param contact
     */
    public void addEmail(String choice, String inputEmail, Contact contact) {
        Email email;
        switch (choice) {
            case "1":
                email = new Email(EmailType.GMAIL,inputEmail);
                break;
            case "2":
                email = new Email(EmailType.ICLOUD,inputEmail);
                break;
            case "3":
                email = new Email(EmailType.OTHER,inputEmail);
                break;
            default:
                return;
        }
        contact.emails.add(email);
    }

    /**
     * deleting given email from given contact
     *
     * @param contact
     * @param inputEmail
     */
    public void deleteEmail(Contact contact, String inputEmail) {
        int size = contact.emails.size();
        for (int i = 0; i < size; i++) {
            if (contact.emails.get(i).getEmail().equals(inputEmail)) {
                contact.emails.remove(i);
                break;
            }
        }
    }
}
