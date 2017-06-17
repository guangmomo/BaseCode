package com.xuliwen.basecode.javacode.concurrent.wait_notify.yy_interviewer;

/**
 * Created by xlw on 2017/6/15.
 */

public class A extends Thread {
    public boolean isComplete() {
        return isComplete;
    }

    private boolean isComplete=false;//标志A的线程是否执行完成

    @Override
    public void run() {

            for (int i = 0; i < 10; i++) {
                System.out.println("执行A" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        isComplete = true;
        synchronized (this) {
            this.notifyAll();
        }
    }

}
