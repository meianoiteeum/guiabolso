package br.com.guiabolso.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

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

    public static LocalDate timestamp(){
        return LocalDate.ofInstant(new Date(ThreadLocalRandom.current().nextInt() * 1000L).toInstant(), ZoneId.systemDefault());
    }
}
