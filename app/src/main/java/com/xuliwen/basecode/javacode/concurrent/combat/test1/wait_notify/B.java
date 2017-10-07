package com.xuliwen.basecode.javacode.concurrent.combat.test1.wait_notify;

/**
 * Created by xlw on 2017/6/15.
 */

public class B extends Thread {
    private A a;
    public B(A a){
        this.a=a;
    }

    @Override
    public void run() {
        synchronized (a){
            while (!a.isComplete()){
                System.out.println("A没有执行完成，等待");
                try {
                    a.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("执行B");
        }
    }
}
