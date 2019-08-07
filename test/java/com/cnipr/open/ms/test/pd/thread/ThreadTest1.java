package com.cnipr.open.ms.test.pd.thread;

/**
 * @author Bi Yunfei
 * @date 2019/7/22 8:20
 */
public class ThreadTest1 {
	public static void main(String[] args) {
		MyThread mythread = new MyThread();
		new Thread(new Runnable()//传递给Thread的是一个实现了Runnable接口的匿名内部类的对象的引用
		{
			@Override
			public void run() {
				for (int i = 1; i <= 50; i++) {
					mythread.subThread(i);
				}
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i <= 50; i++) {
					mythread.mainThread(i);
				}
			}
		}).start();
	}
}

class MyThread {
	public synchronized void subThread(int j) {
		for (int i = 1; i <= 10; i++) {
			System.err.println("子线程" + j + ":循环" + i + "次");
		}
		notifyAll();
		try {
			if (j != 50) {
				wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void mainThread(int j) {
		for (int i = 1; i <= 100; i++) {
			System.out.println("主线程" + j + ":循环" + i + "次");
		}
		notifyAll();
		try {
			if (j != 50) {
				wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
