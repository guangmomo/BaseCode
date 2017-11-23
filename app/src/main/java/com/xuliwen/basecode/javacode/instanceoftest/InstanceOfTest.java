package com.xuliwen.basecode.javacode.instanceoftest;

import com.xuliwen.basecode.utils.P;

/**
 * Created by xuliwen on 2017/11/8.
 */

public class InstanceOfTest {
	
	public static void main(String[] args){
		new InstanceOfTest().instanceOfTest();
	}
	
	private void instanceOfTest(){
		P.println(String.valueOf(null instanceof InstanceOfTest));
	}
}
