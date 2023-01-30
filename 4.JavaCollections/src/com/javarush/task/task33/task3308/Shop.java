package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;
@XmlType(name = "shop")
@XmlRootElement
public class Shop {
    public Goods goods;
    public int count;
    public  double profit;
    public String[] secretData;

    public Shop(Goods goods, int count, double profit, String[] secretData) {
        this.goods = goods;
        this.count = count;
        this.profit = profit;
        this.secretData = secretData;
    }

    public Shop() {
    }

    public static class Goods{
       public List<String> names;

        public Goods(List<String> names) {
            this.names = names;
        }

        public Goods() {
        }
    }
}
/*
Requirements:
1. Класс Shop должен быть создан в отдельном файле.
2. В классе Shop должно быть создано поле goods типа Goods.
3. В классе Shop должно быть создано поле count типа int.
4. В классе Shop должно быть создано поле profit типа double.
5. В классе Shop должен быть создан массив строк secretData.
6. В классе Shop должен содержаться вложенный статический класс Goods.
7. В классе Shop.Goods должен быть создан список строк names.
8. Все поля класса Shop должны быть публичными.
9. Метод getClassName класса Solution должен возвращать класс Shop.
 */