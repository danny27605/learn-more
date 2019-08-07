/**
 * 文件名：EventSource.java
 * 创建人：李春雨
 * 创建时间：2018年5月18日 下午12:13:23
 * 版权所有：知识产权出版社
 */
package com.cnipr.open.ms.test.pd.observer;

import java.util.Observable;
import java.util.Scanner;

/**
 * <p>[事件源类，继承Observable被观察者类，实现Runnable接口]</p>
 * 观察者模式应用Demo
 * @version v2.0
 * @since v2.0
 * @author 李春雨
 * @date 2018年5月18日 下午12:13:23
 * @Copyright 知识产权出版社
 */
public class EventSource extends Observable implements Runnable {
	
	/** 线程运行标志位 */
	private volatile boolean isRunning = true;
	
	@Override
	public void run() {
		System.out.println("被观察者线程：" + Thread.currentThread().getName() + " 启动。");
		Scanner scanner = new Scanner(System.in);
		while (isRunning) {
			// 被观察者从系统输入读取字符串，转发给观察者
			if (scanner.hasNext()) {
				String content = scanner.nextLine();
				if (content != null && !"exit".equals(content)) {
//					System.out.println("被观察者发布了事件，数据：" + content);
//					// 通知所有观察者，并传递通知内容
//					this.notifyObservers(content);
//					// 被观察者变化标志位
//					this.setChanged();
					// 通知所有被观察者对象
					notifyAllObservers(content);
				} else {
					isRunning = false;
					// 退出程序
//					System.exit(-1);
				}
			}
		} 
		scanner.close();
	}
	
	/**
	 * <p>【通知所有被观察者对象】</p>
	 * 
	 * @param content 通知内容
	 * @since v2.0
	 */
	public void notifyAllObservers(String content) {
		System.out.println("被观察者线程：" + Thread.currentThread().getName() + " 发布了事件，数据：" + content);
		// 通知所有观察者，并传递通知内容
		this.notifyObservers(content);
		// 被观察者变化标志位
		this.setChanged();
	}

	@Override
	public String toString() {
		return "EventSource [hasChanged()=" + hasChanged() + ", countObservers()=" + countObservers() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}


