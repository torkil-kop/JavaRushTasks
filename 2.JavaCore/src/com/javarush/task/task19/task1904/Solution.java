package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.*;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{
private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
        String fullName = fileScanner.nextLine();
          String[] list = fullName.split(" ");
          Date date = new Date(Integer.parseInt(list[5])-1900, Integer.parseInt(list[4])-1,  Integer.parseInt(list[3]));
            return new Person(list[1], list[2], list[0], date);
        }
//Иванов Иван Иванович 31 12 1950
        @Override
        public void close() throws IOException {
fileScanner.close();
        }
    }
}
