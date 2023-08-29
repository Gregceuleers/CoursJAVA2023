package be.bstorm.multithreading;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class LifeCycleThread {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                System.out.println("START [" + Instant.ofEpochMilli(System.currentTimeMillis()) + "] " + Thread.currentThread().getName() + "::" + Thread.currentThread().getState());
                Thread.sleep(2000);
                System.out.println("PROGRES [" + Instant.ofEpochMilli(System.currentTimeMillis()) + "] " + Thread.currentThread().getName() + "::" + Thread.currentThread().getState());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Mon thread");

        System.out.println("CREATION  [" + Instant.ofEpochMilli(System.currentTimeMillis()) + "] " + thread.getName() + "::" + thread.getState());
        thread.start();
        try {
            Thread.sleep(3000);
            System.out.println("END  [" + Instant.ofEpochMilli(System.currentTimeMillis()) + "] " + thread.getName() + "::" + thread.getState());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
