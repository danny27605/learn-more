/**
 * 文件名：Test2.java
 * 创建人：李春雨
 * 创建时间：2018年7月11日 下午6:34:16
 * 版权所有：知识产权出版社
 */
package com.cnipr.open.ms.test.pd.thread;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import com.google.common.collect.Lists;

/**
 * <p>[TODO 简要描述该类功能]</p>
 *
 * @version v2.0
 * @since v2.0
 * @author 李春雨
 * @date 2018年7月11日 下午6:34:16
 * @Copyright 知识产权出版社
 */
public class ThreadTest {
	
//	AtomicInteger patCount = new AtomicInteger();

	/**
	 * <p>【TODO 简要描述该方法作用】</p>
	 * 
	 * @param args
	 * @since v2.0
	 */
	public static void main(String[] args) throws InterruptedException{
//		int nThreads = 10;
//		AtomicInteger patCount = new AtomicInteger();
//		ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
//		List<Callable<Integer>> consumers = Lists.newArrayList();
//		for (int i = 0; i < nThreads; i++) {
//			AtomicIntegerConsumer consumer = new AtomicIntegerConsumer(patCount);
//			consumers.add(consumer);
//		}
//		try {
//			List<Future<Integer>> futureList = executorService.invokeAll(consumers);
//			for (Future<Integer> future : futureList) {
//				if (future.isDone()) {
//					Integer retValue = future.get();
//					System.out.println(Thread.currentThread().getName() + "====" + retValue);
//				}
//			}
//			System.out.println("patCount = " + patCount);
//		} catch (InterruptedException | ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		// 关闭线程池
//		executorService.shutdown();
//		myThread myThread = new myThread();
//		myThread.start();
//		Thread th = new Thread(new my());
//		th.start();

		CountDownLatch count = new CountDownLatch(5);
		ExecutorService executorService = Executors.newFixedThreadPool(1);

		Callable<String> callable = new sommCall<>();
//		FutureTask futureTask = new FutureTask(callable);
//		Thread thread = new Thread(futureTask);
		List<Callable<String>>callables = Lists.newArrayList();
		for (int i = 0; i <5 ; i++) {
			callables.add(callable);
			count.countDown();
		}
		System.out.println("----------------开始----------------------");
		executorService.invokeAll(callables);
		System.out.println("----------------开始----------------------");
		count.await();
		System.out.println("----------------结束----------------------");
		executorService.shutdown();
//		thread.start();


	}

}
class myThread extends Thread{

	@Override
	public void run() {
		for (int i = 0; i <10 ; i++) {
			System.out.println(Thread.currentThread()+"---->"+i);
		}
	}
}
class my implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i <10 ; i++) {
			System.out.println(Thread.currentThread()+"---->"+i);
		}
	}
}

class sommCall<V> implements  Callable<V>{
	@Override
	public V call() throws Exception {
		for (int i = 0; i <5 ; i++) {
			System.out.println(Thread.currentThread()+"---->"+i);
		}
		return null;
	}
}