package com.xuliwen.basecode.javacode.concurrent.util.atomic.basic;

import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by xlw on 2017/6/25.
 */

public class AtomicTest {

    private   int j=0;
    private  AtomicInteger atomicInteger=new AtomicInteger(0);
    private  ConcurrentSkipListSet<Integer > concurrentSkipListSet=new ConcurrentSkipListSet<>();
    private  volatile CountDownLatch countDownLatch=new CountDownLatch(10000);


    public static void main(String[] args) {
        new AtomicTest().atomicTest();
    }

    void atomicTest(){
        for(int i=1;i<=10000;i++){
            new Thread(){
                @Override
                public void run() {
                   // int z=++j;
                    int z=atomicInteger.incrementAndGet();
                    concurrentSkipListSet.add(z);
                    countDownLatch.countDown();
                }
            }.start();
        }


        new Thread(){
            @Override
            public void run() {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Set size: "+concurrentSkipListSet.size());
                for(Integer integer:concurrentSkipListSet){
                    System.out.println(integer);
                }
            }
        }.start();

}





}


