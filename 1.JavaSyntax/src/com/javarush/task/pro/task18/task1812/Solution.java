package com.javarush.task.pro.task18.task1812;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

/* 
Рейтинг языков программирования
*/

public class Solution {

    public static void main(String[] args) {
        ArrayList<Language> languages = new ArrayList<>();
        Collections.addAll(languages,
                new Language("С#", 4.58),
                new Language("JavaScript", 2.54),
                new Language("Python", 10.47),
                new Language("C++", 7.11),
                new Language("Go", 1.46),
                new Language("R", 2.37),
                new Language("Java", 13.48),
                new Language("C", 15.95),
                new Language("Swift", 1.38),
                new Language("PHP", 2.49));

        Stream<Language> languageStream = sortByRanking(languages);
        languageStream.forEach(System.out::println);
    }

    public static Stream<Language> sortByRanking(ArrayList<Language> languages) {
        //напишите тут ваш код
       // return Stream.empty();
        //ArrayList<Language> ran = languages.stream()
                Stream<Language> languageStream = languages.stream()
                .sorted((o1, o2) -> o2.getRanking().compareTo(o1.getRanking()));
                //.collect(Language.class());
return languageStream;
    }


}
/*
Рейтинг языков программирования
Класс Language представляет собой модель языка программирования. В этом классе есть два поля: name - название языка программирования, ranking - рейтинг использования языка программирования по состоянию на сентябрь 2020 года, согласно TIOBE.
Нужно, чтобы публичный статический метод sortByRanking(ArrayList<Language>) сортировал полученный список языков программирования по убыванию рейтинга, и возвращал отсортированный поток данных (Stream<Language>).

Подсказка:
Поскольку поле рейтинг имеет тип Double, для сортировки нужно использовать статический метод compare(Double, Double) класса Double или метод compareTo(Double) объекта типа Double.

Метод main() не принимает участие в тестировании.


Requirements:
1. Метод sortByRanking(ArrayList<Language>) нужно реализовать согласно условию.
 */