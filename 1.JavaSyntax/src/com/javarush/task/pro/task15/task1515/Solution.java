package com.javarush.task.pro.task15.task1515;

import java.nio.file.Path;
import java.util.Scanner;

/* 
Абсолютный путь
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        boolean abs = Path.of(str).isAbsolute();
        if (Path.of(str).isAbsolute()) {
            System.out.println(Path.of(str));
        } else {
            Path path = Path.of(str).toAbsolutePath();
            System.out.println(path);
        }

    }
}

