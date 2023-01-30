package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws IOException {
BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        try (FileReader fileReader1 = new FileReader(file2);
             FileWriter fileWriter1 = new FileWriter(file1);
             FileReader fileReader3 = new FileReader(file3);
             FileWriter fileWriter11 = new FileWriter(file1, true);
        ){
            while (fileReader1.ready()){

               int s = fileReader1.read();
               fileWriter1.write(s);
            }
            while (fileReader3.ready()){
                int s = fileReader3.read();
                fileWriter11.write(s);
            }
        }
    }
}
/*
Два в одном
Считать с консоли 3 имени файла.
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла.
Закрыть потоки.


Requirements:
1. Программа должна три раза считать имена файлов с консоли.
2. Для первого файла создай поток для записи. Для двух других - потоки для чтения.
3. Содержимое второго файла нужно переписать в первый файл.
4. Содержимое третьего файла нужно дописать в первый файл (в который уже записан второй файл).
5. Созданные для файлов потоки должны быть закрыты.
 */