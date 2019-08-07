/**
 * 文件名：ClassDemo.java
 * 创建人：李春雨
 * 创建时间：2018年7月5日 上午10:12:24
 * 版权所有：知识产权出版社
 */
package com.cnipr.open.ms.test.pd.reflect;

/**
 * <p>[TODO 简要描述该类功能]</p>
 *
 * @version v2.0
 * @since v2.0
 * @author 李春雨
 * @date 2018年7月5日 上午10:12:24
 * @Copyright 知识产权出版社
 */
public class ClassDemo {

	public static void main(String[] args) {
		// 没有泛型的Class对象
		Class intClass = int.class;
		// 没有泛型约束，可以随意赋值
		intClass = double.class;

		// 带泛型的Class对象
		Class<Integer> integerClass = Integer.class;
		// 有泛型约束，编译器提示错误
//		integerClass = double.class;
		
		// 编译不通过，虽然Integer是Number的子类，但是它们的Class对象不同，类型检查严格按照类对象定义
//		Class<Number> numberClass = Integer.class;
		
		Class<?> numberClass = Integer.class;
		numberClass = int.class;
		
		// 这种编译就可以通过了，既利用泛型做了编译期检查，又对接收的Class对象做了类型限定
		Class<? extends Number> clazz = Integer.class;
		clazz = Double.class;
		System.out.println(intClass +"||"+ integerClass +"||"+ numberClass +"||"+ clazz);
		
		
		Number number = new Integer(2);
		// Java SE 5之后新增的强制类型转换方式
		Integer integer = Integer.class.cast(number);
		System.out.println(number +"||"+ integer);
//		System.out.println(Double.class.cast(number));
		System.out.println(number instanceof Integer);
		System.out.println(Integer.class.isInstance(number));
		
	}
	
}
