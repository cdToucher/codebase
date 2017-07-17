package me.codebase.java8.time;

import java.sql.Timestamp;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by chendong on 2017/3/2.
 * <p>
 * java date time test
 */
public class Timetest {

    static final String zoneId = "Asia/Shanghai";

    private static void print(Object object) {
        System.out.println(object);
    }

    public static void main(String[] args) {

        print(LocalDate.now());//LocalDate
        print(LocalDate.MAX);
        print(LocalDate.MIN);
        LocalDate localDate = LocalDate.of(2017, 2, 28);
        print(localDate.atStartOfDay());

        print(LocalTime.now().getSecond());// LocalTime
        print(LocalTime.now());
        print(LocalTime.of(5, 45, 12));

        print(LocalDateTime.of(2017, 2, 28, 5, 50, 12)); //LocalDateTime
        print(LocalDateTime.now().toLocalDate()); //LocalDateTime

        Instant instant = Instant.ofEpochMilli(System.currentTimeMillis()); // instant 处理unix 时间戳比较合适
        print(instant.getEpochSecond());
        print(instant.isAfter(Instant.ofEpochSecond(System.currentTimeMillis())));
        print(instant.getNano());
        print(Instant.now().toEpochMilli());

        print(getSomedayZeroPoint(System.currentTimeMillis()));
        print(getDayZeroPoint(System.currentTimeMillis()));

        print(getHourZeroPoint(System.currentTimeMillis()));
        print(getSomeDayHourZeroPoint(System.currentTimeMillis()));

    }

    private static long getSomeDayHourZeroPoint(long timestamp) {
        int hour = LocalTime.now().getHour();
        return Instant.ofEpochMilli(timestamp)
                .atZone(ZoneId.of(zoneId))
                .toLocalDate().atTime(LocalTime.of(hour, 0))
                .toInstant(ZoneOffset.ofHours(8))
                .toEpochMilli();
    }

    private static long getSomedayZeroPoint(long timestamp) {
        return Instant.ofEpochMilli(timestamp)
                .atZone(ZoneId.of(zoneId))
                .toLocalDate()
                .atStartOfDay()
                .toInstant(ZoneOffset.ofHours(8))
                .toEpochMilli();
    }

    private static void formatterBuilder() {
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        DateTimeFormatter timeFormatter = builder.toFormatter();
        timeFormatter.parse("yyyy-MM-dd hh-mm-ss");
    }

    public static long getDayZeroPoint(long timestamp) {
        Date date = new Date(timestamp);
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        Date date2 = new Date(date.getTime() - gc.get(Calendar.HOUR_OF_DAY) * 60 * 60
                * 1000 - gc.get(Calendar.MINUTE) * 60 * 1000 - gc.get(Calendar.SECOND)
                * 1000);
        return (new Timestamp(date2.getTime())).getTime() / 1000 * 1000;
    }

    public static long getHourZeroPoint(long timeStamp) {
        Date date = new Date(timeStamp);
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        Date date2 = new Date(date.getTime() - gc.get(Calendar.MINUTE) * 60 * 1000 - gc.get(Calendar.SECOND)
                * 1000);
        return (new Timestamp(date2.getTime())).getTime() / 1000 * 1000;
    }
}
