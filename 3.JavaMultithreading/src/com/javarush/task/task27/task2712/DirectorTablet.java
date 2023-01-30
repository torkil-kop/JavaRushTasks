package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.*;

public class DirectorTablet {
    public void printAdvertisementProfit() {
        StatisticManager statisticManager = StatisticManager.getInstance();
        Map<String, Long> profitMap = statisticManager.getProfitMap();
        ArrayList<String> list = new ArrayList(profitMap.keySet());
        Collections.sort(list);

        for (String key : list) {
            double amount = 1.0 * profitMap.get(key) / 100;
            System.out.println(key + " - " + String.format(Locale.ENGLISH, "%.2f", amount));
        }
    }

    public void printCookWorkloading() {
        StatisticManager statisticManager = StatisticManager.getInstance();
        Map<String, Map<String, Integer>> cookWorkloadingMap = statisticManager.getCookWorkloadingMap();
        ArrayList<String> list = new ArrayList(cookWorkloadingMap.keySet());
        Collections.sort(list);

        for (String key : list) {
            Map<String, Integer> cookMap = cookWorkloadingMap.get(key);
            System.out.println(key);

            ArrayList<String> cookNames = new ArrayList(cookMap.keySet());
            Collections.sort(cookNames);
            for (String cookName : cookNames) {
                System.out.println(cookName + " - " + ((cookMap.get(cookName) + 59) / 60) + " min");
            }

            System.out.println();
        }
    }
    public void printActiveVideoSet(){
        StatisticAdvertisementManager statisticAdvertisementManager = StatisticAdvertisementManager.getInstance();
        List<Advertisement> active = statisticAdvertisementManager.getActiveVideoSet();
        Map<String, Integer> sortedActiveMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        for (Advertisement ad:active
             ) {
            sortedActiveMap.put(ad.getName(), ad.getHits());
        }
        for (String srr: sortedActiveMap.keySet()
             ) {
            System.out.println(srr + " - " + sortedActiveMap.get(srr));
        }
    }
    public void printArchivedVideoSet(){
        StatisticAdvertisementManager statisticAdvertisementManager = StatisticAdvertisementManager.getInstance();
        List<Advertisement> archived = statisticAdvertisementManager.getArchivedVideoSet();
       List<String> sortedArchivedList = new ArrayList<>();
        for (Advertisement ad:archived
             ) {
            sortedArchivedList.add(ad.getName());
        }
        Collections.sort(sortedArchivedList, String.CASE_INSENSITIVE_ORDER);
        for (String srr: sortedArchivedList
        ) {
            System.out.println(srr);
        }
    }

}
/*
4. Реализуй логику методов printActiveVideoSet и printArchivedVideoSet в классе DirectorTablet.
Используй методы/метод, созданные в предыдущем пункте.
Сортировать по имени видео-ролика в алфавитном порядке без учета регистра.
Сначала английские, потом русские.

Пример вывода для printActiveVideoSet (имя ролика - оставшееся количество показов ролика):
First Video - 100
Second video - 10
Third Video - 2
четвертое видео - 4

Пример вывода для printArchivedVideoSet (имена роликов с количеством показов 0):
Second video
Third Video
четвертое видео


 */