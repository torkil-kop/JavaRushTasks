package com.javarush.task.task19.task1903;

import java.util.HashMap;
import java.util.Map;

/* 
Адаптация нескольких интерфейсов
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
IncomeData incomeData = new IncomeData() {
    @Override
    public String getCountryCode() {
        return null;
    }

    @Override
    public String getCompany() {
        return null;
    }

    @Override
    public String getContactFirstName() {
        return null;
    }

    @Override
    public String getContactLastName() {
        return null;
    }

    @Override
    public int getCountryPhoneCode() {
        return 38;
    }

    @Override
    public int getPhoneNumber() {
        return 71112233;
    }
};
Contact contact = new IncomeDataAdapter(incomeData);
        System.out.println(contact.getPhoneNumber());
    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;


        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            StringBuilder number = new StringBuilder(data.getPhoneNumber() + "");
            for (int i = number.length(); i < 10; i++) {
                number.insert(0, "0");
            }
            String firstNum = number.substring(0,3);
            String secondNum = number.substring(3, 6);
            String theirdNum = number.substring(6,8);
            String forthNum = number.substring(8);
            return "+" + data.getCountryPhoneCode()+ "("+ firstNum + ")"+ secondNum+ "-"+ theirdNum + "-" + forthNum;
        }
        //For example1: +38(050)123-45-67, For example2: +38(007)111-22-33
        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }
    }


    public interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example1: 501234567, For example2: 71112233
    }

    public interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example1: +38(050)123-45-67, For example2: +38(007)111-22-33
    }
}