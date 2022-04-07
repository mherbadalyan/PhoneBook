package com.company.service;

import com.company.models.Contact;

public class ContactService {

    /**
     * adding contact to phonebook
     */
    public static void addContact(Contact contact) {
        PhoneBookService.phoneBook.put(contact.getName().toLowerCase(), contact);
    }

    /**
     * deleting contact from phonebook
     */
    public static void deleteContact(String key) {
        PhoneBookService.phoneBook.remove(key);
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
        int count = 0;
        for (String contactName : PhoneBookService.phoneBook.keySet()) {
            System.out.println(PhoneBookService.phoneBook.get(contactName).getName());
            count++;
        }
        if (count == 0) {
            System.out.println("There is not contacts in phonebook.");
        }
    }
}
