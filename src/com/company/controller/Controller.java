package com.company.controller;

import com.company.menu.Menu;
import com.company.models.Contact;
import com.company.service.Service;
import com.company.validators.Validator;

import java.util.Scanner;


public class Controller {
    Scanner scanner = new Scanner(System.in);
    private Service service;
    private String operation;
    private String emailType;
    private String email;
    private String numberType;
    private String inputPhoneNumber;
    private String companyName;

    public Controller(Service service) {
        this.service = service;
    }

    public Contact createContact() {
        System.out.println("Enter name of contact.");
        String name = scanner.nextLine();

        while (!Validator.validName(name)){
            System.out.println("Invalid name. Please enter valid name.");
            name = scanner.nextLine();
        }
        Contact contact = new Contact(name);
        operation = Menu.contactFillingMenu();

        while (!operation.equals("Q") && !operation.equals("S")) {
            switch (operation) {
                case "1":
                    emailType = choiceEmailType();
                    if (emailType.equals("Q")) {
                        break;
                    }
                    email = createEmail();
                    if (email.equals("Q")) {
                         break;
                    }
                    service.addEmail(emailType,email,contact);
                    break;
                case "2":
                    numberType = choiceNumberType();
                    if (numberType.equals("Q")) {
                        break;
                    }
                    inputPhoneNumber = createNumber();
                    if (inputPhoneNumber.equals("Q")) {
                        break;
                    }
                    service.addNumber(numberType, inputPhoneNumber, contact);
                    break;
                case "3":
                    companyName = createCompanyName();
                    if (companyName.equals("Q")) {
                        break;
                    }
                    service.addCompany(companyName,contact);
                    break;
            }
            operation = Menu.contactFillingMenu();
        }
        if (operation.equals("Q")){
            return null;
        }
        return contact;
    }

    private String createCompanyName() {
        System.out.println("Enter company name.");
        String companyName = scanner.nextLine();
        while (!Validator.validName(companyName)) {
            System.out.println("Invalid company name. Please enter valid company name.");
            companyName = scanner.nextLine();
        }
        return companyName;
    }

    private String createEmail() {
        System.out.println("Please enter mail.");
        String email = scanner.nextLine();
        while (!Validator.validEmailType(email)) {
            System.out.println("Invalid email. Please enter valid email.");
            email = scanner.nextLine();
        }
        return email;
    }

    private String choiceEmailType() {
        System.out.println("Enter email type." +
                "\n1.Gmail" +
                "\n2.Icloud" +
                "\n3.Other" +
                "\nQ.Exit from email type creating menu");
        String emailType = scanner.nextLine();
        while (!Validator.isValidFirstMenu(emailType)) {
            System.out.println("Invalid email type. Please select valid.");
            emailType = scanner.nextLine();
        }
        return emailType;
    }

    private String createNumber() {
        System.out.println("Enter phone number,that contains only numbers, or on first position '+'. Q for exit");
        String phoneNumber = scanner.nextLine();
        while (!Validator.validNumber(phoneNumber)) {
            System.out.println("Number is invalid. Please enter valid number.");
            phoneNumber = scanner.nextLine();
        }
        return phoneNumber;
    }

    private String choiceNumberType() {
        System.out.println("Enter mobile type." +
                "\n1.Mobile" +
                "\n2.Home" +
                "\n3.Work" +
                "\nQ.Exit");
        String numberType = scanner.nextLine();
        while (!Validator.isValidFirstMenu(numberType)) {
            System.out.println("Invalid choice. Enter valid choice.");
            numberType = scanner.nextLine();
        }
        return numberType;
    }

}
