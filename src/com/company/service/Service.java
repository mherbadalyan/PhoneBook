package com.company.service;
import com.company.models.Contact;

import java.util.ArrayList;

public class Service {

    public void read(Contact contact) {
        System.out.println(contact);
    }

    public Contact search() {
        return null;
    }

    public ArrayList<Contact.Email> mail() {
        return null;
    }



    public void deletePhoneNumber(Contact contact, String number) {
        int size = contact.numbers.size();
        for (int i = 0; i < size; i++) {
            if (contact.numbers.get(i).getPhoneNumber().equals(number)){
                contact.numbers.remove(i);
                break;
            }
        }
    }

    public void addNumber(String choice, String inputNumber, Contact contact) {
        Contact.PhoneNumber number;
        switch (choice) {
            case "1":
                number = Contact.PhoneNumber.MOBILE;
                number.setPhoneNumber(inputNumber);
                break;
            case "2":
                number = Contact.PhoneNumber.HOME;
                number.setPhoneNumber(inputNumber);
                break;
            case "3":
                number = Contact.PhoneNumber.WORK;
                number.setPhoneNumber(inputNumber);
                break;
            default:
                return;
        }
        contact.numbers.add(number);
    }

    public void addEmail(String choice, String inputEmail, Contact contact) {
        Contact.Email email;
        switch (choice) {
            case "1":
                email = Contact.Email.GMAIL;
                email.setEmail(inputEmail);
                break;
            case "2":
                email = Contact.Email.ICLOUD;
                email.setEmail(inputEmail);
                break;
            case "3":
                email = Contact.Email.OTHER;
                email.setEmail(inputEmail);
                break;
            default:
                return;
        }
        contact.emails.add(email);
    }

    public void addCompany(String companyName, Contact contact) {
        contact.setCompany(companyName);
    }

    public void deleteEmail(Contact contact, String inputEmail) {
        int size = contact.emails.size();
        for (int i = 0; i < size; i++) {
            if (contact.emails.get(i).getEmail().equals(inputEmail)){
                contact.emails.remove(i);
                break;
            }
        }
    }
}
