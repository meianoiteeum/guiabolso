package br.com.guiabolso.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public final class DateUtils {

    private static DateUtils INSTANCE;

    public static synchronized DateUtils getInstance(){
        if(INSTANCE == null)
            INSTANCE = new DateUtils();
        return INSTANCE;
    }

    public static Date getDate(){
        LocalDateTime localDate = LocalDateTime.now();
        return Date.from(localDate.atZone(ZoneId.systemDefault()).toInstant());
    }
}
