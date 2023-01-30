package com.javarush.task.task16.task1632;

public class Thread3 extends Thread {
    @Override
    public void run() {
        try {
            while (!currentThread().isInterrupted()) {
                System.out.println("Ура");
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

