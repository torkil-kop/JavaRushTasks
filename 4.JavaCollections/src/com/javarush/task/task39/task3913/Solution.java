package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        LogParser logParser = new LogParser(Paths.get("c:/logs/"));
        System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()));
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