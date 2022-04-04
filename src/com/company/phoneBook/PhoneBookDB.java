package com.company.phoneBook;
import com.company.models.Contact;
import java.util.TreeMap;

public class PhoneBookDB {
    public static TreeMap<String, Contact> phoneBook = new TreeMap<>();

    /**
     * adding contact to phonebook
     */
   public static void addContact(Contact contact){
       phoneBook.put(contact.getName(),contact);
   }

    /**
     * deleting contact from phonebook
     *
     */
   public static void deleteContact(Contact contact){
       phoneBook.remove(contact.getName());
       System.out.println("Contact successfully deleted");
   }

    /**
     * printing contact info
     *
     */
   public static void printContact(String name){
       System.out.println(phoneBook.get(name));
   }

    /**
     * printing contact list of phonebook
     */
   public static void printPhoneBook(){
       for (String contactName : phoneBook.keySet()) {
           System.out.println(contactName);
       }
   }
}
