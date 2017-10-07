package com.xuliwen.basecode.javacode.concurrent.util.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by xlw on 2017/6/23.
 */

public class CountDownLatchTest {


    private static CountDownLatch cThread =new CountDownLatch(100);
    private static CountDownLatch cStep=new CountDownLatch(3);


    public static void main(String[] args) {

        threadAwait();
        threadCountDown();
//        stepTest();

    }


    private static void threadAwait(){
        new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println("threadAwait1等待100条线程执行完");
                    cThread.await();
                    System.out.println("100条线程执行完了，threadAwait1继续执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println("threadAwait2等待100条线程执行完");
                    cThread.await();
                    System.out.println("100条线程执行完了，threadAwait2继续执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private static void threadCountDown(){
        for(int i=1;i<=100;i++){
            final int j=i;
            new Thread(){
                @Override
                public void run() {
                    System.out.println("线程"+j+"执行");
                    cThread.countDown();
                }
            }.start();
        }
    }

    private static void stepTest(){
        new Thread(){
            @Override
            public void run() {
                try {
                    cStep.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("cStep");
            }
        }.start();
        System.out.println("step1");
        cStep.countDown();
        System.out.println("step2");
        cStep.countDown();
        System.out.println("step3");
        cStep.countDown();
    }


}
