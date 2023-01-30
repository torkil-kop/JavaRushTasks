package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;

/* 
Пунктуация
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();
        int c;
        String str = "";
        StringBuilder sb = new StringBuilder(str);
        try (BufferedReader reader1 = new BufferedReader(new FileReader(fileName1));
             BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2))) {
            while (reader1.ready()) {
                sb.append((char) reader1.read());
            }
            str = sb.toString().replaceAll("\\p{P}|\\n|\\r", "");

            writer.write(str);
        }
    }
}

