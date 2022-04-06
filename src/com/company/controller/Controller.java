package com.company.controller;

import com.company.menu.Menu;
import com.company.models.Contact;
import com.company.models.Email;
import com.company.models.PhoneNumber;
import com.company.service.*;
import com.company.validators.Validator;

import java.util.Scanner;
import java.util.TreeMap;


public class Controller {
    Scanner scanner = new Scanner(System.in);
    private final PhoneNumberService phoneNumberService;
    private final EmailService emailService;
    private String inputEmail;
    private String inputPhoneNumber;

    public Controller(PhoneNumberService service, EmailService emailService, PhoneBookService phoneBookService) {
        this.phoneNumberService = service;
        this.emailService = emailService;
    }

    /**
     * creating contact and returning it
     */
    public Contact createContact() {
        System.out.println("Enter name of contact.");
        String name = scanner.nextLine();

        while (!Validator.validName(name)) {
            System.out.println("Invalid name. Please enter valid name.");
            name = scanner.nextLine();
        }

        if (PhoneBookService.phoneBook.containsKey(name)) {
            System.out.println("You already have contact with this name. Choose operation" +
                    "\n1.Update exist contact" +
                    "\n2.Enter another name" +
                    "\nQ.Exit ");

            String choice = scanner.nextLine().toUpperCase();
            while (!Validator.validExistContactMenu(choice)) {
                System.out.println("Invalid choice. Please enter valid choice.");
                choice = scanner.nextLine().toUpperCase();
            }
            switch (choice) {
                case "1":
                    update(PhoneBookService.phoneBook.get(name));
                    break;
                case "2":
                    return createContact();
            }
            return null;
        }

        Contact contact = new Contact(name);
        String operation = Menu.contactFillingMenu();

        while (!operation.equalsIgnoreCase("Q") && !operation.equalsIgnoreCase("S")) {
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
        if (operation.equalsIgnoreCase("Q")) {
            return null;
        }
        return contact;
    }

    /**
     * updating given contact
     */
    public void update(Contact contact) {
        String choice = Menu.updateMenu();
        Contact temp = new Contact(contact);

        while (true) {
            if (choice.equals("Q")) {
                return;
            }
            if (choice.equals("S")) {
                PhoneBookService.phoneBook.put(contact.getName(), temp);
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
                    phoneNumberService.deletePhoneNumber(temp, inputPhoneNumber);
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
                    emailService.deleteEmail(temp, inputEmail);
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

    /**
     * creating Number for contact
     */
    private String createNumber() {
        System.out.println("Enter phone number,that contains only numbers, or on first position '+'. Q for exit");
        String phoneNumber = scanner.nextLine();
        while (!Validator.validPhoneNumber(phoneNumber)) {
            System.out.println("Number is invalid. Please enter valid number.");
            phoneNumber = scanner.nextLine();
        }
        return phoneNumber;
    }

    /**
     * choosing Number type for contact and returning choice
     */
    private String chooseNumberType() {
        System.out.println("Enter mobile type." +
                "\n1.Mobile" +
                "\n2.Home" +
                "\n3.Work" +
                "\nQ.Exit");
        String numberType = scanner.nextLine().toUpperCase();
        while (!Validator.validFirstMenu(numberType)) {
            System.out.println("Invalid choice. Enter valid choice.");
            numberType = scanner.nextLine().toUpperCase();
        }
        return numberType;
    }

    /**
     * receiving contact number ,
     * if contact have that number returning number,
     * else returning null
     */
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

    /**
     * adding number to given contact
     */
    public void addNumber(Contact contact) {
        String numberType = chooseNumberType();
        if (numberType.equalsIgnoreCase("Q")) {
            return;
        }
        inputPhoneNumber = createNumber();
        if (inputPhoneNumber.equalsIgnoreCase("Q")) {
            return;
        }
        phoneNumberService.addPhoneNumber(numberType, inputPhoneNumber, contact);
    }

    /**
     * adding email to given contact
     */
    public void addEmail(Contact contact) {
        String emailType = chooseEmailType();
        if (emailType.equalsIgnoreCase("Q")) {
            return;
        }
        inputEmail = createEmail(emailType);
        if (inputEmail.equalsIgnoreCase("Q")) {
            return;
        }
        emailService.addEmail(emailType, inputEmail, contact);
    }

    /**
     * creating email and returning it in string
     */
    private String createEmail(String emailType) {
        System.out.println("Please enter mail or q for exit");
        String email = scanner.nextLine();

        switch (emailType) {
            case  "1" :
                while (!Validator.validGmail(email)) {
                    System.out.println("Invalid email. Please enter valid email or Q for exit.");
                    email = scanner.nextLine();
                }
                break;
            case "2" :
                while (!Validator.validIcloud(email)) {
                    System.out.println("Invalid email. Please enter valid email or Q for exit");
                    email = scanner.nextLine();
                }
                break;
            case "3" :
                while (!Validator.validEmail(email)) {
                    System.out.println("Invalid email. Please enter valid email or Q for exit");
                    email = scanner.nextLine();
                }
        }
        return email;
    }

    /**
     * choosing email type and returning choice in string
     */
    private String chooseEmailType() {
        System.out.println("Enter email type." +
                "\n1.Gmail" +
                "\n2.Icloud" +
                "\n3.Other" +
                "\nQ.Exit from email type creating menu");
        String emailType = scanner.nextLine().toUpperCase();
        while (!Validator.validFirstMenu(emailType)) {
            System.out.println("Invalid email type. Please select valid.");
            emailType = scanner.nextLine().toUpperCase();
        }
        return emailType;
    }

    /**
     * receiving email for delete,
     * if given contact contains that email returning it ,
     * else returning null
     */
    private String chooseEmailForDelete(Contact contact) {
        System.out.println("Please enter email that you want to delete from contact");
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

    /**
     * adding company to given contact
     */
    public void addCompany(Contact contact) {
        String companyName = createCompanyName();
        if (companyName.equals("Q")) {
            return;
        }
        phoneNumberService.addCompany(companyName, contact);
    }

    /**
     * creating company name for contact
     *
     * @return company name
     */
    private String createCompanyName() {
        System.out.println("Enter company name.");
        String companyName = scanner.nextLine();
        while (!Validator.validName(companyName)) {
            System.out.println("Invalid company name. Please enter valid company name.");
            companyName = scanner.nextLine();
        }
        return companyName;
    }

    /**
     * deleting company name from given contact
     */
    private void deletingCompany(Contact contact) {
        contact.setCompany(null);
    }


    /**
     * searching contact by name in contact list
     */
    public String searchByName() {
        System.out.println("Input name or number of contact ");
        String name = scanner.nextLine();
        if (Validator.validPhoneNumber(name)) {
            return searchByNumber(name);
        } else {
            if (!PhoneBookService.phoneBook.containsKey(name)) {
                System.out.println("There is no contact with this name." +
                        "\n1.Search again" +
                        "\nQ.Exit");
                String searchChoice = scanner.nextLine().toUpperCase();
                while (!Validator.validSearchChoice(searchChoice)) {
                    System.out.println("Invalid choice. Enter valid choice.");
                    searchChoice = scanner.nextLine().toUpperCase();
                }
                return searchChoice;
            }
            return name;
        }

    }

    public String searchByNumber(String number) {
//        System.out.println("Input number of contact");
//        String number = scanner.nextLine();
//        while (!Validator.validPhoneNumber(number)) {
//            System.out.println("Invalid phone number. Enter valid number.");
//            number = scanner.nextLine();
//        }
        int count = 0;
        String temp = null;
        for (String str : PhoneBookService.phoneBook.keySet()) {
            for (int i = 0; i < PhoneBookService.phoneBook.get(str).numbers.size(); i++) {
                if (number.equals(PhoneBookService.phoneBook.get(str).numbers.get(i).getPhoneNumber())) {
                    if (count != 0) {
                        ContactService.printContact(temp);
                    }
                    count++;
                    temp = str;
                    break;
                }
            }
        }
        if (count == 0) {
            return "1";
        }if (count == 1){
            return temp;
        }
        ContactService.printContact(temp);
        System.out.println("There are many contacts with same number, please search again by name.");
        return "Q";
    }

    /**
     * calling contact
     */
    public void call() {
        System.out.println("Number not available");
    }
}
