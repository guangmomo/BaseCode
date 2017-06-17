package com.xuliwen.basecode.javacode.concurrent.wait_notify;

/**
 * Created by xlw on 2017/6/15.
 */

public class BackUpB extends Thread {
    private DBTools mDBTools;

    public BackUpB(DBTools dbTools){
        mDBTools=dbTools;
    }

    @Override
    public void run() {
        while (true){
            mDBTools.backUpB();
        }
    }
}
