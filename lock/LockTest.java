package com.cnipr.open.ms.test.pd.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Bi Yunfei
 * @date 2019/7/26 10:50
 */
public class LockTest {
	private AtomicReference owner = new AtomicReference();

	public void lock() {
		Thread current = Thread.currentThread();
		//这句是很经典的“自旋”语法，AtomicInteger中也有
		for (;;) {
			if (!owner.compareAndSet(null, current)) {
				return;
			}
		}
	}

	public void unlock() {
		Thread current = Thread.currentThread();
		owner.compareAndSet(current, null);
	}

}
