package com.xuliwen.basecode.javacode.concurrent.util.join;

/**
 * Created by xlw on 2017/6/23.
 */

public class JoinTest {
    private static Thread thread1;
    private static Thread thread2;

    public static void main(String[] args) {
        Thread.currentThread().setName("UI thread");

        thread1=new Thread1();
        thread1.setName("A");

        thread2=new Thread2();
        thread2.setName("B");

        try {
            thread1.join();
            thread2.join();
            thread1.start();
            thread2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



    static class Thread1 extends Thread{

        public Thread1(){
            System.out.println("构造方法："+Thread.currentThread().getName());
            System.out.println("构造方法："+this.getName());
        }

        @Override
        public void run() {
           System.out.println(Thread.currentThread().getName());
            System.out.println("this.getName()"+this.getName());
        }
    }

    static class Thread2 extends Thread{

        public Thread2(){
            System.out.println("构造方法："+Thread.currentThread().getName());
            System.out.println("构造方法："+this.getName());
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            System.out.println(this.getName());
        }
    }


}
