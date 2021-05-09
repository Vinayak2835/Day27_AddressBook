package com.adressBook;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileIOService {
    public static String ADDRESS_BOOK_FILE_NAME = "Contacts.txt";

     /**
     * writes to a text file
     * @param contactsList
     */
    public void writeToFile(List<ContactPOJO> contactsList) {
        StringBuffer contactBuffer = new StringBuffer();
        contactsList.forEach(contacts -> {
            String contact = contacts.toString().concat("\n");
            contactBuffer.append(contact);
        });
        try {
            Files.write(Paths.get(ADDRESS_BOOK_FILE_NAME), contactBuffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printData() {
        try {
            Files.lines(new File(ADDRESS_BOOK_FILE_NAME).toPath()).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
