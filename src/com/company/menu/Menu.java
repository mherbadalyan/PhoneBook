package com.company.menu;
import com.company.controller.Controller;
import com.company.models.Contact;
import com.company.phoneBook.PhoneBookDB;
import com.company.validators.Validator;

import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    private final Controller controller;

    public Menu(Controller controller) {
        this.controller = controller;
    }

    public void start() {
        System.out.println("Welcome to PhoneBook app.");
        String inputFirstMenu = firstMenu();

        Contact contact;
        while (!inputFirstMenu.equals("Q")) {
            switch (inputFirstMenu) {
                case "1":
                    contact = controller.createContact();
                    if (contact == null) {
                        break;
                    }
                    PhoneBookDB.addContact(contact);
                    break;
                case "2":
                    PhoneBookDB.printPhoneBook();
                    break;
                case "3":
                    String contactName = "1";
                    while (contactName.equals("1")) {
                        contactName = controller.searchByName();
                    }
                    if (!contactName.equals("Q")) {
                        contactMenu(contactName);
                    }
                    break;
            }
            inputFirstMenu = firstMenu();
        }
    }

    private String firstMenu() {
        System.out.println("Please enter operation. " +
                "\n1.Create contact." +
                "\n2.Read contact list." +
                "\n3.Search contact." +
                "\nQ.For exit");

        String inputFirstMenu = scanner.nextLine().toUpperCase();

        while (!Validator.validFirstMenu(inputFirstMenu)) {
            System.out.println("Invalid choice. Please enter again");
            inputFirstMenu = scanner.nextLine().toUpperCase();
        }
        return inputFirstMenu;
    }

    public static String contactFillingMenu() {
        System.out.println("Please enter which of these fields do you wont to fill." +
                "\n1.Add email." +
                "\n2.Add number." +
                "\n3.Add company." +
                "\nS.Save contact and Exit" +
                "\nQ.Exit without save.");
        String operation = scanner.nextLine().toUpperCase();
        while (!Validator.createMenuValidator(operation)) {
            System.out.println("Invalid choice. Please enter valid choice.");
            operation = scanner.nextLine().toUpperCase();
        }
        return operation;
    }

    public  void contactMenu(String contactName) {
        String operation ;
        while (true) {
            PhoneBookDB.printContact(contactName);
            System.out.println("Please enter which of these operations do you want to do." +
                    "\n1.Call." +
                    "\n2.Update." +
                    "\n3.Delete contact." +
                    "\nQ.Exit ");
            operation = scanner.nextLine().toUpperCase();
            while (!Validator.validFirstMenu(operation)) {
                System.out.println("Invalid choice. Please enter valid choice.");
                operation = scanner.nextLine().toUpperCase();
            }
            if (operation.equals("Q")) {
                return;
            }
            switch (operation) {
                case "1":
                    controller.call();
                    break;
                case "2":
                    controller.update(PhoneBookDB.phoneBook.get(contactName));
                    break;
                case "3":
                    PhoneBookDB.deleteContact(PhoneBookDB.phoneBook.get(contactName));
                    return;
            }
        }
    }

    public static String updateMenu() {
        String choice;
        System.out.println("Please enter operation." +
                "\n1.Add number" +
                "\n2.Delete number" +
                "\n3.Add email" +
                "\n4.delete email" +
                "\n5.Change or add company" +
                "\n6.Delete company" +
                "\nS.Save and exit" +
                "\nQ.Exit without save");
        choice = scanner.nextLine().toUpperCase();
        while (!Validator.updateMenuValidator(choice)) {
            System.out.println("Invalid choice. Please enter again.");
            choice = scanner.nextLine().toUpperCase();
        }
        return choice;
    }

}
