package com.company.controller;

import com.company.models.Contact;
import com.company.service.Service;

import java.util.HashMap;
import java.util.TreeMap;

public class Controller {
    private Service service;
    private TreeMap<String, Contact> phoneBook;

    public Controller(Service service, TreeMap<String, Contact> phoneBook) {
        this.service = service;
        this.phoneBook = phoneBook;
    }

    public Contact createContact() {
        return null;
    }

}
