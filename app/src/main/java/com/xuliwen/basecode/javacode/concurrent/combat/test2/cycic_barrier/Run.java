package com.xuliwen.basecode.javacode.concurrent.combat.test2.cycic_barrier;


import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by xlw on 2017/6/25.
 */

public class Run implements Runnable{

    private ConcurrentHashMap<String ,Integer> concurrentHashMap=new ConcurrentHashMap<>();
    private CyclicBarrier cyclicBarrier=new CyclicBarrier(3,this);

    public static void main(String[] args) {
      new Run().test();
    }

    private void test(){
        for(int i=0;i<3;i++){
            new Thread(){
                @Override
                public void run() {
                    concurrentHashMap.put(Thread.currentThread().getName(),1);
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }

    @Override
    public void run() {
        int sum=0;
        for(Map.Entry<String ,Integer> entry:concurrentHashMap.entrySet()){
            sum+=entry.getValue();
        }
        System.out.println("结果为："+sum);
    }
}
