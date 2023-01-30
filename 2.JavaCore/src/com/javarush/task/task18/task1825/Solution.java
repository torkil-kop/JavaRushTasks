package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        ArrayList<String> list = new ArrayList<>();
        while (!(fileName = reader.readLine()).equals("end")) {
            list.add(fileName);
        }
        reader.close();
        Collections.sort(list);
        int index = list.get(0).lastIndexOf(".");
        String finalFileName = list.get(0).substring(0, index);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(finalFileName))) {
            for (String filename2 : list
            ) {
                try (BufferedReader reader2 = new BufferedReader(new FileReader(filename2))) {
                    while (reader2.ready()) {

                       writer.write(reader2.read());
                    }
                }
            }
        }
    }
}
