package com.company.service;

import com.company.models.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.TreeMap;

public class PhoneBookService {
    public static TreeMap<String, Contact> phoneBook;
    static File file = new File("C:\\Users\\HP\\PhoneBook\\src\\com\\company\\files\\PhoneBook.txt");
    static {
        try {
            readPhoneBookFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void readPhoneBookFromFile() throws IOException, ClassNotFoundException {
        if (!file.exists()) {
            file.createNewFile();
            phoneBook = new TreeMap<>();
            savePhoneBookToFile();
        }else {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            phoneBook = (TreeMap<String, Contact>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();

        }
    }
    public static void savePhoneBookToFile () throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file, false);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(phoneBook);
        objectOutputStream.flush();
        objectOutputStream.close();
    }
}
