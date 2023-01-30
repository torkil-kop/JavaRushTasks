package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

/* 
Генератор паролей
*/

public class Solution {
    public static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream bs = new ByteArrayOutputStream();

        while (true) {
            for (int j = 0; j < 8; j++) {
                bs.write(getChar());
            }
            String str = bs.toString();

            if (str.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$") ) {

                if (!list.contains(str)){
                    list.add(str);
                    break;
                }
            }
            else {
                bs.reset();
            }
        }
        return bs;
    }

    public static int getNumber(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public static int getChar() {
        int min = 48;
        int max = 122;
        int i = getNumber(min, max);
        while (true) {
            if ((i >= 58 && i <= 64) || (i >= 91 && i <= 96)) {
                i = getNumber(min, max);
            } else {
                break;
            }
        }
        return i;
    }


}
