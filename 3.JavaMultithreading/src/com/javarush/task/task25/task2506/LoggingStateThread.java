package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    Thread target;

    public LoggingStateThread(Thread target) {
        this.target = target;
        setDaemon(true);
    }

    @Override
    public void run() {
        // target.i
        State currentState = target.getState();
        System.out.println(currentState);
        do {
            if (currentState != target.getState()) {
                System.out.println(target.getState());
                currentState = target.getState();
            }
        }
        while (target.getState() != State.TERMINATED);
//        while (target.getState() != State.TERMINATED) {
//            if (currentState != target.getState()) {
//                System.out.println(target.getState());
//                currentState = target.getState();
//            }
//        }

    }
}
