package com.test.thread;

public class TestThreadTwo implements Runnable {
    @Override
    public void run() {
        System.out.println(this.getClass());
    }
}
