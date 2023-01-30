package com.javarush.task.task18.task1826;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[1]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[2]));
        char s;
        ArrayList<Character> list = new ArrayList<>();
        try {
            switch (args[0]) {
                case "-e":
                    while (reader.ready()) {
                        s = (char) reader.read();
                        list.add(s);
                    }
                    Collections.reverse(list);
                    System.out.println(list);
                    for (Character c : list
                    ) {
                        writer.write(c);
                    }
                    reader.close();
                    writer.close();
                    break;
                case "-d":
                    while (reader.ready()) {
                        s = (char) reader.read();
                        list.add(s);
                    }
                    Collections.reverse(list);
                    for (Character c : list
                    ) {
                        writer.write(c);
                    }
                    reader.close();
                    writer.close();
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
/*
-e fileName fileOutputName
-d fileName fileOutputName
 */