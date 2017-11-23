package com.xuliwen.basecode.javacode.looptest;


/*		for循环的执行顺序如下：
		for(sta1;sta2;sta3)
		{
		sta4;
		}

		1.进入循环执行sta1;//只是进入的时候执行.
		2.执行sta2;//条件为真才执行sta4,不然就跳出for了.
		3,执行sta4;
		4,执行sta3;
		5,再回到第2步开始执行
*/

public class ForTest {

	public static void main(String[] args) {
		new ForTest().forTest();
	}


	private void forTest() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}
		System.out.println("--------------------");
		for (int i = 0; i < 10; ++i) {
			System.out.println(i);
		}
		System.out.println("==================");
	}
}

