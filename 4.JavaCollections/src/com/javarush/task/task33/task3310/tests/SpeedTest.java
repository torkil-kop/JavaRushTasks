package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {

    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids){
       long msStart = new Date().getTime();
        for (String str:strings
             ) {
          ids.add(shortener.getId(str));
        }
        return new Date().getTime() - msStart;
    }
    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings){
        long msStart = new Date().getTime();
        for (Long id: ids
             ) {
            strings.add(shortener.getString(id));
        }
        return new Date().getTime() - msStart;
    }
    @Test
    public void testHashMapStorage(){
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());
        Set<String> origStrings = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            origStrings.add(Helper.generateRandomString());
        }
        Set<Long> ids1 = new HashSet<>();
        Set<Long> ids2 = new HashSet<>();
        long test1 = getTimeToGetIds(shortener1, origStrings,ids1);
        long test2 = getTimeToGetIds(shortener2, origStrings,ids2);
        Assert.assertTrue(test1>test2);

        Set<String> strings1 = new HashSet<>();
        Set<String> strings2 = new HashSet<>();
        long test3 = getTimeToGetStrings(shortener1, ids1, strings1);
        long test4 = getTimeToGetStrings(shortener2, ids2, strings2);
        Assert.assertEquals( (float) test3/test4, (float) test4/test3, 30);
    }
}
/*

15.4. Добавь в класс SpeedTest тест testHashMapStorage(). Он должен:
15.4.1. Создавать два объекта типа Shortener, один на базе HashMapStorageStrategy, второй на базе HashBiMapStorageStrategy. Назовем их shortener1 и shortener2.
15.4.2. Генерировать с помощью Helper 10000 строк и помещать их в сет со строками, назовем его origStrings.
15.4.3. Получать время получения идентификаторов для origStrings (вызывать метод getTimeToGetIds для shortener1, а затем для shortener2).
15.4.4. Проверять с помощью junit, что время, полученное в предыдущем пункте для shortener1 больше, чем для shortener2.
15.4.5. Получать время получения строк (вызывать метод getTimeToGetStrings для shortener1 и shortener2).
15.4.6. Проверять с помощью junit, что время, полученное в предыдущем пункте для shortener1 примерно равно времени для shortener2.
 Используй метод assertEquals(float expected, float actual, float delta). В качестве delta можно использовать 30, этого вполне достаточно для наших экспериментов.
 */