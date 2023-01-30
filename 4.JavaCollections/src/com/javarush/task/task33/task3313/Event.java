package com.javarush.task.task33.task3313;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Event {
    public String name;
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "dd-MM-yyyy hh:mm:ss")
    public Date eventDate;

    public Event(String name) {
        this.name = name;
        eventDate = new Date();
    }
}
/*
Сериализация даты в JSON
Используя аннотацию JsonFormat сделай так, чтобы поле содержащее дату в классе Event сериализировалось в формате (dd-MM-yyyy hh:mm:ss).


Requirements:
1. Поле eventDate в классе Event должно быть отмечено аннотацией @JsonFormat.
2. Объекты типа Event должны корректно сериализовываться в JSON в соответствии с условием задачи.
3. В конструкторе класса Event должен быть создан новый объект типа Date без аргументов.
4. Поле eventDate должно быть публичным.
 */