package com.xuliwen.basecode.javacode.concurrent.combat.test1.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Created by xlw on 2017/6/15.
 */

public class B extends Thread {
    private Semaphore semaphore;

    public B(Semaphore semaphore){
        this.semaphore=semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release();
        System.out.println("执行B");
        }
}
