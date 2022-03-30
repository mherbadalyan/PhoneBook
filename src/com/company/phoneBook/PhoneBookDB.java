package com.company.phoneBook;

import com.company.models.Contact;

import java.util.Map;
import java.util.TreeMap;

public class PhoneBookDB {
    static TreeMap<String, Contact> phoneBook = new TreeMap<>();

   public static void addContact(Contact contact){
       phoneBook.put(contact.getName(),contact);
   }
   public static void deleteContact(Contact contact){
       phoneBook.remove(contact.getName());
   }
   public static Contact printContact(String name){
       return phoneBook.get(name);
   }
   public static void printPhoneBook(){
       for (String contactName : phoneBook.keySet()) {
           System.out.println(contactName);
       }
   }
}
