package com.company.models;
import java.util.ArrayList;
import java.util.Objects;

public class Contact {
    private String name;
    private String company;
    public ArrayList<PhoneNumber> numbers ;
    public ArrayList<Email> emails ;

    public Contact(String name) {
        this.name = name;
        this.numbers = new ArrayList<>();
        this.emails = new ArrayList<>();
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

        @Override
        public String toString() {
            return name() + " " + phoneNumber;
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

        @Override
        public String toString() {
            return name() + " " + email;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(name, contact.name) && Objects.equals(company, contact.company) && Objects.equals(numbers, contact.numbers) && Objects.equals(emails, contact.emails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, company, numbers, emails);
    }

    @Override
    public String toString() {
        StringBuilder contact = new StringBuilder();
        if (company != null) {
            contact.append(" Company( ");
            contact.append(company);
            contact.append(" )");
        }
        if (numbers.size() != 0) {
            contact.append(" Numbers(");
            contact.append(numbers);
            contact.append(" )");
        }
        if (emails.size() != 0) {
            contact.append(" Emails(");
            contact.append(emails);
            contact.append(" ) ");
        }
        return String.valueOf(contact);
    }
}
