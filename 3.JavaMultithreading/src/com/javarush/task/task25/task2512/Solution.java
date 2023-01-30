package com.javarush.task.task25.task2512;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Живем своим умом
*/

public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        List<String> strings = new ArrayList<>();
        while (e!=null){
strings.add(e.toString());
e = e.getCause();
        }
        for (int i = strings.size()-1; i >= 0; i--) {
            System.out.println(strings.get(i));
        }

    }

    public static void main(String[] args) {
    }
}
/*
Живем своим умом
В классе Solution реализуй интерфейс UncaughtExceptionHandler, который должен:
1. прервать нить, которая бросила исключение.
2. вывести в консоль стек исключений, начиная с самого вложенного.

Пример исключения:
new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")))

Пример вывода:
java.lang.IllegalAccessException: GHI
java.lang.RuntimeException: DEF
java.lang.Exception: ABC


Requirements:
1. Класс Solution должен реализовывать интерфейс Thread.UncaughtExceptionHandler.
2. После вызова uncaughtException нужно прервать нить, которая бросила исключение.
3. Затем, вывести в консоль стек исключений, начиная с самого вложенного исключения.
4. Сообщения должны выводиться в формате "exception class: exception message".
 */