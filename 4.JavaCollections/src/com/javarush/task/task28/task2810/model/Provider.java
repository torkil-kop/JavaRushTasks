package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.Collections;
import java.util.List;

public class Provider {
    private Strategy strategy;

    public Provider(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public List<Vacancy> getJavaVacancies(String searchString){
if (strategy == null) return Collections.emptyList();
        return strategy.getVacancies(searchString);
    }
}
/*
Aggregator (5)
1. Добавь в интерфейс Strategy метод getVacancies(String searchString), который будет возвращать список вакансий.

2. Поправь ошибки в классе HHStrategy.

3. Вернись в метод getJavaVacancies класса Provider, реализуй его логику из расчета, что всех данных хватает.

4. Давай попробуем запустить и посмотреть, как работает наша программа.
В методе main вместо вывода на экран напиши controller.scan();
Воспользуйся подсказкой IDEA и создай метод.
Внутри метода пройдись по всем провайдерам и собери с них все вакансии, добавь их в список. Выведи количество вакансий в консоль.

5. Исправь NPE, если появляется это исключение (поставь заглушку, например Collections.emptyList()).
 */