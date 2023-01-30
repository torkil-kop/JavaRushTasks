package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }
//    public void processVideos(){
//
//        if (storage.list().isEmpty()){
//            throw new NoVideoAvailableException();
//        }
//
//    }
public void processVideos() {
    this.totalTimeSecondsLeft = Integer.MAX_VALUE;
    obtainOptimalVideoSet(new ArrayList<>(), timeSeconds, 0L);

    VideoSelectedEventDataRow row = new VideoSelectedEventDataRow(optimalVideoSet, maxAmount, timeSeconds - totalTimeSecondsLeft);
    StatisticManager.getInstance().register(row);

    displayAdvertisement();
}

    //recursion
    private long maxAmount;
    private List<Advertisement> optimalVideoSet;
    private int totalTimeSecondsLeft;

    private void obtainOptimalVideoSet(List<Advertisement> totalList, int currentTimeSecondsLeft, long currentAmount) {
        if (currentTimeSecondsLeft < 0) {
            return;
        } else if (currentAmount > maxAmount
                || currentAmount == maxAmount && (totalTimeSecondsLeft > currentTimeSecondsLeft
                || totalTimeSecondsLeft == currentTimeSecondsLeft && totalList.size() < optimalVideoSet.size())) {
            this.totalTimeSecondsLeft = currentTimeSecondsLeft;
            this.optimalVideoSet = totalList;
            this.maxAmount = currentAmount;
            if (currentTimeSecondsLeft == 0) {
                return;
            }
        }

        ArrayList<Advertisement> tmp = getActualAdvertisements();
        tmp.removeAll(totalList);
        for (Advertisement ad : tmp) {
            if (!ad.isActive()) continue;
            ArrayList<Advertisement> currentList = new ArrayList<>(totalList);
            currentList.add(ad);
            obtainOptimalVideoSet(currentList, currentTimeSecondsLeft - ad.getDuration(), currentAmount + ad.getAmountPerOneDisplaying());
        }
    }

    private ArrayList<Advertisement> getActualAdvertisements() {
        ArrayList<Advertisement> advertisements = new ArrayList<>();
        for (Advertisement ad : storage.list()) {
            if (ad.isActive()) {
                advertisements.add(ad);
            }
        }
        return advertisements;
    }

    private void displayAdvertisement() {
        if (optimalVideoSet == null || optimalVideoSet.isEmpty()) {
            throw new NoVideoAvailableException();
        }

        optimalVideoSet.sort((o1, o2) -> {
            long l = o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying();
            return (int) (l != 0 ? l : o2.getDuration() - o1.getDuration());
        });

        for (Advertisement ad : optimalVideoSet) {
            displayInPlayer(ad);
            ad.revalidate();
        }
    }

    private void displayInPlayer(Advertisement advertisement) {
        System.out.println(advertisement.getName() + " is displaying... " + advertisement.getAmountPerOneDisplaying() +
                ", " + (1000 * advertisement.getAmountPerOneDisplaying() / advertisement.getDuration()));
    }
}
/*
2.2. Подобрать список видео из доступных, просмотр которых обеспечивает максимальную выгоду. (Пока делать не нужно, сделаем позже).
2.3. Если нет рекламных видео, которые можно показать посетителю, то бросить NoVideoAvailableException, которое перехватить в оптимальном месте (подумать,
где это место) и с уровнем Level.INFO логировать фразу "No video is available for the order " + order
2.4. Отобразить все рекламные ролики, отобранные для показа, в порядке уменьшения стоимости показа одного рекламного ролика в копейках.
Вторичная сортировка - по увеличению стоимости показа одной секунды рекламного ролика в тысячных частях копейки.
Используй метод Collections.sort

Пример для заказа [WATER]:
First Video is displaying... 50, 277
где First Video - название рекламного ролика
где 50 - стоимость показа одного рекламного ролика в копейках
где 277 - стоимость показа одной секунды рекламного ролика в тысячных частях копейки (равно 0.277 коп)
Используй методы из класса Advertisement.
(Этот пункт тоже пока делать не нужно, сделаем позже).
 */