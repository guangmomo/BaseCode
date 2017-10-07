package com.xuliwen.basecode.javacode.concurrent.util.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Created by xlw on 2017/6/12.
 */

public class MutexPrint {

    private Semaphore semaphore=new Semaphore(1);

    private void print() throws InterruptedException {
        semaphore.acquire();

        System.out.println(Thread.currentThread().getName()+" enter ...");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + "正在打印 ...");
        System.out.println(Thread.currentThread().getName()+" out ...");

        semaphore.release();
    }


    public static void main(String[] args)
    {
        final MutexPrint print = new MutexPrint();

        /**
         * 开启10个线程，抢占打印机
         */
        for (int i = 0; i < 10; i++)
        {
            new Thread()
            {
                public void run()
                {
                    try
                    {
                        print.print();
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                };
            }.start();
        }

    }
}
