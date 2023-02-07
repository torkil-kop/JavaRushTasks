package com.javarush.task.task33.task3310.strategy;

import java.io.Serializable;
import java.util.Objects;

public class Entry implements Serializable {
     Long key;
     String value;
     Entry next;
     int hash;

    public Entry(int hash, Long key, String value, Entry next) {
        this.key = key;
        this.value = value;
        this.next = next;
        this.hash = hash;
    }

    public Long getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return Objects.equals(key, entry.key) && Objects.equals(value, entry.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @Override
    public String toString() {
        return key + "=" + value;
                
    }
}
/*
7.3. Добавь в Entry следующие поля: Long key, String value, Entry next, int hash. Как видишь, наша реализация будет поддерживать только тип Long для ключа и
только String для значения. Область видимости полей оставь по умолчанию.
7.4. Добавь и реализуй конструктор Entry(int hash, Long key, String value, Entry next).
7.5. Добавь и реализуй методы: Long getKey(), String getValue(), int hashCode(), boolean equals() и String toString().
 Реализовывать остальные методы оригинального Entry не нужно, мы пишем упрощенную версию.

5. Метод toString должен возвращать строку формата key + "=" + value.
6. Методы hashCode и equals должны быть корректно реализованы используя для сравнения поля key и value.
 */