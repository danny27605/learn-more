/**
 * 文件名：DateTest.java
 * 创建人：李春雨
 * 创建时间：2018年7月12日 上午10:50:09
 * 版权所有：知识产权出版社
 */
package com.cnipr.open.ms.test.pd.task;

import java.util.Date;
import java.util.Locale;

import org.joda.time.DateTime;

import com.alibaba.fastjson.JSON;

/**
 * <p>[TODO 简要描述该类功能]</p>
 *
 * @version v2.0
 * @since v2.0
 * @author 李春雨
 * @date 2018年7月12日 上午10:50:09
 * @Copyright 知识产权出版社
 */
public class DateTest {
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		
		Date date = new Date();
		System.out.println(date);
		System.out.println(date.getTime());
		
		DateTime dateTime = new DateTime();
		System.out.println(dateTime.getZone() +"||"+ dateTime.getChronology());
		System.out.println(dateTime.getMillis());
		
		System.out.println(dateTime.toString("yyyy-MM-dd HH:mm:ss"));
		System.out.println("||" + dateTime.toString());
		
		Object jsonStr = JSON.toJSON(date);
		System.out.println(jsonStr);
		
	}
}
