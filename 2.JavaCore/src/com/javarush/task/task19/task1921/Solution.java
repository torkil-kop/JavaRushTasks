package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {

    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        String str;
        Date date;
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            while (reader.ready()) {
                str = reader.readLine();
                PEOPLE.add(new Person(findName(str), findDate(str)));
            }
        }
    }

    public static String findName(String str) {
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                index = i;
                break;
            }
        }
        str = str.substring(0, index - 1);
        return str;
    }

    public static Date findDate(String str) {
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                index = i;
                break;
            }
        }
        str = str.substring(index);
        String[] strings = str.split(" ");
        Date date = new Date(Integer.parseInt(strings[2]) - 1900, Integer.parseInt(strings[1]) - 1, Integer.parseInt(strings[0]));
        return date;
    }
}
/*
Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String.
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами.

Заполнить список PEOPLE используя данные из файла.
Закрыть потоки.

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013


Requirements:
1. Класс Solution должен содержать публичную константу PEOPLE типа List<Person>, которая должна быть сразу проинициализирована.
2. Программа НЕ должна считывать данные с консоли.
3. Программа должна считывать содержимое файла (используй FileReader).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна заполнить список PEOPLE данными из файла.
6. Программа должна правильно работать с двойными именами, например Анна-Надежда.
 */