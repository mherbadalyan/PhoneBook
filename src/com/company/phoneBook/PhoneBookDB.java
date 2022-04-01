package com.company.phoneBook;
import com.company.models.Contact;
import java.util.TreeMap;

public class PhoneBookDB {
    public static TreeMap<String, Contact> phoneBook = new TreeMap<>();

   public static void addContact(Contact contact){
       phoneBook.put(contact.getName(),contact);
   }

   public static void deleteContact(Contact contact){
       phoneBook.remove(contact.getName());
   }

   public static void printContact(String name){
       System.out.println(phoneBook.get(name));
   }

   public static void printPhoneBook(){
       for (String contactName : phoneBook.keySet()) {
           System.out.println(contactName);
       }
   }
}
