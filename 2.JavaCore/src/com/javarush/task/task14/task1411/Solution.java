package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        while (true) {
            String str = reader.readLine();
            if (str.equals("user")){
                person = new Person.User();
            doWork(person);
            } else if (str.equals("loser")) {
                person = new Person.Loser();
                doWork(person);
                    } else if (str.equals("coder")) {
            person = new Person.Coder();
            doWork(person);
            } else if (str.equals("proger")) {
                person = new Person.Proger();
                doWork(person);
            }
            else {
                break;
            }
        }
    }

    public static void doWork(Person person) {
       if (person instanceof Person.User){
           Person.User user = (Person.User) person;
           user.live();
           //((Person.User) person).live();
       } else if (person instanceof Person.Loser) {
           Person.Loser loser = (Person.Loser) person;
           loser.doNothing();
       } else if (person instanceof Person.Coder) {
           Person.Coder coder =(Person.Coder) person;
           coder.writeCode();
       } else if (person instanceof Person.Proger) {
           Person.Proger proger = (Person.Proger) person;
           proger.enjoy();
       }
    }

}
