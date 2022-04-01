package com.company.service;
import com.company.models.*;

public class Service {

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
        PhoneNumber number;
        switch (choice) {
            case "1":
                number = new PhoneNumber(PhoneNumberType.MOBILE,inputNumber);
                break;
            case "2":
                number = new PhoneNumber(PhoneNumberType.HOME,inputNumber);
                break;
            case "3":
                number = new PhoneNumber(PhoneNumberType.WORK,inputNumber);
                break;
            default:
                return;
        }
        contact.numbers.add(number);
    }

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
