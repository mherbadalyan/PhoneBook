package com.company.models;
import java.util.ArrayList;

public class Contact {
    private String name;
    private String company;
    public ArrayList<PhoneNumber> numbers ;
    public ArrayList<Email> emails ;

    public Contact(String name) {
        this.name = name;
    }

    public enum PhoneNumber {
        MOBILE, HOME, WORK;

        private String phoneNumber;

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }


    }

    public enum Email {
        GMAIL, ICLOUD, OTHER;
        private String email;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public ArrayList<PhoneNumber> getNumbers() {
        return numbers;
    }

    public void setNumbers(ArrayList<PhoneNumber> numbers) {
        this.numbers = numbers;
    }

    public ArrayList<Email> getEmails() {
        return emails;
    }

    public void setEmails(ArrayList<Email> emails) {
        this.emails = emails;
    }
}
