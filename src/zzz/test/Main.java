package zzz.test;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("America/Chicago"));
        System.out.println("LocalDateTime: " + localDateTime);

        Instant instant = Instant.now();

        System.out.println("Instant : " + instant);

        //Convert instant to LocalDateTime, no timezone, add a zero offset / UTC+0
        LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneId.of("UTC"));

        System.out.println("LocalDateTime : " + ldt);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");

        String formatDateTime = ldt.format(formatter);
        System.out.println("After format: " + formatDateTime);


    }


}
