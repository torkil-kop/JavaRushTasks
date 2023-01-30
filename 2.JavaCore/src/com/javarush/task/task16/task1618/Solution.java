package com.javarush.task.task16.task1618;

/* 
Снова interrupt
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
      TestThread thread = new TestThread();
       thread.start();
       thread.interrupt();
    }

    //Add your code below - добавь код ниже
    public static class TestThread extends Thread{
        @Override
        public void run() {

        }
    }
}
/*
. Класс TestThread должен быть унаследован от Thread.
2. Класс TestThread должен иметь public void метод run.
3. Метод main должен создавать объект типа TestThread.
4. Метод main должен вызывать метод start у объекта типа TestThread.
5. Метод main должен вызывать метод interrupt у объекта типа TestThread.
 */