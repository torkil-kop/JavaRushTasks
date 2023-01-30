package com.javarush.task.task32.task3202;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем из потока
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter stringWriter = new StringWriter();
        if (is != null) {
            byte[] bytes = new byte[1024];
            List<Byte> list = new ArrayList<>();
            int i = 0;
            while (is.available() > 0) {
//            bytes = is.readAllBytes();
                int b = is.read();
                byte bb = (byte) b;
                bytes[i] = bb;
                i++;
            }

            String str = new String(bytes);
            str = str.trim();

            stringWriter.write(str);
        }

        return stringWriter;
    }
}
