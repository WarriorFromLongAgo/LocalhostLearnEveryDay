package com.day17_Date;

import java.util.Calendar;

public class CalendarDemo {
    public static void main(String[] args) {
        CalendarD();
    }

    public static void CalendarD() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        int year = calendar.get(Calendar.YEAR);
        int mouth = calendar.get(Calendar.MONTH);
        int dayOfMouth = calendar.get(Calendar.DAY_OF_MONTH);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        System.out.println(year + " 年 " + mouth + " 月 " + dayOfMouth + " 日 周" + dayOfWeek);


        calendar.set(Calendar.YEAR,1000);
        year = calendar.get(Calendar.YEAR);
        System.out.println(year + " 年 " + mouth + " 月 " + dayOfMouth + " 日 周" + dayOfWeek);

        calendar.set(2000,9,20);
        year = calendar.get(Calendar.YEAR);
        mouth = calendar.get(Calendar.MONTH);
        dayOfMouth = calendar.get(Calendar.DAY_OF_MONTH);
        dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        System.out.println(year + " 年 " + mouth + " 月 " + dayOfMouth + " 日 周" + dayOfWeek);


    }
}
