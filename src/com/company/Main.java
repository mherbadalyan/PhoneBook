package com.company;

import com.company.controller.Controller;
import com.company.menu.Menu;
import com.company.service.Service;

import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu(new Controller(new Service()));
        menu.start();
        int test = 10;
    }
}
