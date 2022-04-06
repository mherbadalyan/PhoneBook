package com.company.service;
import com.company.models.Contact;
import java.util.TreeMap;

public class ContactService {

    /**
     * adding contact to phonebook
     */
    public static void addContact(Contact contact) {
        PhoneBookService.phoneBook.put(contact.getName(), contact);
    }

    /**
     * deleting contact from phonebook
     */
    public static void deleteContact(Contact contact) {
        PhoneBookService.phoneBook.remove(contact.getName());
        System.out.println("Contact successfully deleted");
    }

    /**
     * printing contact info
     */
    public static void printContact(String name) {
        System.out.println(PhoneBookService.phoneBook.get(name));
    }

    /**
     * printing contact list of phonebook
     */
    public static void printPhoneBook() {
        for (String contactName : PhoneBookService.phoneBook.keySet()) {
            System.out.println(contactName);
        }
    }
}
