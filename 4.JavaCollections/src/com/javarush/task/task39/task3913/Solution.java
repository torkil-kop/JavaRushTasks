package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
//        LogParser logParser = new LogParser(Paths.get("c:/logs/"));
        LogParser logParser = new LogParser(Paths.get("e:/logs/"));
  //      System.out.println(logParser.getNumberOfUniqueIPs(new Date(112, Calendar.AUGUST, 30, 16, 8, 13), new Date(113, Calendar.DECEMBER, 11, 10, 11, 12)));//11.12.2013 10:11:12
 //       System.out.println(logParser.getUniqueIPs(null, new Date(112, Calendar.AUGUST, 30, 16, 8, 13)));// 30.08.2012 16:08:13
//        System.out.println(logParser.getIPsForUser("Vasya Pupkin", null, null));
        //System.out.println(logParser.getIPsForEvent(Event.WRITE_MESSAGE, null, null));
//        System.out.println(logParser.getIPsForStatus(Status.ERROR, null, null));
//       logParser.show();
//        TreeSet<Date> dates = new TreeSet<>();
//        dates.add(new Date(112, Calendar.AUGUST, 30, 16, 8, 13));
//        dates.add(new Date(114, Calendar.AUGUST, 30, 16, 8, 13));
//        dates.add(new Date(116, Calendar.AUGUST, 30, 16, 8, 13));
//        dates.add(new Date(118, Calendar.AUGUST, 30, 16, 8, 13));
//        dates.add(new Date(110, Calendar.AUGUST, 30, 16, 8, 13));
//        dates.add(new Date(110, Calendar.AUGUST, 30, 16, 8, 10));
//        System.out.println(dates.first());
        System.out.println(logParser.execute("get status"));

    }

}
/*
ip username date event status

Где:
ip - ip адрес с которого пользователь произвел событие.
user - имя пользователя (одно или несколько слов разделенные пробелами).
date - дата события в формате day.month.year hour:minute:second.
event - одно из событий:
LOGIN - пользователь залогинился,
DOWNLOAD_PLUGIN - пользователь скачал плагин,
WRITE_MESSAGE - пользователь отправил сообщение,
SOLVE_TASK - пользователь попытался решить задачу,
DONE_TASK - пользователь решил задачу.
Для событий SOLVE_TASK и DONE_TASK существует дополнительный параметр,
который указывается через пробел, это номер задачи.
status - статус:
OK - событие выполнилось успешно,
FAILED - событие не выполнилось,
ERROR - произошла ошибка.

Пример строки из лог файла:
"146.34.15.5 Eduard Petrovich Morozko 05.01.2021 20:22:55 DONE_TASK 48 FAILED".
Записи внутри лог файла не обязательно упорядочены по дате, события могли произойти и быть записаны в лог в разной последовательности.
Все параметры разделены табуляцией ("\t").
 */