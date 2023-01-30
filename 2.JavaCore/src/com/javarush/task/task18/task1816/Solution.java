package com.javarush.task.task18.task1816;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream(args[0]);
        int count = 0;
        while (inputStream.available() > 0) {
            int s = inputStream.read();

            if ((s >= 65 && s <= 90) || (s >= 97 && s <= 122)) {
                count++;
            }
        }
        System.out.println(count);
        inputStream.close();
    }
}
