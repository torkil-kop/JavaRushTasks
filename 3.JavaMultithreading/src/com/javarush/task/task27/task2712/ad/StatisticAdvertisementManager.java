package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class StatisticAdvertisementManager {
    private AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();
    private static class InstanceHolder {
       private static StatisticAdvertisementManager statisticAdvertisementManager = new StatisticAdvertisementManager();
    }
    private StatisticAdvertisementManager() {
    }
    public static StatisticAdvertisementManager getInstance(){
        return InstanceHolder.statisticAdvertisementManager;
    }
    public List<Advertisement> getActiveVideoSet(){
        List<Advertisement> activeVideoSet = new ArrayList<>();
        for (Advertisement ad: advertisementStorage.list()
             ) {
            if (ad.isActive()){
                activeVideoSet.add(ad);
            }
        }
        return activeVideoSet;
    }

    public List<Advertisement> getArchivedVideoSet(){
        List<Advertisement> archivedVideoSet = new ArrayList<>();
        for (Advertisement ad: advertisementStorage.list()
        ) {
            if (!ad.isActive()){
                archivedVideoSet.add(ad);
            }
        }
        return archivedVideoSet;
    }
}
/*
3. В StatisticAdvertisementManager создай два (или один) метода (придумать самостоятельно), которые из хранилища AdvertisementStorage достанут все необходимые
 данные - соответственно список активных и неактивных рекламных роликов.
Активным роликом считается тот, у которого есть минимум один доступный показ.
Неактивным роликом считается тот, у которого количество показов равно 0.
 public void printActiveVideoSet(){

    }
    public void printArchivedVideoSet(){

    }
 */