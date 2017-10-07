package com.xuliwen.basecode.javacode.concurrent.util.semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Created by xlw on 2017/6/12.
 */

public class ConnectPool {

    private List<Con> cons=new ArrayList<>(3);
    private Semaphore semaphore=new Semaphore(3);


    public ConnectPool(){
        cons.add(new Con());
        cons.add(new Con());
        cons.add(new Con());
    }

    private Con getCon() {
        Con con=null;
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (cons){
            con=cons.remove(0);
        }
        System.out.println(Thread.currentThread().getName()+" get a conn " + con);
        return con;
    }

    private void releaseCon(Con con){
        cons.add(con);
        semaphore.release();
        System.out.println(Thread.currentThread().getName()+" release a conn " + con);
    }


    public static void main(String[] args)
    {
        final ConnectPool connectPool=new ConnectPool();

        new Thread(){
            @Override
            public void run() {
                Con con=connectPool.getCon();
                try {
                    Thread.sleep(3*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                connectPool.releaseCon(con);
            }
        }.start();

        for(int i=0; i<3; i++){
            new Thread(){
                @Override
                public void run() {
                    connectPool.getCon();
                }
            }.start();
        }


    }



    /**
     * 连接
     */
    private static class Con{
    }
}
