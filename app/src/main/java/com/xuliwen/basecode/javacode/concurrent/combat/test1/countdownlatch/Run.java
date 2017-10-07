package com.xuliwen.basecode.javacode.concurrent.combat.test1.countdownlatch;


import java.util.concurrent.CountDownLatch;

/**
 * Created by xlw on 2017/6/15.
 */

public class Run {

    private static volatile CountDownLatch c=new CountDownLatch(1);

    public static void main(String[] args)
    {
        A a=new A(c);
        B b=new B(c);
        a.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        b.start();
    }
}
