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
        System.out.println(currentMilliSecond);
        String stringDate =String.valueOf(currentMilliSecond);
        return stringDate;
    }
}
