package com.javarush.task.pro.task13.task1319;

/* 
Месяцы в сезоне
*/

public enum Month {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;

    public static Month[] getWinterMonths()
    {
        Month[] WinterMonths = new Month[]{DECEMBER, JANUARY, FEBRUARY};
                return WinterMonths;
    }

    public static Month[] getSpringMonths()
    {
        Month[] SpringMonths = new Month[]{MARCH, APRIL, MAY};
        return SpringMonths;
    }
    public static Month[] getSummerMonths()
    {
        Month[] SummerMonths = new Month[]{JUNE, JULY, AUGUST};
        return SummerMonths;
    }
    public static Month[] getAutumnMonths()
    {
        Month[] AutumnMonths = new Month[]{SEPTEMBER, OCTOBER, NOVEMBER};
        return AutumnMonths;
    }

}
