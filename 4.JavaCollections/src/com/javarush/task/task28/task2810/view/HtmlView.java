package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class HtmlView implements View{
    private Controller controller;
    private final String filePath = "./4.JavaCollections/src/" + this.getClass().getPackage().getName().replaceAll("[.]", "/") + "/vacancies.html";

    @Override
    public void update(List<Vacancy> vacancies) {
        try {
            updateFile(getUpdatedFileContent(vacancies));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void setController(Controller controller) {
this.controller = controller;
    }
    public void userCitySelectEmulationMethod(){
        controller.onCitySelect("Odessa");
    }
    private String getUpdatedFileContent(List<Vacancy> vacancies){
        try {
            Document doc = getDocument();
            Elements templateHidden = doc.getElementsByClass("template");
            Element template = templateHidden.clone().removeAttr("style").removeClass("template").get(0);

            //remove all prev vacancies
            Elements prevVacancies = doc.getElementsByClass("vacancy");

            for (Element redundant : prevVacancies) {
                if (!redundant.hasClass("template")) {
                    redundant.remove();
                }
            }

            //add new vacancies
            for (Vacancy vacancy : vacancies) {
                Element vacancyElement = template.clone();

                Element vacancyLink = vacancyElement.getElementsByAttribute("href").get(0);
                vacancyLink.appendText(vacancy.getTitle());
                vacancyLink.attr("href", vacancy.getUrl());
                Element city = vacancyElement.getElementsByClass("city").get(0);
                city.appendText(vacancy.getCity());
                Element companyName = vacancyElement.getElementsByClass("companyName").get(0);
                companyName.appendText(vacancy.getCompanyName());
                Elements salaryEls = vacancyElement.getElementsByClass("salary");
                Element salary = salaryEls.get(0);
                salary.appendText(vacancy.getSalary());

                templateHidden.before(vacancyElement.outerHtml());
            }
            return doc.html();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Some exception occurred";
    }

    protected Document getDocument() throws IOException {
        return Jsoup.parse(new File(filePath), "UTF-8");
    }
    private void updateFile(String string){
        try( FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            byte[] bytes = string.getBytes();
           fileOutputStream.write(bytes);
        }
     catch (Exception e){
            e.printStackTrace();
     }
    }
}
/*
Aggregator (14)
В классе HtmlView остались два пустых метода.
В этом задании я опишу, что должен делать метод updateFile. А также расскажу, как можно дебажить.

Он принимает тело файла в виде строки. Нужно его записать в файл, который находится по пути filePath.
Ты это хорошо умеешь делать, поэтому подробностей тут не будет.

Теперь - как дебажить.
Поставь breakpoint, запусти в дебаг моде.
нажми Alt+F8 (Run -> Evaluate Expression).
В выражении (верхняя строка) напиши System.out.println("AAA") и нажми Alt+V (снизу кнопка Evaluate).
Перейди в окно консоли, там вывелось "AAA".

Используя это окно ты можешь смотреть текущие данные, заменять их на другие, нужные тебе.
Можешь выполнять все, что хочешь. Например, удалить все элементы мапы, изменить значение любой переменной, присвоить новое значение либо обнулить ее.
Поставь брекпоинт в Controller.onCitySelect, запусти в дебаг моде.
Остановились на этом брекпоинте? Отлично, жми Alt+F8, сверху в строке cityName = "junior";
далее жми Alt+V и F9, чтобы продолжить работу приложения.
Список вакансий, который пришел в HtmlView.update, выполнялся для запроса "java junior".
Используй окно Expression Evaluation, думаю, оно тебе понадобится в следующем пункте.


Requirements:
1. В классе HtmlView в методе updateFile открой поток для записи в файл.
2. Запиши в файл данные, которые метод updateFile получает аргументом.
3. Закрой поток записи в файл.

 */