package com.xuliwen.basecode.javacode.concurrent.wait_notify.yy_interviewer;

import com.xuliwen.basecode.javacode.concurrent.wait_notify.BackUpA;
import com.xuliwen.basecode.javacode.concurrent.wait_notify.BackUpB;
import com.xuliwen.basecode.javacode.concurrent.wait_notify.DBTools;

/**
 * Created by xlw on 2017/6/15.
 */

public class Run {

    public static void main(String[] args)
    {
        A a=new A();
        B b=new B(a);
        a.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        b.start();
    }
}
