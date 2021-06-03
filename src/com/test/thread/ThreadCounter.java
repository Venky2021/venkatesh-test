package com.test.thread;

import java.util.concurrent.CountDownLatch;

public class ThreadCounter extends Thread {
    private CountDownLatch countDownLatch;
    private int maxValue;
    public ThreadCounter(CountDownLatch countDownLatch, int maxValue) {
        this.countDownLatch = countDownLatch;
        this.maxValue = maxValue;
    }

    @Override
    public void run() {
        for(int i = 0; i < maxValue; i++) {
            System.out.println(i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        countDownLatch.countDown();
    }
}
