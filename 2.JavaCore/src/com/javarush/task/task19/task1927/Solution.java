package com.javarush.task.task19.task1927;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Контекстная реклама
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        System.setOut(console);
        String str = outputStream.toString();
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(str.split("\n")));

        try {

            for (int i = 2; i < list.size(); i = i + 3 ) {

                list.add(i, "JavaRush - курсы Java онлайн");
            }
        }
        catch (Exception e){

        }
        for (String s: list
             ) {
            System.out.println(s);
        }
}

public static class TestString {
    public void printSomething() {
        System.out.println("first");
        System.out.println("second");
        System.out.println("third");
        System.out.println("fourth");
        System.out.println("fifth");

    }
}
}
