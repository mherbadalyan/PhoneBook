package com.company.controller;
import com.company.menu.Menu;
import com.company.models.Contact;
import com.company.models.Email;
import com.company.models.PhoneNumber;
import com.company.service.Service;
import com.company.validators.Validator;

import java.util.Scanner;

import static com.company.phoneBook.PhoneBookDB.phoneBook;


public class Controller {
    Scanner scanner = new Scanner(System.in);
    private final Service service;
    private String inputEmail;
    private String inputPhoneNumber;

    public Controller(Service service) {
        this.service = service;
    }

    public Contact createContact() {
        System.out.println("Enter name of contact.");
        String name = scanner.nextLine();

        while (!Validator.validName(name)) {
            System.out.println("Invalid name. Please enter valid name.");
            name = scanner.nextLine();
        }

        if (phoneBook.containsKey(name)) {
            System.out.println("You already have contact with this name. Choose operation" +
                    "\n1.Update exist contact" +
                    "\n2.Enter another name" +
                    "\nQ.Exit ");

            String choice = scanner.nextLine();
            while (!Validator.validExistContactMenu(choice)) {
                System.out.println("Invalid choice. Please enter valid choice.");
                choice = scanner.nextLine();
            }
            switch (choice) {
                case "1" :
                    update(phoneBook.get(name));
                    break;
                case "2" :
                    return createContact();
            }
            return null;
        }

        Contact contact = new Contact(name);
        String operation = Menu.contactFillingMenu();

        while (!operation.equals("Q") && !operation.equals("S")) {
            switch (operation) {
                case "1":
                    addEmail(contact);
                    break;
                case "2":
                    addNumber(contact);
                    break;
                case "3":
                    addCompany(contact);
                    break;
            }
            operation = Menu.contactFillingMenu();
        }
        if (operation.equals("Q")) {
            return null;
        }
        return contact;
    }

    public void update(Contact contact) {
        String choice = Menu.updateMenu();
        Contact temp = new Contact(contact);

        while (true) {
            if (choice.equals("Q")) {
                return;
            }
            if (choice.equals("S")) {
                 phoneBook.put(contact.getName(),temp);
                 return;
            }
            switch (choice) {
                case "1":
                    addNumber(temp);
                    System.out.println("Number successfully added");
                    break;
                case "2":
                    inputPhoneNumber = choosePhoneNumberForDelete(temp);
                    if (inputPhoneNumber == null) {
                        System.out.println("Contact have not entered number.");
                        break;
                    }
                    service.deletePhoneNumber(temp, inputPhoneNumber);
                    System.out.println("Phone number successfully deleted");
                    break;
                case "3":
                    addEmail(temp);
                    System.out.println("Email successfully added");
                    break;
                case "4":
                    inputEmail = chooseEmailForDelete(temp);
                    if (inputEmail == null) {
                        System.out.println("Contact have not entered email");
                        break;
                    }
                    service.deleteEmail(temp, inputEmail);
                    System.out.println("Email successfully deleted");
                    break;
                case "5":
                    addCompany(temp);
                    System.out.println("Company successfully changed");
                    break;
                case "6":
                    deletingCompany(temp);
                    System.out.println("Number successfully deleted");
                    break;
            }
            choice = Menu.updateMenu();
        }
    }

    private String createNumber() {
        System.out.println("Enter phone number,that contains only numbers, or on first position '+'. Q for exit");
        String phoneNumber = scanner.nextLine();
        while (!Validator.validPhoneNumber(phoneNumber)) {
            System.out.println("Number is invalid. Please enter valid number.");
            phoneNumber = scanner.nextLine();
        }
        return phoneNumber;
    }

    private String chooseNumberType() {
        System.out.println("Enter mobile type." +
                "\n1.Mobile" +
                "\n2.Home" +
                "\n3.Work" +
                "\nQ.Exit");
        String numberType = scanner.nextLine();
        while (!Validator.validFirstMenu(numberType)) {
            System.out.println("Invalid choice. Enter valid choice.");
            numberType = scanner.nextLine();
        }
        return numberType;
    }

    private String choosePhoneNumberForDelete(Contact contact) {
        System.out.println("Please enter phone number that you want to delete from contact");
        String deletingPhoneNumber = scanner.nextLine();

        while (!Validator.validPhoneNumber(deletingPhoneNumber)) {
            System.out.println("Invalid phone number.Please enter valid phone number");
            deletingPhoneNumber = scanner.nextLine();
        }

        for (PhoneNumber phoneNumber : contact.numbers) {
            if (phoneNumber.getPhoneNumber().equals(deletingPhoneNumber)) {
                return deletingPhoneNumber;
            }
        }
        return null;
    }

    public void addNumber(Contact contact) {
        String numberType = chooseNumberType();
        if (numberType.equals("Q")) {
            return;
        }
        inputPhoneNumber = createNumber();
        if (inputPhoneNumber.equals("Q")) {
            return;
        }
        service.addNumber(numberType, inputPhoneNumber, contact);
    }

    public void addEmail(Contact contact) {
        String emailType = chooseEmailType();
        if (emailType.equals("Q")) {
            return;
        }
        inputEmail = createEmail();
        if (inputEmail.equals("Q")) {
           return;
        }
        service.addEmail(emailType, inputEmail, contact);
    }

    private String createEmail() {
        System.out.println("Please enter mail.");
        String email = scanner.nextLine();
        while (!Validator.validEmail(email)) {
            System.out.println("Invalid email. Please enter valid email.");
            email = scanner.nextLine();
        }
        return email;
    }

    private String chooseEmailType() {
        System.out.println("Enter email type." +
                "\n1.Gmail" +
                "\n2.Icloud" +
                "\n3.Other" +
                "\nQ.Exit from email type creating menu");
        String emailType = scanner.nextLine();
        while (!Validator.validFirstMenu(emailType)) {
            System.out.println("Invalid email type. Please select valid.");
            emailType = scanner.nextLine();
        }
        return emailType;
    }

    private String chooseEmailForDelete(Contact contact) {
        System.out.println("Please enter phone number that you want to delete from contact");
        String deletingEmail = scanner.nextLine();

        while (!Validator.validEmail(deletingEmail)) {
            System.out.println("Invalid email.Please enter valid email");
            deletingEmail = scanner.nextLine();
        }

        for (Email email : contact.emails) {
            if (email.getEmail().equals(deletingEmail)) {
                return deletingEmail;
            }
        }
        return null;
    }

    public void addCompany(Contact contact) {
        String companyName = createCompanyName();
        if (companyName.equals("Q")) {
            return;
        }
        service.addCompany(companyName, contact);
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

    private void deletingCompany(Contact contact) {
        contact.setCompany(null);
    }

    public String searchByName() {
        System.out.println("Input name of contact");
        String name = scanner.nextLine();
        if (!phoneBook.containsKey(name)) {
            System.out.println("There is no contact with this name." +
                    "\n1.Search again" +
                    "\nQ.Exit");
            String searchChoice = scanner.nextLine();
            while (!Validator.validSearchChoice(searchChoice)) {
                System.out.println("Invalid choice. Enter valid choice.");
                searchChoice = scanner.nextLine();
            }
            return searchChoice;
        }
        return name;
    }

    public void call() {
        System.out.println("Number not available");
    }
}
