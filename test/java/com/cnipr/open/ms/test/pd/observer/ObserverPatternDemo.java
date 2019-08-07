/**
 * 文件名：ObserverPatternDemo.java
 * 创建人：李春雨
 * 创建时间：2018年5月18日 下午12:18:26
 * 版权所有：知识产权出版社
 */
package com.cnipr.open.ms.test.pd.observer;

import java.util.Observer;

/**
 * <p>[观察者模式示例类]</p>
 *
 * @version v2.0
 * @since v2.0
 * @author 李春雨
 * @date 2018年5月18日 下午12:18:26
 * @Copyright 知识产权出版社
 */
public class ObserverPatternDemo {

	public static void main(String[] args) {
		
		// 事件源类，继承了Observable被观察者类
		EventSource eventSource = new EventSource();
		
		// 观察者接口实现类（实例）
		Observer o1 = new ObserverImpl("李雷");
		Observer o2 = new ObserverImpl("韩梅梅");
		
		// 被观察者对象，添加观察者对象实例（可以添加多个）
		eventSource.addObserver(o1);
		eventSource.addObserver(o2);
		
		// 启动被观察者线程
//		eventSource.run();
		new Thread(eventSource).start();
//		new Thread(eventSource).start();
		
	}

}
