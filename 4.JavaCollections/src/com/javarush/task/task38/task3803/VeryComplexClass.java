package com.javarush.task.task38.task3803;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object i = 42;
        String s = (String) i;

    }

    public void methodThrowsNullPointerException() {
String str = null;
boolean b = str.equals("geg");
    }

    public static void main(String[] args) {
VeryComplexClass veryComplexClass = new VeryComplexClass();
veryComplexClass.methodThrowsClassCastException();
veryComplexClass.methodThrowsNullPointerException();

    }
}
