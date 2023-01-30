package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");

    }
    public static void main(String[] args) {

    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;

        @Override
        public String getCountryCode() {
            String countryCod = null;
            for (Map.Entry entry:countries.entrySet()
                 ) {
if (entry.getValue().equals(customer.getCountryName())){
    countryCod = (String) entry.getKey();
}
            }
            return countryCod;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String[] nameSplit =  contact.getName().split(" ");
            return nameSplit[1];
        }

        @Override
        public String getContactLastName() {
            String[] nameSplit =  contact.getName().split(", ");

            return nameSplit[0];
        }

        @Override
        public String getDialString() {
            String number = "";
            StringBuilder stringBuilder = new StringBuilder(number);
            char[] numberChars =  contact.getPhoneNumber().toCharArray();
            for (char numberChar: numberChars
                 ) {
                if(numberChar!='(' && numberChar!=')' && numberChar!='-'  && numberChar!='+'){
                    stringBuilder.append(numberChar);
                }
            }
            number = stringBuilder.toString();
            return "callto://+" + number;
        }
//callto://+380501234567
//For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}