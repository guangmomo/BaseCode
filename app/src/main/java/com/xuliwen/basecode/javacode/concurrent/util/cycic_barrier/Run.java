package com.xuliwen.basecode.javacode.concurrent.util.cycic_barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by xlw on 2017/6/24.
 */

public class Run implements Runnable{

    private  CyclicBarrier cyclicBarrier=new CyclicBarrier(100,this);

    public static void main(String[] args) {
       new Run().test();
    }

    private void test(){
        for(int i=0;i<100;i++){
//            Thread thread2=new MyThread2();
//            thread2.setName("2222222222222222222222222222222");
//            thread2.start();
            Thread thread1=new MyThread1();
            thread1.setName(i+"");
            thread1.start();
        }
    }

    @Override
    public void run() {
        System.out.println("Run类线程被执行");
    }

    private  class MyThread1 extends Thread{
        @Override
        public void run() {
            try {
                cyclicBarrier.await();
                System.out.println("MyThread1 name: "+Thread.currentThread().getName());
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }



    private  class MyThread2 extends Thread{
        @Override
        public void run() {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("MyThread2 name: "+Thread.currentThread().getName());
        }
    }



}
