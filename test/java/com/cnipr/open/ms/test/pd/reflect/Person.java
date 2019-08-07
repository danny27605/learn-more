/**
 * 文件名：Person.java
 * 创建人：李春雨
 * 创建时间：2018年7月5日 下午4:14:31
 * 版权所有：知识产权出版社
 */
package com.cnipr.open.ms.test.pd.reflect;

/**
 * <p>[TODO 简要描述该类功能]</p>
 *
 * @version v2.0
 * @since v2.0
 * @author 李春雨
 * @date 2018年7月5日 下午4:14:31
 * @Copyright 知识产权出版社
 */
public class Person {

	public String name;

	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void draw() {
		System.out.println("draw Person");
	}

	public void draw(String name, int age) {
		System.out.println("draw Person: " + name + ", age=" + age);
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}

}
