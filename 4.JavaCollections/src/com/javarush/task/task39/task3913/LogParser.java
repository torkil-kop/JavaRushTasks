package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {
    private List<UserLogger> userLogger;

//    private Path logDir;

    public LogParser(Path logDir) {
//        this.logDir = logDir;
        userLogger = getUserLoggerList(logDir);

    }

    public List<UserLogger> getUserLoggerList(Path logDir) {
        List<Path> pathList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        List<UserLogger> userLoggerList = new ArrayList<>();
        try (DirectoryStream<Path> files = Files.newDirectoryStream(logDir)) {
            for (Path p : files
            ) {
//
                if (Files.isRegularFile(p) && p.getFileName().toString().endsWith(".log")) {
                    pathList.add(p);
                }
            }
        } catch (Exception e) {
            System.out.println("Проблема с директорией с лог файлами");
        }
        for (Path path : pathList
        ) {
            try {
                stringList.addAll(Files.readAllLines(path));
            } catch (Exception e) {
                System.out.println("Ошибка при получении строк из пути файла");
            }
        }
        for (String str : stringList
        ) {
            String[] strings = str.split("\\t");
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss"); //30.08.2012 16:08:13
            Date date = null;
            try {
                date = sdf.parse(strings[2]);
            } catch (Exception e) {
                System.out.println("Неверный формат даты");
            }
            String[] taskSplit = strings[3].split(" ");
            if (taskSplit.length == 1) {
                userLoggerList.add(new UserLogger(strings[0], strings[1], date, Event.valueOf(taskSplit[0]), Status.valueOf(strings[4]), -1));
            } else {
                userLoggerList.add(new UserLogger(strings[0], strings[1], date, Event.valueOf(taskSplit[0]), Status.valueOf(strings[4]), Integer.parseInt(taskSplit[1])));
            }

        }
        return userLoggerList;
    }

    public void show() {
        for (UserLogger u : userLogger
        ) {
            System.out.println(u.toString());
        }
    }

    public List<UserLogger> getSortedListByDate(Date after, Date before) {
        List<UserLogger> userLoggersSorted = new ArrayList<>();

        if (after == null && before == null) {

            userLoggersSorted.addAll(userLogger);
            return userLoggersSorted;
        } else if (after == null) {

            for (UserLogger u : userLogger
            ) {
//                System.out.println(u.getDate().before(before));
//                System.out.println(u.getDate().equals(before));
//                System.out.println(u.getDate().toString());
//                System.out.println(before.toString());
                if (u.getDate().before(before) || u.getDate().equals(before)) {
                    userLoggersSorted.add(u);
                }
            }
            return userLoggersSorted;
        } else if (before == null) {

            for (UserLogger u : userLogger
            ) {
                if (u.getDate().after(after) || u.getDate().equals(after)) {
                    userLoggersSorted.add(u);
                }
            }
            return userLoggersSorted;
        }
        for (UserLogger u : userLogger
        ) {
            if ((u.getDate().after(after) || u.getDate().equals(after)) && (u.getDate().before(before) || u.getDate().equals(before))) {
                userLoggersSorted.add(u);
            }
        }
        return userLoggersSorted;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        Set<String> ipSet = new HashSet<>();
        for (UserLogger u : getSortedListByDate(after, before)
        ) {
            ipSet.add(u.getIp());
        }
        return ipSet.size();

    }


    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String> ipSet = new HashSet<>();
        for (UserLogger u : getSortedListByDate(after, before)
        ) {
            ipSet.add(u.getIp());
        }
        return ipSet;

    }

    /*
    1.2.2. Метод getUniqueIPs() должен возвращать множество, содержащее все не повторяющиеся IP. Тип в котором будем хранить IP будет String.
     */
    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {

        Set<String> ipSet = new HashSet<>();
        for (UserLogger u : getSortedListByDate(after, before)
        ) {
            if (user.equals(u.getUserName())) {
                ipSet.add(u.getIp());
            }
        }
        return ipSet;

    }

    /*
    1.2.3. Метод getIPsForUser() должен возвращать IP, с которых работал переданный пользователь.
     */
    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        Set<String> ipSet = new HashSet<>();
        for (UserLogger u : getSortedListByDate(after, before)
        ) {
            if (event.equals(u.getEvent())) {
                ipSet.add(u.getIp());
            }
        }
        return ipSet;

    }

    /*
     Метод getIPsForEvent() должен возвращать IP, с которых было произведено переданное событие.
     */
    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        Set<String> ipSet = new HashSet<>();
        for (UserLogger u : getSortedListByDate(after, before)
        ) {
            if (status.equals(u.getStatus())) {
                ipSet.add(u.getIp());
            }
        }
        return ipSet;
    }

    @Override
    public Set<String> getAllUsers() {
        Set<String> allUsers = new HashSet<>();
        for (UserLogger u : userLogger
        ) {
            allUsers.add(u.getUserName());
        }
        return allUsers;
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {

        Set<String> allUsers = new HashSet<>();
        for (UserLogger u : getSortedListByDate(after, before)
        ) {
            allUsers.add(u.getUserName());
        }
        return allUsers.size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        Set<Event> eventSet = new HashSet<>();
        for (UserLogger u : getSortedListByDate(after, before)
        ) {
            if (u.getUserName().equals(user)) {
                eventSet.add(u.getEvent());
            }
        }
        //Метод getNumberOfUserEvents() должен возвращать количество уникальных событий от определенного пользователя.
        return eventSet.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        Set<String> usersForIP = new HashSet<>();
        for (UserLogger u : getSortedListByDate(after, before)
        ) {
            if (u.getIp().equals(ip)) {
                usersForIP.add(u.getUserName());
            }
        }
        //Метод getUsersForIP() должен возвращать пользователей с определенным IP.
        //Несколько пользователей могут использовать один и тот же IP.
        return usersForIP;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        //Метод getLoggedUsers() должен возвращать пользователей, которые делали логин.
        Set<String> usersLogin = new HashSet<>();
        for (UserLogger u : getSortedListByDate(after, before)
        ) {
            if (u.getEvent().equals(Event.LOGIN)) {
                usersLogin.add(u.getUserName());
            }
        }
        return usersLogin;
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        //Метод getDownloadedPluginUsers() должен возвращать пользователей, которые скачали плагин.

        Set<String> usersPlagin = new HashSet<>();
        for (UserLogger u : getSortedListByDate(after, before)
        ) {
            if (u.getEvent().equals(Event.DOWNLOAD_PLUGIN)) {
                usersPlagin.add(u.getUserName());
            }
        }
        return usersPlagin;
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        //Метод getWroteMessageUsers() должен возвращать пользователей, которые отправили сообщение.

        Set<String> usersMessage = new HashSet<>();
        for (UserLogger u : getSortedListByDate(after, before)
        ) {
            if (u.getEvent().equals(Event.WRITE_MESSAGE)) {
                usersMessage.add(u.getUserName());
            }
        }
        return usersMessage;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        //Метод getSolvedTaskUsers(Date after, Date before) должен возвращать пользователей, которые решали любую задачу.
        Set<String> usersSolvedAnyTask = new HashSet<>();
        for (UserLogger u : getSortedListByDate(after, before)
        ) {
            if (u.getEvent().equals(Event.SOLVE_TASK)) {
                usersSolvedAnyTask.add(u.getUserName());
            }
        }
        return usersSolvedAnyTask;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        //Метод getSolvedTaskUsers(Date after, Date before, int task) должен возвращать пользователей, которые решали задачу с номером task.
        Set<String> usersSolvedTask = new HashSet<>();
        for (UserLogger u : getSortedListByDate(after, before)
        ) {
            if (u.getEvent().equals(Event.SOLVE_TASK)) {
                if (u.getTaskNumber() == task) {
                    usersSolvedTask.add(u.getUserName());
                }

            }
        }
        return usersSolvedTask;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        Set<String> usersDoneAnyTask = new HashSet<>();
        for (UserLogger u : getSortedListByDate(after, before)
        ) {
            if (u.getEvent().equals(Event.DONE_TASK)) {
                usersDoneAnyTask.add(u.getUserName());
            }
        }
        return usersDoneAnyTask;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        Set<String> usersDoneTask = new HashSet<>();
        for (UserLogger u : getSortedListByDate(after, before)
        ) {
            if (u.getEvent().equals(Event.DONE_TASK)) {
                if (u.getTaskNumber() == task) {
                    usersDoneTask.add(u.getUserName());
                }

            }
        }
        return usersDoneTask;
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        //3.1. Метод getDatesForUserAndEvent() должен возвращать даты, когда определенный пользователь произвел определенное событие.
        Set<Date> dateSet = new HashSet<>();
        for (UserLogger u : getSortedListByDate(after, before)
        ) {
            if (u.getUserName().equals(user) && u.getEvent().equals(event)) {
                dateSet.add(u.getDate());
            }
        }
        return dateSet;
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        //Метод getDatesWhenSomethingFailed() должен возвращать даты, когда любое событие не выполнилось (статус FAILED).

        Set<Date> dateSet = new HashSet<>();
        for (UserLogger u : getSortedListByDate(after, before)
        ) {
            if (u.getStatus().equals(Status.FAILED)) {
                dateSet.add(u.getDate());
            }
        }
        return dateSet;
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        //Метод getDatesWhenErrorHappened() должен возвращать даты, когда любое событие закончилось ошибкой (статус ERROR).
        Set<Date> dateSet = new HashSet<>();
        for (UserLogger u : getSortedListByDate(after, before)
        ) {
            if (u.getStatus().equals(Status.ERROR)) {
                dateSet.add(u.getDate());
            }
        }
        return dateSet;
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        //Метод getDateWhenUserLoggedFirstTime() должен возвращать дату, когда пользователь залогинился впервые за указанный период.
        // Если такой даты в логах нет - null.
        TreeSet<Date> dateSet = new TreeSet<>();
        for (UserLogger u : getSortedListByDate(after, before)
        ) {
            if (u.getUserName().equals(user) && u.getEvent().equals(Event.LOGIN)) {
                dateSet.add(u.getDate());
            }
        }

        if (dateSet.size() > 0) {
            return dateSet.first();
        }
        return null;
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        //Метод getDateWhenUserSolvedTask() должен возвращать дату, когда пользователь впервые попытался решить определенную задачу.
        // Если такой даты в логах нет - null.
        TreeSet<Date> dateSet = new TreeSet<>();
        for (UserLogger u : getSortedListByDate(after, before)
        ) {
            if (u.getUserName().equals(user) && u.getEvent().equals(Event.SOLVE_TASK) && u.getTaskNumber() == task) {
                dateSet.add(u.getDate());
            }
        }

        if (dateSet.size() > 0) {
            return dateSet.first();
        }
        return null;
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        TreeSet<Date> dateSet = new TreeSet<>();
        for (UserLogger u : getSortedListByDate(after, before)
        ) {
            if (u.getUserName().equals(user) && u.getEvent().equals(Event.DONE_TASK) && u.getTaskNumber() == task) {
                dateSet.add(u.getDate());
            }
        }

        if (dateSet.size() > 0) {
            return dateSet.first();
        }
        return null;
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        Set<Date> dateSet = new HashSet<>();
        for (UserLogger u : getSortedListByDate(after, before)
        ) {
            if (u.getUserName().equals(user) && u.getEvent().equals(Event.WRITE_MESSAGE)) {
                dateSet.add(u.getDate());
            }
        }
        return dateSet;
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        Set<Date> dateSet = new HashSet<>();
        for (UserLogger u : getSortedListByDate(after, before)
        ) {
            if (u.getUserName().equals(user) && u.getEvent().equals(Event.DOWNLOAD_PLUGIN)) {
                dateSet.add(u.getDate());
            }
        }
        return dateSet;
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {

        return getAllEvents(after, before).size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        Set<Event> eventSet = new HashSet<>();
        for (UserLogger u : getSortedListByDate(after, before)
        ) {
            eventSet.add(u.getEvent());
        }
        return eventSet;
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        Set<Event> eventSet = new HashSet<>();
        for (UserLogger u : getSortedListByDate(after, before)
        ) {
            if (u.getIp().equals(ip)) {
                eventSet.add(u.getEvent());
            }

        }
        return eventSet;
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        Set<Event> eventSet = new HashSet<>();
        for (UserLogger u : getSortedListByDate(after, before)
        ) {
            if (u.getUserName().equals(user)) {
                eventSet.add(u.getEvent());
            }

        }
        return eventSet;
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        Set<Event> eventSet = new HashSet<>();
        for (UserLogger u : getSortedListByDate(after, before)
        ) {
            if (u.getStatus().equals(Status.FAILED)) {
                eventSet.add(u.getEvent());
            }

        }
        return eventSet;
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        Set<Event> eventSet = new HashSet<>();
        for (UserLogger u : getSortedListByDate(after, before)
        ) {
            if (u.getStatus().equals(Status.ERROR)) {
                eventSet.add(u.getEvent());
            }

        }
        return eventSet;
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        int count = 0;
        for (UserLogger u : getSortedListByDate(after, before)
        ) {
            if (u.getEvent().equals(Event.SOLVE_TASK) && u.getTaskNumber() == task) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        int count = 0;
        for (UserLogger u : getSortedListByDate(after, before)
        ) {
            if (u.getEvent().equals(Event.DONE_TASK) && u.getTaskNumber() == task) {
                count++;
            }
        }
        return count;
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (UserLogger u : getSortedListByDate(after, before)
        ) {
            if (u.getEvent().equals(Event.SOLVE_TASK)) {
                if (!map.containsKey(u.getTaskNumber())) {
                    map.put(u.getTaskNumber(), 1);
                } else {
                    Integer cont = map.get(u.getTaskNumber()) + 1;
                    map.put(u.getTaskNumber(), cont);
                }
            }
        }
        return map;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (UserLogger u : getSortedListByDate(after, before)
        ) {
            if (u.getEvent().equals(Event.DONE_TASK)) {
                if (!map.containsKey(u.getTaskNumber())) {
                    map.put(u.getTaskNumber(), 1);
                } else {
                    Integer cont = map.get(u.getTaskNumber()) + 1;
                    map.put(u.getTaskNumber(), cont);
                }
            }
        }
        return map;
    }



    @Override
    public Set<Object> execute(String query) {
        Set<Object> result = new HashSet<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        String field1;
        String field2 = null;
        String value1 = null;
        Date after = null;
        Date before = null;
        Pattern pattern = Pattern.compile("get (ip|user|date|event|status)"
                + "( for (ip|user|date|event|status) = \"(.*?)\")?"
                + "( and date between \"(.*?)\" and \"(.*?)\")?");
        Matcher matcher = pattern.matcher(query);
        matcher.find();
        field1 = matcher.group(1);
        if (matcher.group(2) != null) {
            field2 = matcher.group(3);
            value1 = matcher.group(4);
            if (matcher.group(5) != null) {
                try {
                    after = sdf.parse(matcher.group(6));
                    before = sdf.parse(matcher.group(7));
                } catch (ParseException e) {
                }
            }
        }

        if (field2 != null && value1 != null) {
            for (int i = 0; i < userLogger.size(); i++) {
                if (dateBetweenDates(userLogger.get(i).getDate(), after, before)) {
                    if (field2.equals("date")) {
                        try {
                            if (userLogger.get(i).getDate().getTime() == sdf.parse(value1).getTime()) {
                                result.add(getCurrentValue(userLogger.get(i), field1));
                            }
                        } catch (ParseException e) {
                        }
                    } else {
                        if (value1.equals(getCurrentValue(userLogger.get(i), field2).toString())) {
                            result.add(getCurrentValue(userLogger.get(i), field1));
                        }
                    }
                }
            }
        } else {
            for (int i = 0; i < userLogger.size(); i++) {
                result.add(getCurrentValue(userLogger.get(i), field1));
            }
        }

        return result;
    }
    private boolean dateBetweenDates(Date current, Date after, Date before) {
        if (after == null) {
            after = new Date(0);
        }
        if (before == null) {
            before = new Date(Long.MAX_VALUE);
        }
        return current.after(after) && current.before(before);
    }
    private Object getCurrentValue(UserLogger logEntity, String field) {
        Object value = null;
        switch (field) {
            case "ip": {
                Command method = new GetIpCommand(logEntity);
                value = method.execute();
                break;
            }
            case "user": {
                Command method = new GetUserCommand(logEntity);
                value = method.execute();
                break;
            }
            case "date": {
                Command method = new GetDateCommand(logEntity);
                value = method.execute();
                break;
            }
            case "event": {
                Command method = new GetEventCommand(logEntity);
                value = method.execute();
                break;
            }
            case "status": {
                Command method = new GetStatusCommand(logEntity);
                value = method.execute();
                break;
            }
        }
        return value;
    }
    private abstract class Command {
        protected UserLogger logEntity;

        abstract Object execute();
    }

    private class GetIpCommand extends Command {
        public GetIpCommand(UserLogger logEntity) {
            this.logEntity = logEntity;
        }

        @Override
        Object execute() {
            return logEntity.getIp();
        }
    }

    private class GetUserCommand extends Command {
        public GetUserCommand(UserLogger logEntity) {
            this.logEntity = logEntity;
        }

        @Override
        Object execute() {
            return logEntity.getUserName();
        }
    }

    private class GetDateCommand extends Command {
        public GetDateCommand(UserLogger logEntity) {
            this.logEntity = logEntity;
        }

        @Override
        Object execute() {
            return logEntity.getDate();
        }
    }

    private class GetEventCommand extends Command {
        public GetEventCommand(UserLogger logEntity) {
            this.logEntity = logEntity;
        }

        @Override
        Object execute() {
            return logEntity.getEvent();
        }
    }

    private class GetStatusCommand extends Command {
        public GetStatusCommand(UserLogger logEntity) {
            this.logEntity = logEntity;
        }

        @Override
        Object execute() {
            return logEntity.getStatus();
        }
    }
    /*
    .1. Реализуй интерфейс QLQuery у класса LogParser. Метод execute() пока должен поддерживать только следующие запросы:
5.1.1. get ip
5.1.2. get user
5.1.3. get date
5.1.4. get event
5.1.5. get status

Пример: Вызов метода execute("get ip") должен вернуть Set<String>, содержащий все уникальные IP из лога (это будет: 127.0.0.1, 12.12.12.12, 146.34.15.5, 192.168.100.2 для тестового файла). Аналогично должны работать и другие запросы.

Реальные объекты в возвращаемом множестве должны быть типа String для запросов ip и user, для запроса date - тип объектов Date, для event и status - Event и Status соответственно.


     */
}
/*
1.2.1. Метод getNumberOfUniqueIPs(Date after, Date before) должен возвращать количество уникальных IP адресов за выбранный период.
 Здесь и далее, если в методе есть параметры Date after и Date before, то нужно возвратить данные касающиеся только данного периода (включая даты after и before).
Если параметр after равен null, то нужно обработать все записи, у которых дата меньше или равна before.
Если параметр before равен null, то нужно обработать все записи, у которых дата больше или равна after.
Если и after, и before равны null, то нужно обработать абсолютно все записи (без фильтрации по дате).
1.2.2. Метод getUniqueIPs() должен возвращать множество, содержащее все не повторяющиеся IP. Тип в котором будем хранить IP будет String.
1.2.3. Метод getIPsForUser() должен возвращать IP, с которых работал переданный пользователь.
1.2.4. Метод getIPsForEvent() должен возвращать IP, с которых было произведено переданное событие.
1.2.5. Метод getIPsForStatus() должен возвращать IP, события с которых закончилось переданным статусом.

Реализацию метода main() можешь менять по своему усмотрению.

Реализуй интерфейс UserQuery у класса LogParser:
2.1. Метод getAllUsers() должен возвращать всех пользователей.
2.2. Метод getNumberOfUsers() должен возвращать количество уникальных пользователей.
2.3. Метод getNumberOfUserEvents() должен возвращать количество уникальных событий от определенного пользователя.
2.4. Метод getUsersForIP() должен возвращать пользователей с определенным IP.
Несколько пользователей могут использовать один и тот же IP.
2.5. Метод getLoggedUsers() должен возвращать пользователей, которые делали логин.
2.6. Метод getDownloadedPluginUsers() должен возвращать пользователей, которые скачали плагин.
2.7. Метод getWroteMessageUsers() должен возвращать пользователей, которые отправили сообщение.
2.8. Метод getSolvedTaskUsers(Date after, Date before) должен возвращать пользователей, которые решали любую задачу.
2.9. Метод getSolvedTaskUsers(Date after, Date before, int task) должен возвращать пользователей, которые решали задачу с номером task.
2.10. Метод getDoneTaskUsers(Date after, Date before) должен возвращать пользователей, которые решили любую задачу.
2.11. Метод getDoneTaskUsers(Date after, Date before, int task) должен возвращать пользователей, которые решили задачу с номером task.



3.1. Метод getDatesForUserAndEvent() должен возвращать даты, когда определенный пользователь произвел определенное событие.
3.2. Метод getDatesWhenSomethingFailed() должен возвращать даты, когда любое событие не выполнилось (статус FAILED).
3.3. Метод getDatesWhenErrorHappened() должен возвращать даты, когда любое событие закончилось ошибкой (статус ERROR).
3.4. Метод getDateWhenUserLoggedFirstTime() должен возвращать дату, когда пользователь залогинился впервые за указанный период. Если такой даты в логах нет - null.
3.5. Метод getDateWhenUserSolvedTask() должен возвращать дату, когда пользователь впервые попытался решить определенную задачу. Если такой даты в логах нет - null.
3.6. Метод getDateWhenUserDoneTask() должен возвращать дату, когда пользователь впервые решил определенную задачу. Если такой даты в логах нет - null.
3.7. Метод getDatesWhenUserWroteMessage() должен возвращать даты, когда пользователь написал сообщение.
3.8. Метод getDatesWhenUserDownloadedPlugin() должен возвращать даты, когда пользователь скачал плагин.


4.1. Метод getNumberOfAllEvents() должен возвращать количество событий за указанный период.
4.2. Метод getAllEvents() должен возвращать все события за указанный период.
4.3. Метод getEventsForIP() должен возвращать события, которые происходили с указанного IP.
4.4. Метод getEventsForUser() должен возвращать события, которые инициировал
определенный пользователь.
4.5. Метод getFailedEvents() должен возвращать события, которые не выполнились.
4.6. Метод getErrorEvents() должен возвращать события, которые завершились ошибкой.
4.7. Метод getNumberOfAttemptToSolveTask() должен возвращать количество попыток
решить определенную задачу.
4.8. Метод getNumberOfSuccessfulAttemptToSolveTask() должен возвращать количество
успешных решений определенной задачи.
4.9. Метод getAllSolvedTasksAndTheirNumber() должен возвращать мапу (номер_задачи :
количество_попыток_решить_ее).
4.10. Метод getAllDoneTasksAndTheirNumber() должен возвращать мапу (номер_задачи :
сколько_раз_ее_решили).
 */