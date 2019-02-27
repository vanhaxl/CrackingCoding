package zzz.test;

import java.time.Instant;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println(Instant.now().getEpochSecond());
        Thread.sleep(1000);
        System.out.println(Instant.now().getEpochSecond());
        Thread.sleep(1000);
        System.out.println(Instant.now().getEpochSecond());
        Thread.sleep(1000);
        System.out.println(Instant.now().getEpochSecond());
        Thread.sleep(1000);
        System.out.println(Instant.now().getEpochSecond());
        Thread.sleep(1000);
        System.out.println(Instant.now().getEpochSecond());
        Thread.sleep(1000);
        System.out.println(Instant.now().getEpochSecond());
    }


}
