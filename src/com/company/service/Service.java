package com.company.service;
import com.company.models.*;

public class Service {
    /**
     * deleting given phone number from given contact
     * @param contact
     * @param number
     */
    public void deletePhoneNumber(Contact contact, String number) {
        int size = contact.numbers.size();
        for (int i = 0; i < size; i++) {
            if (contact.numbers.get(i).getPhoneNumber().equals(number)){
                contact.numbers.remove(i);
                break;
            }
        }
    }

    /**
     * adding number to given contact
     * @param choice - phoneNumber type
     * @param inputNumber - phoneNumber
     * @param contact
     */
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
     * adding given company to given contact
     * @param companyName
     * @param contact
     */
    public void addCompany(String companyName, Contact contact) {
        contact.setCompany(companyName);
    }

    /**
     * deleting given email from given contact
     * @param contact
     * @param inputEmail
     */
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
