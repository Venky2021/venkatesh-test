package com.test.thread;

public class FibonacciThread extends Thread {
    @Override
    public void run() {
        int n1=0,n2=1,n3,i,count=3;
        System.out.print(n1+" "+n2);

        for(i=2;i<count;++i)
        {
            n3=n1+n2;
            System.out.print(" "+n3);
            n1=n2;
            n2=n3;
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
