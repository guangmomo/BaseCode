package com.xuliwen.basecode.javacode.concurrent.util.wait_notify;

/**
 * Created by xlw on 2017/6/15.
 */

public class BackUpA extends Thread {

    private DBTools mDBTools;

    public BackUpA(DBTools dbTools){
        mDBTools=dbTools;
    }

    @Override
    public void run() {
        while (true){
            mDBTools.backUpA();
        }
    }
}
