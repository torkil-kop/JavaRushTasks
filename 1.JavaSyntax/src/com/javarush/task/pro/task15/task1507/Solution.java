package com.javarush.task.pro.task15.task1507;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

/* 
Пропускаем не всех
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)){
           List<String> ll = Files.readAllLines(Path.of(scanner.nextLine()));
            for (int i = 0; i < ll.size(); i += 2) {
                System.out.println(ll.get(i));
            }
           //напишите тут ваш код
        }
    }
}

