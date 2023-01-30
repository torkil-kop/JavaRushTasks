package com.javarush.task.task19.task1923;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> strings = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
             BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))) {
            while (reader.ready()) {
                String[] stringsArray = reader.readLine().split(" ");
                strings.addAll(Arrays.asList(stringsArray));
            }

            for (String str : strings
            ) {
                for (int i = 0; i < str.length(); i++) {
                    if (Character.isDigit(str.charAt(i))) {
                        writer.write(str + " ");
                        break;
                    }
                }
            }
        }

    }
}
/*
Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со словами, разделенными пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1, abc3d или 564.
Закрыть потоки.


Requirements:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна записывать во второй файл все слова из первого файла которые содержат цифры (используй FileWriter).
5. Поток записи в файл (FileWriter) должен быть закрыт.
 */