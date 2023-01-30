package com.javarush.task.task18.task1819;

import java.io.*;
import java.lang.reflect.Array;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        try (FileInputStream inputStream = new FileInputStream(file1)) {
            byte[] buffer = new byte[inputStream.available()];
            while (inputStream.available() > 0) {
                inputStream.read(buffer);
            }

            try (FileInputStream inputStream2 = new FileInputStream(file2);
                 FileOutputStream outputStream = new FileOutputStream(file1, false)) {
                while (inputStream2.available() > 0){

                    outputStream.write( inputStream2.read());
                }
                outputStream.write(buffer);
            }
        }
    }
}
/*
Объединение файлов
Считать с консоли 2 имени файла.
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов.
Закрыть потоки.


Requirements:
1. Программа должна два раза считать имена файлов с консоли.
2. Не используй в программе статические переменные.
3. Для первого файла создай поток для чтения и считай его содержимое.
4. Затем, для первого файла создай поток для записи(поток для записи должен быть один). Для второго - для чтения.
5. Содержимое первого и второго файла нужно объединить в первом файле.
6. Сначала должно идти содержимое второго файла, затем содержимое первого.
7. Созданные для файлов потоки должны быть закрыты.
 */