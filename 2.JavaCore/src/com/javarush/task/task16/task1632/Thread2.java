package com.javarush.task.task16.task1632;

public class Thread2 extends Thread{
    @Override
    public void run() {
        try {
            while (currentThread().isInterrupted()){
                System.out.println("Hello");
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e){
            System.out.println("InterruptedException");
        }
    }
}
