package zzz.test;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Main2 {
    public static void main(String[] args) {
        ZoneId zoneId = ZoneId.of("America/Chicago");

        String s = Instant.now().atZone(zoneId).toString();
        System.out.println(s);
        System.out.println(Instant.now().toString());

        System.out.println(createInstantTime());
    }

    public static String createInstantTime() {
        Calendar cal = Calendar.getInstance();
        TimeZone timeZone = TimeZone.getTimeZone("CST");
        cal.setTimeZone(timeZone);

        Date cstDate = cal.getTime();
        return parse(cstDate, "yyyy-MM-dd'T'HH:mm:ss.SSSX");
    }

    public static String parse(Date date, String to) {
        SimpleDateFormat fromDate = new SimpleDateFormat(to, Locale.ENGLISH);
        return fromDate.format(date);
    }
}
