/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public static Date parseDate(String dateStr) {

        try {
            return formatter.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String formatDate(Date date) {

        return formatter.format(date);
    }

    public static long daysBetween(Date startDate, Date endDate) {

        long diff = endDate.getTime() - startDate.getTime();

        return diff / (1000 * 60 * 60 * 24);
    }

}
