/**
 * 文件名：RabbitMQTest.java
 * 创建人：李春雨
 * 创建时间：2018年4月11日 上午9:44:09
 * 版权所有：知识产权出版社
 */
package com.cnipr.open.ms.test.pd.mq;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cnipr.open.ms.spi.pd.base.comm.Constants;
import com.cnipr.open.ms.spi.pd.message.service.MessageSender;

/**
 * <p>[TODO 简要描述该类功能]</p>
 *
 * @version v2.0
 * @since v2.0
 * @author 李春雨
 * @date 2018年4月11日 上午9:44:09
 * @Copyright 知识产权出版社
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQTest {
	
	@Autowired
	private MessageSender messageSender;

	@Test
	public void testSendMessage() throws Exception {
		System.out.println("测试RabbitMQ发送消息服务");
		String message = "今天是个好日子！";
		messageSender.send(Constants.DOWNLOAD_TASK_EXCHANGE, Constants.DOWNLOAD_TASK_QUEUE, message);
	}

	@Test
	public void testSendObjectMessage() throws Exception {
		System.out.println("测试RabbitMQ发送者服务");
		Map<String, String> map = new HashMap<String, String>();
		map.put("kevin", "李雷");
		map.put("lichunyu", "李春雨");
		messageSender.send(Constants.DOWNLOAD_TASK_EXCHANGE, Constants.DOWNLOAD_TASK_QUEUE, map);
	}
}
