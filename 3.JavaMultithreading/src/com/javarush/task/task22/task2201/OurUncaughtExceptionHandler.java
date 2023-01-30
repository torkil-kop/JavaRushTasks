package com.javarush.task.task22.task2201;

public class OurUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        final String string = "%s : %s : %s";
        if (Solution.FIRST_THREAD_NAME.equals(t.getName())) {
            System.out.println(getFormattedStringForFirstThread(t, e, string));
        } else if (Solution.SECOND_THREAD_NAME.equals(t.getName())) {
            System.out.println(getFormattedStringForSecondThread(t, e, string));
        } else {
            System.out.println(getFormattedStringForOtherThread(t, e, string));
        }
    }

    protected String getFormattedStringForOtherThread(Thread t, Throwable e, String string) {
        String newString = null;
        newString = String.format(string, e.getClass().getSimpleName(), e.getCause(), t.getName());
        return newString;
    }

    protected String getFormattedStringForSecondThread(Thread t, Throwable e, String string) {
        String newString = null;
        newString = String.format(string, e.getCause(), e.getClass().getSimpleName(), t.getName());
        return newString;
    }

    protected String getFormattedStringForFirstThread(Thread t, Throwable e, String string) {
        String newString = null;
        newString = String.format(string, t.getName(), e.getClass().getSimpleName(), e.getCause());
        return newString;
    }
}

/*
a) 1# : StringForFirstThreadTooShortException : java.lang.StringIndexOutOfBoundsException: String index out of range: -1
б) java.lang.StringIndexOutOfBoundsException: String index out of range: -1 : StringForSecondThreadTooShortException : 2#
в) RuntimeException : java.lang.StringIndexOutOfBoundsException: String index out of range: -1 : 3#
 */