package com.xuliwen.basecode.javacode.concurrent.current_thread;


/**
 * CountOperate作为线程的target
 */
public class CountOperate extends Thread {

	public CountOperate() {
		System.out.println("CountOperate---begin");
		System.out.println("Thread.currentThread().getName()="
				+ Thread.currentThread().getName());
		System.out.println("this.getName()=" + this.getName());
		System.out.println("CountOperate---end");
	}

	@Override
	public void run() {
		System.out.println("run---begin");
		System.out.println("Thread.currentThread().getName()="
				+ Thread.currentThread().getName()); //表示的是线程本身的name,即name=thread self
		System.out.println("this.getName()=" + this.getName());//表示的是线程target的name，即name=target
		System.out.println("run---end");
	}

}
