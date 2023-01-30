package com.javarush.task.task23.task2309;

import com.javarush.task.task23.task2309.vo.*;

import java.util.List;

/* 
Анонимность иногда так приятна!
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        print(solution.getUsers());
        print(solution.getLocations());
    }

    public static void print(List list) {
        String format = "Id=%d, name='%s', description=%s";
        for (Object obj : list) {
            NamedItem item = (NamedItem) obj;
            System.out.println(String.format(format, item.getId(), item.getName(), item.getDescription()));
        }
    }
    public List<Location> getLocations(){
//        AbstractDbSelectExecutor<Location> location = new AbstractDbSelectExecutor<>(){
//
//            @Override
//            public String getQuery() {
//                return "SELECT * FROM LOCATION";
//            }
//
//        };
//        return location.execute();
        return new AbstractDbSelectExecutor<Location>(){

            @Override
            public String getQuery() {
                return "SELECT * FROM LOCATION";
            }
        }.execute();
    }
    public List<Server> getServers(){
//        AbstractDbSelectExecutor<Server> server = new AbstractDbSelectExecutor<>(){
//
//            @Override
//            public String getQuery() {
//                return "SELECT * FROM SERVER";
//            }
//
//        };
//        return server.execute();
        return new AbstractDbSelectExecutor<Server>(){
            @Override
            public String getQuery() {
                return "SELECT * FROM SERVER";
            }
        }.execute();
    }
    public List<Subject> getSubjects(){
//        AbstractDbSelectExecutor<Subject> subject = new AbstractDbSelectExecutor<>(){
//
//            @Override
//            public String getQuery() {
//                return "SELECT * FROM SUBJECT";
//            }
//
//        };
//        return subject.execute();
        return new AbstractDbSelectExecutor<Subject>(){
            @Override
            public String getQuery() {
                return "SELECT * FROM SUBJECT";
            }
        }.execute();
    }
    public List<User> getUsers(){
//        AbstractDbSelectExecutor<User> user = new AbstractDbSelectExecutor<>(){
//
//            @Override
//            public String getQuery() {
//                return "SELECT * FROM USER";
//            }
//
//        };
//        return user.execute();
        return new AbstractDbSelectExecutor<User>(){
            @Override
            public String getQuery() {
                return "SELECT * FROM USER";
            }
        }.execute();
    }
    public List<Subscription> getSubscriptions(){
//        AbstractDbSelectExecutor<Subscription> subscription = new AbstractDbSelectExecutor<>(){
//
//            @Override
//            public String getQuery() {
//                return "SELECT * FROM SUBSCRIPTION";
//            }
//
//        };
//        return subscription.execute();
        return new AbstractDbSelectExecutor<Subscription>(){
            @Override
            public String getQuery() {
                return "SELECT * FROM SUBSCRIPTION";
            }
        }.execute();
    }
}
