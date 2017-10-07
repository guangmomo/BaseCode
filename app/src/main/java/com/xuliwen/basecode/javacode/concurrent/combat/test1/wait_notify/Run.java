package com.xuliwen.basecode.javacode.concurrent.combat.test1.wait_notify;

/**
 * Created by xlw on 2017/6/15.
 */

public class Run {

    public static void main(String[] args)
    {
        A a=new A();
        B b=new B(a);
        a.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        b.start();
    }
}
