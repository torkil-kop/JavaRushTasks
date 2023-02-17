package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.HHStrategy;
import com.javarush.task.task28.task2810.model.HabrCareerStrategy;
import com.javarush.task.task28.task2810.model.Model;
import com.javarush.task.task28.task2810.model.Provider;
import com.javarush.task.task28.task2810.view.HtmlView;
import com.javarush.task.task28.task2810.view.View;

public class Aggregator {
    public static void main(String[] args) {
        HtmlView view = new HtmlView();
        Model model = new Model(view, new Provider(new HHStrategy()), new Provider(new HabrCareerStrategy()));
        Controller controller = new Controller(model);
        view.setController(controller);
        view.userCitySelectEmulationMethod();
    }
}
/*
3. Для запуска нужно еще обновить метод main в Aggregator.
3.1. Создай вью, модель, контроллер. Переменная для вью должна быть типа HtmlView. Модели нужен минимум один провайдер.
3.2. Засэть во вью контроллер.
3.3. Вызови у вью метод userCitySelectEmulationMethod.

4. Запускай приложение! Подожди несколько секунд, чтобы выгреблись данные.
Работает? Отлично, что работает!
 */