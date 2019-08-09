package com.cnipr.open.ms.test.pd.lock;

/**
 * @author Bi Yunfei
 * @date 2019/8/9 13:32
 */
public class Lock {

	/*是否加锁标志*/
	private boolean isLocked = false;

	/**
	 * 不可重入锁
	 * 加锁
	 *
	 * @throws InterruptedException
	 */
	public synchronized void lock() throws InterruptedException {
		System.err.println(Thread.currentThread().getName()+1);
		while (isLocked) {
			wait();
		}
		isLocked = true;
	}

	/**
	 * 不可重入锁
	 * 删除锁
	 */
	public synchronized void unLick() {
		System.err.println(Thread.currentThread().getName()+2);
		isLocked = false;
		notify();
	}

	//可重入线程
	volatile Thread lockBy = null;
	//重入锁计数
	volatile int lockCount = 0;

	/**
	 * 可重入锁
	 * 加锁
	 *
	 * @throws InterruptedException
	 */
	public synchronized void lock1() throws InterruptedException {
		System.err.println(Thread.currentThread().getName()+3);
		Thread thread = Thread.currentThread();
		while (isLocked && lockBy != thread) {
			wait();
		}
		isLocked = true;
		lockCount++;
		lockBy = thread;
	}

	/**
	 * 可重入锁
	 * 删除锁
	 */
	public synchronized void unLick1() {
		System.err.println(Thread.currentThread().getName()+4);
		if (lockBy == Thread.currentThread()) {
			lockCount--;
			if (lockCount == 0) {
				isLocked = false;
				notify();
			}
		}
	}
}
