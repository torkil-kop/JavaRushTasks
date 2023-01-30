package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
                int count = 1;
        int charRead;
        try (BufferedReader reader1 = new BufferedReader(new FileReader(fileName1));
        BufferedWriter writer = new BufferedWriter((new FileWriter(fileName2)))){
           while (reader1.ready()){
               charRead = reader1.read();
               if (count%2 == 0){
                   writer.write(charRead);
               }
               count++;
           }

        }
    }
}
