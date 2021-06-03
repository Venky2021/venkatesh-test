package com.test.thread;

public class TestThreadOne extends Thread{
    @Override
    public void run() {
        System.out.println(this.getName());
    }
}
