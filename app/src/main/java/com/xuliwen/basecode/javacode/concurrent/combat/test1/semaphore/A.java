package com.xuliwen.basecode.javacode.concurrent.combat.test1.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Created by xlw on 2017/6/15.
 */

public class A extends Thread {
   private Semaphore semaphore;

    public A(Semaphore semaphore){
        this.semaphore=semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
                System.out.println("执行A" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        semaphore.release();
    }

}
