package com.company.controller;

import com.company.models.Contact;
import com.company.service.Service;

import java.util.TreeMap;

public class Controller {
    private Service service;

    public Controller(Service service) {
        this.service = service;
    }

    public Contact createContact() {
        return null;
    }

}
