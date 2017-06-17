package com.xuliwen.basecode.javacode.concurrent.wait_notify.yy_interviewer;

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
            if(!a.isComplete()){
                System.out.println("A没有执行完成，等待");
                try {
                    a.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                System.out.println("A已经执行完成，不需要等待");
            }
            System.out.println("执行B");
        }
    }
}
