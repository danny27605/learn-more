/**
 * 文件名：AtomicIntegerConsumer.java
 * 创建人：李春雨
 * 创建时间：2018年7月11日 下午6:33:08
 * 版权所有：知识产权出版社
 */
package com.cnipr.open.ms.test.pd.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>[TODO 简要描述该类功能]</p>
 *
 * @version v2.0
 * @since v2.0
 * @author 李春雨
 * @date 2018年7月11日 下午6:33:08
 * @Copyright 知识产权出版社
 */
public class AtomicIntegerConsumer implements Callable<Integer> {
	
	AtomicInteger patCount = new AtomicInteger();
	
	public AtomicIntegerConsumer(AtomicInteger patCount) {
		this.patCount = patCount;
	}
	
	public int addAndGet(int num) {
		return patCount.addAndGet(num);
	}

	@Override
	public Integer call() throws Exception {
		System.out.println(Thread.currentThread().getName() +"||"+ patCount.hashCode());
		
		for (int i = 0; i < 50; i++) {
			Thread.sleep((long) (1000 * Math.random()));
			int success = 10;
			int successNum = patCount.addAndGet(success);
//			int successNum = addAndGet(success);
			System.out.println((i+1) +" ===== "+ Thread.currentThread().getName() +"||successNum = "+ successNum);
		}
		return patCount.get();
	}

}
