/**
 * 文件名：ReflectDemo.java
 * 创建人：李春雨
 * 创建时间：2018年7月5日 下午1:59:00
 * 版权所有：知识产权出版社
 */
package com.cnipr.open.ms.test.pd.reflect;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

/**
 * <p>[Java Reflect反射测试类]</p>
 *
 * @version v2.0
 * @since v2.0
 * @author 李春雨
 * @date 2018年7月5日 下午1:59:00
 * @Copyright 知识产权出版社
 */
public class ReflectDemo {

	@Test
	public void testConstructors() {
		try {
			System.out.println("测试java.lang.reflect.Constructor类：");
			// 获取Class对象的引用
			Class<?> clazz = Class.forName("com.cnipr.open.ms.spi.pd.reflect.User");
			System.out.println("获取Class对象的引用：" + clazz);

			// 第一种方法，实例化默认构造方法，User类必须有无参构造函数，否则将抛异常
			User user = (User) clazz.newInstance();
			System.out.println(user);
			user.setAge(28);
			user.setName("Kevin");
			System.out.println(user);

			
			// 第二种方法，调用带String参数的public构造函数
			Constructor<?> cs1 = clazz.getConstructor(String.class);
			// 创建User对象
			User user1 = (User) cs1.newInstance("Rain");
			System.out.println(user1);
			
			
			// 第三种方法，调用带int和String参数的private构造函数
			Constructor<?> cs2 = clazz.getDeclaredConstructor(int.class, String.class);
			// 由于该构造函数是private的，比如设置为可访问
			cs2.setAccessible(true);
			User user2 = (User) cs2.newInstance(30, "李春雨");
			System.out.println(user2);
			
			
			// 获取所有构造函数，包括private私有构造方法
			Constructor<?>[] cons = clazz.getDeclaredConstructors();
			// 查看每个构造 函数需要的参数
			for (int i = 0; i < cons.length; i++) {
				// 获取构造函数参数类型
				Class<?>[] paramType  = cons[i].getParameterTypes();
				System.out.println("构造函数["+ i +"]:"+ cons[i].toString());
				System.out.print("参数类型["+ i +"]:(");
				for (int j = 0; j < paramType.length; j++) {
					if (j == paramType.length - 1) {
						System.out.print(paramType[j].getName());
					} else {
						System.out.print(paramType[j].getName() + ",");
//						System.out.print(paramType[j].getSimpleName() + ",");
					}
				}
				System.out.println(")");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testParameterTypes() {
		try {
			System.out.println("测试java.lang.reflect.Type类：");
			Class<?> clazz = Class.forName("com.cnipr.open.ms.spi.pd.reflect.User");
			Constructor<?> con = clazz.getDeclaredConstructor(int.class, String.class);
			// Constructor对象表示的构造方法的类
			Class<?> userClass = con.getDeclaringClass();
			System.out.println(con +"||"+ userClass);
		
			// Constructor方法所表示的方法的形参类型
			Type[] types = con.getGenericParameterTypes();
			for (Type type : types) {
				System.out.println("参数名称tp：" + type.getTypeName());
			}
			// 获取构造函数参数类型
			Class<?>[] pts = con.getParameterTypes();
			for (Class<?> pt : pts) {
				System.out.println("参数名称：" + pt.getName());
			}
			// 以字符串形式返回此构造方法的名称
			System.out.println("getName(): " + con.getName());
			// 描述此Constructor的字符串，包括参数类型和修饰符
			System.out.println("toGenericString(): " + con.toGenericString());
			
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testFields() {
		try {
			System.out.println("测试java.lang.reflect.Field类：");
			Class<?> clazz = Class.forName("com.cnipr.open.ms.spi.pd.reflect.Student");
			
			// 获取指定字段名称的Field类，注意字段修饰符必须为public并且该字段存在，否则抛出NoSuchFieldException
			Field field = clazz.getField("desc");
			Field field1 = clazz.getField("name");
//			Field field = clazz.getField("score");
			System.out.println("getField(name)，Field字段名称: " + field +"||"+ field1 +"||"+ field.getName());
			
			System.out.println("===============================================");
			
			// getFields()，获取所有修饰符为public的字段，包含父类字段，注意修饰符为public的字段才会获取
			Field[] fields = clazz.getFields();
			System.out.println("获取所有修饰符为public的字段，包括父类字段。");
			for (Field f : fields) {
				System.out.println(f);
			}
			
			System.out.println("===============================================");
			
			// getDeclaredFields()，获取当前类定义的所有字段（包含private字段），注意不包含父类字段
			Field[] fields2 = clazz.getDeclaredFields();
			System.out.println("获取当前类定义的所有字段（包括private字段），但不包括父类字段。");
			for (Field f2 : fields2) {
				System.out.println(f2);
			}
			
			System.out.println("===============================================");
			// 获取指定字段名称的Field类，可以是任意修饰符，但不包括父类的字段
			Field field2 = clazz.getDeclaredField("score");
			System.out.println("getDeclaredField(name)，Field字段名称： " + field2);
			
//			Field field2 = clazz.getDeclaredField("age");
			System.out.println("注意：无法获取父类中标识符为private的字段~~");
			
		} catch (ClassNotFoundException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testFields2() {
		try {
			System.out.println("测试通过反射类类构造实例对象：");
			Class<?> clazz = Class.forName("com.cnipr.open.ms.spi.pd.reflect.Student");
			Student stu = (Student) clazz.newInstance();
			Field nameField = clazz.getField("name");
			nameField.set(stu, "Kevin");
			// 父类的私有成员变量无法通过这种方式赋值
//			Field ageField = clazz.getField("age");
//			ageField.set(stu, 20);
			Field descField = clazz.getDeclaredField("desc");
			descField.set(stu, "学生类描述");
			Field scoreField = clazz.getDeclaredField("score");
			scoreField.setAccessible(true);
			scoreField.set(stu, 100);
			
			Field userField = clazz.getDeclaredField("user");
			System.out.println(userField.isSynthetic());
			System.out.println(userField.isAccessible());
			
			Class<?> cls = Class.forName("com.cnipr.open.ms.spi.pd.reflect.User");
			Constructor<?> con = cls.getDeclaredConstructor(int.class, String.class);
			con.setAccessible(true);
			User user = (User) con.newInstance(20, "李春雨");
			userField.setAccessible(true);
//			userField.set(stu, new User("李春雨"));
			userField.set(stu, user);
			
			System.out.println(stu);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchFieldException | SecurityException | NoSuchMethodException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMethods() {
		try {
			System.out.println("测试java.lang.reflect.Method类：");
			Class<?> clazz = Class.forName("com.cnipr.open.ms.spi.pd.reflect.Student");
			Object obj = clazz.newInstance();
//			Student obj = (Student) clazz.newInstance();
			
			// 根据参数获取public的Method，包含继承自父类的方法
			Method method = clazz.getMethod("drawStudent", String.class, int.class);
			System.out.println(method.getName() +"方法是否包含可变参数："+ method.isVarArgs());
			System.out.println(method.getName() + "方法的返回值类型：" + method.getReturnType().getSimpleName() +"||"+ method.getGenericReturnType());
			
			Class<?>[] paramClass = method.getParameterTypes();
			System.out.print(method.getName() + "方法的参数类型：(");
			for (Class<?> param : paramClass) {
				System.out.print(param + ",");
			}
			System.out.print(")");
			
			Object returnValue = method.invoke(obj, "绘画描述", 80);
			System.out.println("返回值：" + returnValue);
			
			System.out.println("===============================================");
			
			// 获取所有public的方法，包含父类，爷爷等所有类，如顶级类Object等
			Method[] methods = clazz.getMethods();
			for (Method m : methods) {
				System.out.println(m);
			}
			
			System.out.println("===============================================");
			// 获取当前类定义的所有方法（包含private方法），该方法无法获取继承自父类的方法
			Method[] methods2 = clazz.getDeclaredMethods();
			for (Method m2 : methods2) {
				System.out.println(m2);
			}
			
			System.out.println("===============================================");
			
			Method method2 = clazz.getDeclaredMethod("drawStudent");
			method2.setAccessible(true);// private 方法要先设成可访问
			method2.invoke(obj);
			
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testArrays() {
		System.out.println("测试java.lang.reflect.Array类：");
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		// 获取数组中元素类型Class对象
		Class<?> compomentType = arr.getClass().getComponentType();
		// new一个新数组
		Object newArr = Array.newInstance(compomentType, 15);
		System.out.println(ArrayUtils.toString(newArr));
		
		// 获取原来数组的长度
		int len = Array.getLength(arr);
		System.out.println(len);
		// 复制原数组元素到新数组
		System.arraycopy(arr, 0, newArr, 0, len);
		System.out.println(ArrayUtils.toString(newArr));
		for (int n : (int[]) newArr) {
			System.out.println(n);
		}
		
		System.out.println("===============================================");
		
		try {
			Class strClass = Class.forName("java.lang.String");
			Object array = Array.newInstance(strClass, 10);
			// 把字符串数组中索引位置为6的元素设置为“hello world”
//			Array.setInt(array, 5, 5);
			Array.set(array, 6, "hello world");
			// 获取array数组中索引位置为6的元素值
			Object str = Array.get(array, 6);
			System.out.println(str);
			System.out.println(array);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
}
