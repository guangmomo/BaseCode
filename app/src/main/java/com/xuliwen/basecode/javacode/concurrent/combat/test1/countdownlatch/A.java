package com.xuliwen.basecode.javacode.concurrent.combat.test1.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by xlw on 2017/6/15.
 */

public class A extends Thread {

    private CountDownLatch countDownLatch;

    public A(CountDownLatch countDownLatch){
        this.countDownLatch=countDownLatch;
    }


    @Override
    public void run() {
            for (int i = 0; i < 20; i++) {
                System.out.println("执行A" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        countDownLatch.countDown();
    }

}
