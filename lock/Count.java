package com.cnipr.open.ms.test.pd.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Bi Yunfei
 * @date 2019/8/9 13:37
 */
public class Count {
	Lock lock = new Lock();

	/*
	不可重入锁测试
	 */
	public void print() throws InterruptedException {
		System.out.println("print");
		lock.lock();
		System.out.println("print add lock");
		doAdd();
		lock.unLick();
		System.out.println("print delete lock");
	}

	public void doAdd() throws InterruptedException {
		System.out.println("doAdd");
		lock.lock();
		System.out.println("doAdd add lock");
		lock.unLick();
		System.out.println("doAdd delete lock");
	}

	/*
	可重入锁测试
	 */
	public void print1() throws InterruptedException {
		System.out.println("print1");
		lock.lock1();
		System.out.println("print1 add lock");
		add();
		lock.unLick1();
		System.out.println("print1 delete lock");
	}

	public void add() throws InterruptedException {
		System.out.println("add");
		lock.lock1();
		System.out.println("add add lock");
		lock.unLick1();
		System.out.println("add delete lock");
	}


	private static int count = 0;
	private static AtomicInteger anInt = new AtomicInteger(0);

	public static void main(String[] args) {
		//CAS实现计数器
		for (int i = 0; i < 100; i++) {
			System.err.println(anInt);
			if (anInt.compareAndSet(i, i + 1)) {
				System.out.println(i);
			}
		}
		//悲观锁实现的计数器
		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(10);
					} catch (Exception e) {
						e.printStackTrace();
					}
					//每个线程让count自增100次
					for (int i = 0; i < 100; i++) {
						/*
						加了同步锁之后，count自增的操作变成了原子性操作
						但是Synchronized虽然确保了线程的安全，但是在性能上却不是最优的，Synchronized关键字会让没有得到锁资源的线程进入BLOCKED状态，
						而后在争夺到锁资源后恢复为RUNNABLE状态，这个过程中涉及到操作系统用户模式和内核模式的转换，代价比较高。
						 */
						synchronized (Count.class){
							System.out.println(count++);
						}
						/*
						or
						使用AtomicInteger类，实现同步
						 */
						System.err.println(anInt.incrementAndGet());
					}
				}
			}).start();
		}

		try{
			Thread.sleep(2000);
		}catch (Exception e){
			e.printStackTrace();
		}
		System.out.println(count);
	}

}
