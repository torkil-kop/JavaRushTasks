package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        Path path = Paths.get("wfgwgf");
        FileInputStream fileInputStream = new FileInputStream(path.toFile());
    }

    public static void main(String[] args) {

    }
}
