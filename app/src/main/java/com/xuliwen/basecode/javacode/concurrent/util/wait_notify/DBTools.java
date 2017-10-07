package com.xuliwen.basecode.javacode.concurrent.util.wait_notify;

/**
 * Created by xlw on 2017/6/15.
 */

public class DBTools {
    private boolean isBackUpA=true;


    synchronized public void backUpB(){
        while (isBackUpA){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("bbbb");
        isBackUpA=true;
        this.notifyAll();
    }

    synchronized public void backUpA(){
        while (!isBackUpA){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("aaaaa");
        isBackUpA=false;
        this.notifyAll();
    }
}
