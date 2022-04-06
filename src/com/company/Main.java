package com.company;
import com.company.controller.Controller;
import com.company.menu.Menu;
import com.company.models.Contact;
import com.company.service.EmailService;
import com.company.service.PhoneBookService;
import com.company.service.PhoneNumberService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {


        Menu menu = new Menu(new Controller(new PhoneNumberService(),new EmailService(), new PhoneBookService()));
        menu.start();
    }

}
