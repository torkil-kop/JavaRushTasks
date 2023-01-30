package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        try {
            FileInputStream inputStream = new FileInputStream(fileName1);
            FileOutputStream outputStream = new FileOutputStream(fileName2);
            byte[] bytes = new byte[inputStream.available()];
            int data = inputStream.read(bytes);
            for (int i = data-1; i >= 0; i--) {
                outputStream.write(bytes[i]);
            }
            inputStream.close();
            outputStream.close();
        }
       catch (Exception e){
            e.printStackTrace();
       }
    }
}
