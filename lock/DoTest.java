package com.cnipr.open.ms.test.pd.lock;

/**
 * @author Bi Yunfei
 * @date 2019/7/26 10:52
 */
public class DoTest {
	public static void main(String[] args) {
		LockTest lockTest = new LockTest();
		System.out.println("before add lock");
		lockTest.lock();
		System.out.println("after add lock");
		lockTest.lock();
		System.out.println("end add lock");
	}
}
