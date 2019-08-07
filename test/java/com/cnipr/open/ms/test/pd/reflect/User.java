/**
 * 文件名：User.java
 * 创建人：李春雨
 * 创建时间：2018年7月5日 下午1:57:34
 * 版权所有：知识产权出版社
 */
package com.cnipr.open.ms.test.pd.reflect;

/**
 * <p>[TODO 简要描述该类功能]</p>
 *
 * @version v2.0
 * @since v2.0
 * @author 李春雨
 * @date 2018年7月5日 下午1:57:34
 * @Copyright 知识产权出版社
 */
public class User {
	
	private int age;
	
	private String name;

	public User() {
		super();
	}

	public User(String name) {
		super();
		this.name = name;
	}

	private User(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [age=" + age + ", name=" + name + "]";
	}
	
}
