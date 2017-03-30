package com.petapplication.utility;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author admin
 */
public class DateUtils {

    public static String getCurrentMillisecond(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        long currentMilliSecond = calendar.getTimeInMillis();
        String stringDate = String.valueOf(currentMilliSecond);
        return stringDate;
    }

    public static Date addFiveMinuteToCurrentDate() {
        Long millisecond = Long.valueOf(getCurrentMillisecond(new Date()));
        System.out.println(millisecond + 3000000);
        return new Date(millisecond + 300000);
    }
    public static void main(String[] args) {
        addFiveMinuteToCurrentDate();
    }
}
