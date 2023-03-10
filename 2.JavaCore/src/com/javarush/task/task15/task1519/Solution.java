package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String key = reader.readLine();
        while (!key.equals("exit")) {
            try {


                if (key.contains(".")) {

                    print(Double.parseDouble(key));
                } else if (Integer.parseInt(key) > 0 && Integer.parseInt(key) < 128) {
                    print(Short.parseShort(key));
                } else if (Integer.parseInt(key) <= 0 || Integer.parseInt(key) >= 128) {
                    print(Integer.parseInt(key));
                }
            }
           catch (Exception e){
                print(key);
           }
            key = reader.readLine();
        }
        reader.close();
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
  /*  Разные методы для разных типов
        В этой задаче тебе нужно:
        Считывать с консоли данные, пока не будет введено слово "exit".
        Для каждого значения, кроме "exit", вызвать метод print(). Если значение:
        содержит точку '.', вызвать метод print() для Double;
        больше нуля, но меньше 128, вызвать метод print() для short;
        меньше либо равно нулю или больше либо равно 128, вызвать метод print() для Integer;
        иначе — вызвать метод print() для String.

        Requirements:
        1. Программа должна считывать данные с клавиатуры.
        2. Программа должна прекращать считывать данные с клавиатуры после того, как введена строка "exit".
        3. Если введенная строка содержит точку("."), и ее можно корректно преобразовать в число типа Double - должен быть вызван метод print(Double value).
        4. Если введенная строка может быть корректно преобразована в число типа short и полученное число больше 0, но меньше 128 - должен быть вызван метод print(short value).
        5. Если введенная строка может быть корректно преобразована в число типа Integer и полученное число меньше или равно 0 или больше или равно 128 - должен быть вызван метод print(Integer value).
        6. Во всех остальных случаях должен быть вызван метод print(String value).
        */
