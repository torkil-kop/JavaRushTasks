package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticManager {
    private StatisticStorage statisticStorage = new StatisticStorage();

    private static class StatisticManagerInstance {

        private static StatisticManager statisticManager = new StatisticManager();
    }

    private StatisticManager() {
    }

    public static StatisticManager getInstance() {
        return StatisticManagerInstance.statisticManager;
    }

    public void register(EventDataRow data) {
        this.statisticStorage.put(data);
    }

    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage;

        public StatisticStorage() {
            storage = new HashMap<>();
            for (EventType eventType : EventType.values()
            ) {
                storage.put(eventType, new ArrayList<EventDataRow>());
            }
        }
        private List<EventDataRow> get(EventType type) {
            if (!this.storage.containsKey(type))
                throw new UnsupportedOperationException();

            return this.storage.get(type);
        }
        private void put(EventDataRow data){
            EventType type = data.getType();
            if (!this.storage.containsKey(type))
                throw new UnsupportedOperationException();

            this.storage.get(type).add(data);
        }

    }
    public Map<String, Long> getProfitMap() {
        Map<String, Long> res = new HashMap();
        List<EventDataRow> rows = statisticStorage.get(EventType.SELECTED_VIDEOS);
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        long total = 0l;
        for (EventDataRow row : rows) {
            VideoSelectedEventDataRow dataRow = (VideoSelectedEventDataRow) row;
            String date = format.format(dataRow.getDate());
            if (!res.containsKey(date)) {
                res.put(date, 0l);
            }
            total += dataRow.getAmount();
            res.put(date, res.get(date) + dataRow.getAmount());
        }

        res.put("Total", total);

        return res;
    }
    public Map<String, Map<String, Integer>> getCookWorkloadingMap() {
        Map<String, Map<String, Integer>> res = new HashMap(); //name, time
        List<EventDataRow> rows = statisticStorage.get(EventType.COOKED_ORDER);
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        for (EventDataRow row : rows) {
            CookedOrderEventDataRow dataRow = (CookedOrderEventDataRow) row;
            String date = format.format(dataRow.getDate());
            if (!res.containsKey(date)) {
                res.put(date, new HashMap<String, Integer>());
            }
            Map<String, Integer> cookMap = res.get(date);
            String cookName = dataRow.getCookName();
            if (!cookMap.containsKey(cookName)) {
                cookMap.put(cookName, 0);
            }

            Integer totalTime = cookMap.get(cookName);
            cookMap.put(cookName, totalTime + dataRow.getTime());
        }

        return res;
    }


}
/*
2. В StatisticManager создай метод (придумать самостоятельно), который из хранилища достанет все данные, относящиеся к отображению рекламы,
и посчитает общую прибыль за каждый день.
Дополнительно добавь вспомогательный метод get в класс хранилища, чтобы получить доступ к данным.
 */