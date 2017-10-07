package com.xuliwen.basecode.javacode.concurrent.util.exchanger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Exchanger;

/**
 * Created by xlw on 2017/6/24.
 */

public class ExchangerTest {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new B(exchanger).start();
        new A(exchanger).start();
    }

}

class A extends Thread {
    Exchanger<String> exchanger = null;
    public A(Exchanger<String> exchanger) {
        super();
        this.exchanger = exchanger;
    }
    @Override
    public void run() {
        try {
            String fromB=exchanger.exchange("A");
            System.out.println("int A thread :fromB："+fromB);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class B extends Thread {
    Exchanger<String> exchanger = null;
    public B(Exchanger<String> exchanger) {
        super();
        this.exchanger = exchanger;
    }
    @Override
    public void run() {
        try {
                String fromB=exchanger.exchange("B");
            System.out.println("int B thread :fromA："+fromB);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
