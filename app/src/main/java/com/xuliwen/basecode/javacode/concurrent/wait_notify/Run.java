package com.xuliwen.basecode.javacode.concurrent.wait_notify;

import com.xuliwen.basecode.javacode.concurrent.semaphore.MutexPrint;

/**
 * Created by xlw on 2017/6/15.
 */

public class Run {


    public static void main(String[] args)
    {
        DBTools dbTools=new DBTools();
        for(int i=0;i<10;i++){
            BackUpA backUpA=new BackUpA(dbTools);
            BackUpB backUpB=new BackUpB(dbTools);
            backUpA.start();
            backUpB.start();
        }
    }
}
