package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;

import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.testStrategy(new HashMapStorageStrategy(), 10000);
       testStrategy(new HashMapStorageStrategy(), 10000);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> longSet = new HashSet<>();
        for (String str : strings
        ) {
            longSet.add(shortener.getId(str));
        }
        return longSet;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> stringSet = new HashSet<>();
        for (Long key : keys
        ) {

            stringSet.add(shortener.getString(key));
        }
        return stringSet;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> testStrings = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++) {
            testStrings.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);

        Long msStart = new Date().getTime();
//        System.out.println(msStart);
        Set<Long> longSet = getIds(shortener, testStrings);
        Long msFinish = new Date().getTime();
//        System.out.println(msFinish);
        Helper.printMessage(msFinish - msStart + "");
        Long msStart2 = new Date().getTime();
        Set<String> stringSet = getStrings(shortener, longSet);
        Long msFinish2 = new Date().getTime();
        Helper.printMessage(msFinish2 - msStart2 + "");
        if (testStrings.containsAll(stringSet) && stringSet.containsAll(testStrings)) {
            Helper.printMessage("Тест пройден.");
        } else {
            Helper.printMessage("Тест не пройден.");
        }
    }
}
/*
6.2.3. testStrategy(StorageStrategy strategy, long elementsNumber). Метод будет тестировать работу переданной стратегии на определенном
количестве элементов elementsNumber. Реализация метода должна:
6.2.3.1. Выводить имя класса стратегии. Имя не должно включать имя пакета.
6.2.3.2. Генерировать тестовое множество строк, используя Helper и заданное количество элементов elementsNumber.
6.2.3.3. Создавать объект типа Shortener, используя переданную стратегию.
6.2.3.4. Замерять и выводить время необходимое для отработки метода getIds для заданной стратегии и заданного множества элементов.
 Время вывести в миллисекундах. При замере времени работы метода можно пренебречь переключением процессора на другие потоки, временем,
  которое тратится на сам вызов, возврат значений и вызов методов получения времени (даты). Замер времени произведи с использованием объектов типа Date.
6.2.3.5. Замерять и выводить время необходимое для отработки метода getStrings для заданной стратегии и полученного в предыдущем пункте множества идентификаторов.
6.2.3.6. Сравнивать одинаковое ли содержимое множества строк, которое было сгенерировано и множества, которое было возвращено методом getStrings.
 Если множества одинаковы, то выведи "Тест пройден.", иначе "Тест не пройден.".
 */