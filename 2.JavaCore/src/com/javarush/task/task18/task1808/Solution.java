package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();
        byte[] buffer;
        try {
            FileInputStream inputStream = new FileInputStream(fileName1);
            FileOutputStream outputStream1 = new FileOutputStream(fileName2);
            FileOutputStream outputStream2 = new FileOutputStream(fileName3);
            // while (inputStream.available() > 0) {
            if (inputStream.available() % 2 > 0) {
                buffer = new byte[inputStream.available() / 2 + 1];
                int count = inputStream.read(buffer);
                outputStream1.write(buffer, 0, count);
            } else if (inputStream.available() % 2 == 0) {
                buffer = new byte[inputStream.available() / 2];
                int count = inputStream.read(buffer);
                outputStream1.write(buffer, 0, count);
            }
            byte[] buffer2 = new byte[inputStream.available()];
            int count2 = inputStream.read(buffer2);
            outputStream2.write(buffer2, 0, count2);
            inputStream.close();
            outputStream1.close();
            outputStream2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

