package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        System.setOut(consoleStream);
        String str = outputStream.toString();
        String[] i = str.split(" ");
               switch (i[1]) {
            case "+":
                str = str.replaceAll(" $", " " + (Integer.parseInt(i[0]) + Integer.parseInt(i[2])));
            case "*":
                str = str.replaceAll(" $", " " + (Integer.parseInt(i[0]) * Integer.parseInt(i[2])));
            case "-":
                str = str.replaceAll(" $", " " + (Integer.parseInt(i[0]) - Integer.parseInt(i[2])));
        }
        System.out.println(str);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

