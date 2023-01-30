package com.javarush.task.task13.task1318;

import java.io.*;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        String line = console.nextLine();
        try (FileInputStream inStream = new FileInputStream(line); InputStreamReader inputStreamReader = new InputStreamReader(inStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            while (bufferedReader.ready()) {
                System.out.println(bufferedReader.readLine());
            }
        } catch (Exception e) {
            System.out.println("Something went wrong : " + e);
        }
    }
}

/*
Чтение файла
В этой задаче тебе нужно:
Считать с консоли путь к файлу.
Вывести в консоли (на экран) содержимое файла.
Освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.

Requirements:
1. Программа должна считывать c консоли путь к файлу.
2. Программа должна выводить на экран содержимое файла.
3. Поток чтения из файла (FileInputStream) должен быть закрыт.
4. BufferedReader также должен быть закрыт.
 */