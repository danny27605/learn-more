package com.cnipr.open.ms.test.pd.lock;

/**
 * @author Bi Yunfei
 * @date 2019/8/9 13:42
 */
public class LockDemo {
	public static void main(String[] args) {
		Count count = new Count();
		try {
			/*
			当调用print()方法时，获得了锁，这时就无法再调用doAdd()方法，这时必须先释放锁才能调用，所以称这种锁为不可重入锁，也叫自旋锁。
			 */
//			count.print();

			/*
			第一个线程执行print()方法，得到了锁，使lockedBy等于当前线程，也就是说，执行的这个方法的线程获得了这个锁，执行add()方法时，同样要先获得锁，因不满足while循环的条件，
			也就是不等待，继续进行，将此时的lockedCount变量，也就是当前获得锁的数量加一，当释放了所有的锁，才执行notify()。
			如果在执行这个方法时，有第二个线程想要执行这个方法，因为lockedBy不等于第二个线程，导致这个线程进入了循环，也就是等待，不断执行wait()方法。
			只有当第一个线程释放了所有的锁，执行了notify()方法，第二个线程才得以跳出循环，继续执行。
			 */
			count.print1();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
