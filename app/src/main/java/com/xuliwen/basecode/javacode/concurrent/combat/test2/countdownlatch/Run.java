package com.xuliwen.basecode.javacode.concurrent.combat.test2.countdownlatch;

import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by xlw on 2017/6/25.
 */

public class Run {
    private ConcurrentHashMap<String ,Integer> concurrentHashMap=new ConcurrentHashMap<>();
    private CountDownLatch countDownLatch=new CountDownLatch(3);

    public static void main(String[] args) {
       new Run().test();
    }

    private void test(){

        new Thread(){
            @Override
            public void run() {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int sum=0;
                for(Map.Entry<String ,Integer> entry:concurrentHashMap.entrySet()){
                    sum+=entry.getValue();
                }
                System.out.println("结果为："+sum);
            }
        }.start();

        for(int i=0;i<3;i++){
            new Thread(){
                @Override
                public void run() {
                    concurrentHashMap.put(Thread.currentThread().getName(),1);
                    countDownLatch.countDown();

                }
            }.start();
        }
    }


}
