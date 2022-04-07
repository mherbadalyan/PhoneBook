package com.company.menu;

import com.company.controller.Controller;
import com.company.models.Contact;
import com.company.service.*;
import com.company.validators.Validator;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    private final Controller controller;

    public Menu(Controller controller) {
        this.controller = controller;
    }

    /**
     * start method of app Phonebook
     * in this menu user doing choice between this actions
     * 1.Create contact.
     * 2.Read contact list." +
     * 3.Search contact." +
     * exit app
     */
    public void start() throws IOException {
        System.out.println("Welcome to PhoneBook app.");
        String inputFirstMenu = firstMenu();

        Contact contact;
        while (!inputFirstMenu.equalsIgnoreCase("Q")) {
            switch (inputFirstMenu) {
                case "1":
                    contact = controller.createContact();
                    if (contact == null) {
                        break;
                    }
                    ContactService.addContact(contact);
                    break;
                case "2":
                    ContactService.printPhoneBook();
                    break;
                case "3":
                    String contactName = "1";
                    while (contactName.equals("1")) {
                        contactName = controller.searchByName();
                    }
                    if (!contactName.equalsIgnoreCase("Q")) {
                        contactMenu(contactName);
                    }
                    break;
            }
            inputFirstMenu = firstMenu();
        }
        PhoneBookService.savePhoneBookToFile();
    }

    /**
     * printing first menu and returning choice from that actions
     */
    private String firstMenu() {
        System.out.println("Please enter operation. " +
                "\n1.Create contact." +
                "\n2.Read contact list." +
                "\n3.Search contact." +
                "\nQ.For exit");

        String inputFirstMenu = scanner.nextLine();

        while (!Validator.validFirstMenu(inputFirstMenu)) {
            System.out.println("Invalid choice. Please enter again");
            inputFirstMenu = scanner.nextLine();
        }
        return inputFirstMenu;
    }

    /**
     * printing menu for filling contact information and returning choice from that actions
     */
    public static String contactFillingMenu() {
        System.out.println("Please enter which of these fields do you wont to fill." +
                "\n1.Add email." +
                "\n2.Add number." +
                "\n3.Add company." +
                "\nS.Save contact and Exit" +
                "\nQ.Exit without save.");

        String operation = scanner.nextLine();

        while (!Validator.createMenuValidator(operation)) {
            System.out.println("Invalid choice. Please enter valid choice.");
            operation = scanner.nextLine();
        }
        return operation;
    }

    /**
     * printing menu where user choosing action that he want to do when find contact
     */
    public void contactMenu(String contactName) {
        String operation;

        while (true) {
            ContactService.printContact(contactName);
            System.out.println("Please enter which of these operations do you want to do." +
                    "\n1.Call." +
                    "\n2.Update." +
                    "\n3.Delete contact." +
                    "\nQ.Exit ");

            operation = scanner.nextLine();

            while (!Validator.validFirstMenu(operation)) {
                System.out.println("Invalid choice. Please enter valid choice.");
                operation = scanner.nextLine();
            }

            if (operation.equalsIgnoreCase("Q")) {
                return;
            }

            switch (operation) {
                case "1":
                    controller.call();
                    break;
                case "2":
                    controller.update(PhoneBookService.phoneBook.get(contactName));
                    break;
                case "3":
                    ContactService.deleteContact(contactName);
                    return;
            }
        }
    }

    /**
     * printing contact update menu and returning choice of that actions
     */
    public static String updateMenu(Contact contact) {
        String choice;

        System.out.println(contact);
        System.out.println("Please enter operation." +
                "\n1.Add number" +
                "\n2.Delete number" +
                "\n3.Add email" +
                "\n4.delete email" +
                "\n5.Change or add company" +
                "\n6.Delete company" +
                "\nS.Save and exit" +
                "\nQ.Exit without save");

        choice = scanner.nextLine();

        while (!Validator.updateMenuValidator(choice)) {
            System.out.println("Invalid choice. Please enter again.");
            choice = scanner.nextLine();
        }
        return choice;
    }

}
