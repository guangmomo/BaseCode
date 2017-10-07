package com.xuliwen.basecode.javacode.concurrent.combat.test1.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by xlw on 2017/6/15.
 */

public class B extends Thread {

    private CountDownLatch countDownLatch;

    public B(CountDownLatch countDownLatch){
        this.countDownLatch=countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println("尝试执行B");
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行B");

    }
}
