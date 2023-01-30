package com.javarush.task.task18.task1824;

import java.io.*;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String str = "fdswf";
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            str = reader.readLine();
            try (BufferedReader reader2 = new BufferedReader(new FileReader(str))){




            } catch (FileNotFoundException e) {
                System.out.println(str);
                reader.close();
break;
            }

        }
    }

}
