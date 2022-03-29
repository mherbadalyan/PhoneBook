package com.company;

import com.company.controller.Controller;
import com.company.service.Service;

import java.util.HashMap;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller(new Service(),new TreeMap<>());

    }
}
