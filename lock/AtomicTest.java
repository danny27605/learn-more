package com.cnipr.open.ms.test.pd.lock;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Bi Yunfei
 * @date 2019/8/9 14:24
 */
public class AtomicTest implements Runnable {
	private static AtomicBoolean flag = new AtomicBoolean(true);

	public static void main(String[] args) {
		AtomicTest ast = new AtomicTest();
		Thread thread1 = new Thread(ast);
		Thread thread = new Thread(ast);
		thread1.start();
		thread.start();
	}

	@Override
	public void run() {
		System.out.println("thread:" + Thread.currentThread().getName() + ";flag:" + flag.get());
		if (flag.compareAndSet(true, false)) {
			System.out.println(Thread.currentThread().getName() + "" + flag.get());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			flag.set(true);
		} else {
			System.out.println("重试机制thread:" + Thread.currentThread().getName() + ";flag:" + flag.get());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			run();
		}

	}
}
