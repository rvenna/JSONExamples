package com.abonado.jsr353.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DateUtil {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static String getDate(Date date) {
        return SIMPLE_DATE_FORMAT.format(date);
    }

    public static Date getDate(String date) {

        try {
            return SIMPLE_DATE_FORMAT.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
