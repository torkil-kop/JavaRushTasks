package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.Collections;
import java.util.List;

public class HHStrategy implements Strategy{
   private static final String URL_FORMAT =  "https://grc.ua/search/vacancy?text=java+%s&page=%d";


   @Override
   public List<Vacancy> getVacancies(String searchString) {
      try {
         Document doc = Jsoup.connect(String.format(URL_FORMAT, "wfwf", 0)).get();
      }
     catch (Exception e){
         e.printStackTrace();
     }


      return Collections.emptyList();
   }
}
/*
Итак, ссылка будет примерно такой:
https://grc.ua/search/vacancy?text=java+ADDITIONAL_VALUE&page=PAGE_VALUE

1. Из полученной ссылки в HHStrategy создай приватную строковую константу URL_FORMAT, которая будет передаваться в String.format().
В результате подстановки константы URL_FORMAT в String.format(URL_FORMAT, "Kiev", 3) с такими параметрами, результат должен быть таким:
"https://grc.ua/search/vacancy?text=java+Kiev&page=3"
или
"https://hh.ru/search/vacancy?text=java+Kiev&page=3"
Для этого скопируй ссылку в код и нажми на ней нужную комбинацию клавиш.
Ctrl+Alt+C(Constant) - создание констант,
Ctrl+Alt+M(Method) - создание методов,
Ctrl+Alt+V(Variable) - создание переменных.
 */