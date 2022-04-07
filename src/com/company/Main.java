package com.company;

import com.company.controller.Controller;
import com.company.menu.Menu;
import com.company.service.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Menu menu = new Menu(new Controller(new PhoneNumberService(), new EmailService(), new PhoneBookService()));
        menu.start();
    }
}
