package com.company.service;
import com.company.models.Contact;

import java.util.ArrayList;

public class Service {
//    private HashMap<String,Contact> phonebook;

    public Contact create(){
        return null;
    }

    public void read(){

    }

    public Contact search() {
        return null;
    }

    public ArrayList<Contact.Email> mail() {
        return null;
    }

    public void call() {
    }

    public void delete() {
    }

    public void update() {
    }

    public void printContactList(){

    }

    public void addNumber(String choice,String Number,Contact contact) {

        Contact.PhoneNumber number = Contact.PhoneNumber.HOME;
        number.setPhoneNumber(Number);
        contact.numbers.add(number);
    }
    public void addEmail(String choice,String email){
    }
}
