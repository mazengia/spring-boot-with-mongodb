package com.example.mdbspringboot.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    public static LocalDate stringToLocalDate(String format, String date) {
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        return LocalDate.parse(date, dtf);
    }

    public static String formattedDate(String format, LocalDate localDate) {
        return localDate.format(DateTimeFormatter.ofPattern(format));
    }
}
