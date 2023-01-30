package com.javarush.task.task32.task3213;

import java.io.*;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {

        String str = "";
        byte[] bytes = new byte[1024];
        int i = 0;
        int b;
        if (reader != null) {
            while ( (b = reader.read()) != -1) {

                bytes[i] = (byte) (b + key);
                i++;

            }
            String s = new String(bytes);
            str = (str +s).trim();
        }
        return str;
    }
}
