package com.javarush.task.task14.task1414;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
MovieFactory
*/

public class Solution {
    public static void main(String[] args) throws Exception {
BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
String key;
while (true){
    key = reader.readLine();
    Movie movie;
    switch (key){
        case "soapOpera":
        case "cartoon":
        case "thriller":
            movie = MovieFactory.getMovie(key);
            System.out.println(movie.getClass().getSimpleName());
            break;
    }
    boolean u = (key.equals("soapOpera") || key.equals("cartoon") || key.equals("thriller"));
    if (!u){
        movie = MovieFactory.getMovie(key);
        break;
    }
}

        //ввести с консоли несколько ключей (строк), пункт 7

        /*
8 Создать переменную movie класса Movie и для каждой введенной строки(ключа):
8.1 получить объект используя MovieFactory.getMovie и присвоить его переменной movie
8.2 вывести на экран movie.getClass().getSimpleName()
7. Для всех введенных корректных строк необходимо вывести на экран простые имена (movie.getClass().getSimpleName()) типов объектов,
возвращаемых методом MovieFactory.getMovie().
        */

    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            //создание объекта SoapOpera (мыльная опера) для ключа "soapOpera"
            if ("cartoon".equals(key)) {
                movie = new Cartoon();
            }
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            }
            if ("thriller".equals(key)) {
                movie = new Thriller();
            }
                       return movie;
        }

    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }
static class Cartoon extends Movie{

}
static class Thriller extends Movie{

}
    //Напишите тут ваши классы, пункт 3
}
