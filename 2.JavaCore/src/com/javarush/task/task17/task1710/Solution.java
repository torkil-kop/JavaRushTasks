package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        if (args[0].equals("-c")) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date date;

            try {
                date = formatter.parse(args[3]);

            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            if (args[2].equals("м")) {

                allPeople.add(Person.createMale(args[1], date));
                System.out.println(allPeople.indexOf(allPeople.get(allPeople.size() - 1)));
            }
            if (args[2].equals("ж")) {

                allPeople.add(Person.createFemale(args[1], date));
                System.out.println(allPeople.indexOf(allPeople.get(allPeople.size() - 1)));
            }
        }
        // При запуске программы с параметром -с программа должна добавлять человека с заданными параметрами в конец списка allPeople, и выводить id (index) на экран.

        if (args[0].equals("-r")) {

            SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            if (allPeople.get(Integer.parseInt(args[1])).getSex().equals(Sex.MALE)) {
                System.out.println(allPeople.get(Integer.parseInt(args[1])).getName() + " м " + formatter2.format(allPeople.get(Integer.parseInt(args[1])).getBirthDate()));
            }
            if (allPeople.get(Integer.parseInt(args[1])).getSex().equals(Sex.FEMALE)) {
                System.out.println(allPeople.get(Integer.parseInt(args[1])).getName() + " ж " + formatter2.format(allPeople.get(Integer.parseInt(args[1])).getBirthDate()));
            }
        }
        // При запуске программы с параметром -r программа должна выводить на экран данные о человеке с заданным id по формату указанному в задании.


        if (args[0].equals("-u")) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date date;
            try {
                date = formatter.parse(args[4]);

            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            allPeople.get(Integer.parseInt(args[1])).setName(args[2]);
            allPeople.get(Integer.parseInt(args[1])).setBirthDate(date);
            if (args[3].equals("м")) {
                allPeople.get(Integer.parseInt(args[1])).setSex(Sex.MALE);
            }
            if (args[3].equals("ж")) {
                allPeople.get(Integer.parseInt(args[1])).setSex(Sex.FEMALE);
            }
        }
            // При запуске программы с параметром -u программа должна обновлять данные человека с заданным id в списке allPeople.
            //-u id name sex bd



        if (args[0].equals("-d")) {
            allPeople.get(Integer.parseInt(args[1])).setName(null);
            allPeople.get(Integer.parseInt(args[1])).setBirthDate(null);
            allPeople.get(Integer.parseInt(args[1])).setSex(null);





        }
        //При запуске программы с параметром -d программа должна логически удалять человека с заданным id в списке allPeople.

    }
}
/*
CRUD
CRUD - Create, Read, Update, Delete.

Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-r id
-u id name sex bd
-d id

Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-r - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)
-u - обновляет данные человека с данным id
-d - производит логическое удаление человека с id, заменяет все его данные на null

id соответствует индексу в списке.
Все люди должны храниться в allPeople.
Используй Locale.ENGLISH в качестве второго параметра для SimpleDateFormat.

Пример параметров:
-c Миронов м 15/04/1990

Пример вывода для параметра -r:
Миронов м 15-Apr-1990

Если программа запущена с параметрами, то они попадают в массив args (аргумент метода main - String[] args).
Например, при запуске программы c параметрами:
-c name sex bd
получим в методе main
args[0] = "-c"
args[1] = "name"
args[2] = "sex"
args[3] = "bd"
Для запуска кода с параметрами в IDE IntellijIDEA нужно их прописать в поле Program arguments в меню Run -> Edit Configurations.


Requirements:
1. Класс Solution должен содержать public static поле allPeople типа List<Person>.
2. Класс Solution должен содержать статический блок, в котором добавляются два человека в список allPeople.
3. При запуске программы с параметром -с программа должна добавлять человека с заданными параметрами в конец списка allPeople, и выводить id (index) на экран.
4. При запуске программы с параметром -r программа должна выводить на экран данные о человеке с заданным id по формату указанному в задании.
5. При запуске программы с параметром -u программа должна обновлять данные человека с заданным id в списке allPeople.
6. При запуске программы с параметром -d программа должна логически удалять человека с заданным id в списке allPeople.
 */