package com.company;

import java.util.concurrent.CountDownLatch;

public class CustomThread implements Runnable {
    private CountDownLatch countDownLatch;
    private String threadName;

    public CustomThread(String threadName, CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
        this.threadName = threadName;
    }


    @Override
    public void run() {

        System.out.println("Thread " + threadName + " executing ...");
        try {
            Thread.sleep((long) (Math.random() * 4000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread " + threadName + " finished.");

        countDownLatch.countDown();
    }
}
