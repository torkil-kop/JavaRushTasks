package com.javarush.task.task16.task1621;

/* 
Thread.currentThread - всегда возвращает текущую нить
*/

public class Solution {
    static int count = 5;

    public static void main(String[] args) {
        ThreadNamePrinter tnp = new ThreadNamePrinter();
        tnp.start();
        for (int i = 0; i < count; i++) {
            tnp.printMsg();
        }
    }

    public static class ThreadNamePrinter extends Thread {
        public void run() {
            for (int i = 0; i < count; i++) {
                printMsg();
            }
        }

        public void printMsg() {
            Thread t = Thread.currentThread();
            String name = t.getName();
            System.out.println("Name=" + name);
            try {

                Thread.sleep(1);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
/*
Thread.currentThread - всегда возвращает текущую нить
1. В методе printMsg присвой переменной t текущую нить.
2. В методе printMsg после всех действий поставь задержку в 1 миллисекунду.


Requirements:
1. Метод printMsg должен получать текущую нить с помощью Thread.currentThread.
2. Метод printMsg должен должен усыплять нить на 1 миллисекунду.
3. Метод printMsg должен вызывать метод getName у текущей нити.
4. Метод main должен вызвать метод printMsg у объекта типа ThreadNamePrinter 5 раз.
5. Метод run должен вызвать метод printMsg 5 раз.
6. Метод printMsg у объекта типа ThreadNamePrinter суммарно должен быть вызван 10 раз.
 */