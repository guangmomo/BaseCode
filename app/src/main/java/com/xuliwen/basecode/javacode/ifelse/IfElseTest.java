package com.xuliwen.basecode.javacode.ifelse;

/**
 * Created by xuliwen on 2017/10/28.
 * 在if,else if,else语句块中吗， 如果一条分支符合条件，那么语句块将结束
 * 如下所示：只会执行System.out.println("a<2");
 * 
 * 
 * 
 */

public class IfElseTest {
	
	private static int a = 1;
	
	public static void main(String[] args){
		if (a<2) {
			System.out.println("a<2");
		} else if(a<3) {
			System.out.println("a<3");
		} else if(a<4) {
			System.out.println("a<4");
		} else {
			System.out.println("a<");
		}
	}
}
