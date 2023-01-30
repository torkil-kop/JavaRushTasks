package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Person person;
        int number;
        switch (args[0]) {
            case "-c":
                number = (args.length - 1) / 3;
                synchronized (allPeople) {
                    for (int i = 0; i < number; i++) {

                        if (args[2 + 3 * i].equals("м")) {

                            person = Person.createMale(args[1 + 3 * i], formatter.parse(args[3 + 3 * i]));
                        } else {
                            person = Person.createFemale(args[1 + 3 * i], formatter.parse(args[3 + 3 * i]));
                        }
                        allPeople.add(person);
                        System.out.println(allPeople.size() - 1);
                    }
                }
                break;
            case "-u":
               number = (args.length - 1) / 4;
                synchronized (allPeople) {
                    for (int i = 0; i < number; i++) {
                        allPeople.get(Integer.parseInt(args[1 + 4 * i])).setName(args[2 + 4 * i]);
                        allPeople.get(Integer.parseInt(args[1 + 4 * i])).setBirthDate(formatter.parse(args[4 + 4 * i]));
                        allPeople.get(Integer.parseInt(args[1 + 4 * i])).setSex(args[3 + 4 * i].equals("м") ? Sex.MALE : Sex.FEMALE);
                    }
                }
                break;
            case "-d":
                number = (args.length - 1) ;
                synchronized (allPeople) {
                    for (int i = 0; i < number; i++) {
                        allPeople.get(Integer.parseInt(args[1 + 1 * i])).setName(null);
                        allPeople.get(Integer.parseInt(args[1 + 1 * i])).setBirthDate(null);
                        allPeople.get(Integer.parseInt(args[1 + 1 * i])).setSex(null);

                    }

                }
                break;
            case "-i":
                number = (args.length - 1);
                synchronized (allPeople) {
                    for (int i = 0; i < number; i++) {
                        System.out.println(allPeople.get(Integer.parseInt(args[1 + 1 * i])).getName() + (allPeople.get(Integer.parseInt(args[1 + 1 * i])).getSex() == Sex.MALE ? " м " : " ж ") + formatter2.format(allPeople.get(Integer.parseInt(args[1 + 1 * i])).getBirthDate()));
                        //System.out.println(allPeople.get(Integer.parseInt(args[1 + 1 * i])).getName() + (allPeople.get(Integer.parseInt(args[1 + 1 * i])).getSex() == Sex.MALE ? " м " : " ж "));
                    }
                }
                break;
        }
    }
}

/*
CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion.

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...

Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u - обновляет соответствующие данные людей с заданными id
-d - производит логическое удаление человека с id, заменяет все его данные на null
-i - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке.
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople.
Порядок вывода данных соответствует вводу данных.
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных).
Используй Locale.ENGLISH в качестве второго параметра для SimpleDateFormat.

Пример вывода для параметра -і с двумя id:
Миронов м 15-Apr-1990
Миронова ж 25-Apr-1997


Requirements:
1. Класс Solution должен содержать public static volatile поле allPeople типа List<Person>.
2. Класс Solution должен содержать статический блок, в котором добавляются два человека в список allPeople.
3. При параметре -с программа должна добавлять всех людей с заданными параметрами в конец списка allPeople, и выводить id каждого (index) на экран.
4. При параметре -u программа должна обновлять данные людей с заданными id в списке allPeople.
5. При параметре -d программа должна логически удалять людей с заданными id в списке allPeople.
6. При параметре -i программа должна выводить на экран данные о всех людях с заданными id по формату указанному в задании.
7. Метод main класса Solution должен содержать оператор switch по значению args[0].
8. Каждый case оператора switch должен иметь блок синхронизации по allPeople.
 */