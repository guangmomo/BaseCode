package com.xuliwen.basecode.javacode.concurrent.combat.test1.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Created by xlw on 2017/6/15.
 */

public class Run {

    private static volatile Semaphore semaphore=new Semaphore(1);

    public static void main(String[] args)
    {
        A a=new A(semaphore);
        B b=new B(semaphore);
        a.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        b.start();
    }
}
