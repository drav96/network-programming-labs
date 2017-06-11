package com.company;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        ExecutorService service = new ScheduledThreadPoolExecutor(3);

        new Thread(() -> {
            System.out.println("First Thread started.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            IntStream.rangeClosed(2, 4).
                    forEach(element -> service.submit(new CustomThread(Integer.toString(element), countDownLatch)));

        }).start();

        new Thread(() -> {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread 5 executed !");
        }).start();


        countDownLatch.await();
        service.shutdown();
        service.awaitTermination(1, TimeUnit.DAYS);
    }
}
