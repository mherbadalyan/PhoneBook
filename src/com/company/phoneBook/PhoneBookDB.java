package com.company.phoneBook;

import com.company.models.Contact;

import java.util.TreeMap;

public class PhoneBookDB {
    static TreeMap<String, Contact> phoneBook;

   static void addContact(Contact contact){
       phoneBook.put(contact.getName(),contact);
   }
   static void deleteContact(Contact contact){
       phoneBook.remove(contact.getName());
   }
   static Contact printContact(String name){
       return phoneBook.get(name);
   }
}
