/**
 * 文件名：ObserverImpl.java
 * 创建人：李春雨
 * 创建时间：2018年5月18日 下午12:32:55
 * 版权所有：知识产权出版社
 */
package com.cnipr.open.ms.test.pd.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * <p>[观察者对象实现类]</p>
 *
 * @version v2.0
 * @since v2.0
 * @author 李春雨
 * @date 2018年5月18日 下午12:32:55
 * @Copyright 知识产权出版社
 */
public class ObserverImpl implements Observer {
	
	private String name;
	
	public ObserverImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public ObserverImpl(String name) {
		this.name = name;
	}

	@Override
	public void update(Observable o, Object arg) {
		
		// 观察者收到更新通知后，要处理的动作在这里实现
		System.out.println("观察者：" + name + " 接收到更新通知：" + arg + "，当前观察者个数：" + o.countObservers());
		
	}

	@Override
	public String toString() {
		return "ObserverImpl [name=" + name + ",getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="+ super.toString() + "]";
	}

}
