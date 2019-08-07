/**
 * 文件名：TaskRepositoryTest.java
 * 创建人：李春雨
 * 创建时间：2018年4月10日 上午10:29:35
 * 版权所有：知识产权出版社
 */
package com.cnipr.open.ms.test.pd.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cnipr.open.ms.spi.pd.task.dao.TaskRepository;
import com.cnipr.open.ms.spi.pd.task.entity.PatentDownTask;

/**
 * <p>[TODO 简要描述该类功能]</p>
 *
 * @version v2.0
 * @since v2.0
 * @author 李春雨
 * @date 2018年4月10日 上午10:29:35
 * @Copyright 知识产权出版社
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootConfiguration()
public class TaskRepositoryTest {
	
	@Autowired
	private TaskRepository taskRepository;

	@Test
	public void testTaskRepository() throws Exception {
		PatentDownTask task = new PatentDownTask();
		task.setTaskName("测试任务");
		task.setSearchExp("表达式");
		taskRepository.save(task);
//		
//		Assert.assertEquals(1, taskRepository.findAll().size());
//		System.out.println(taskRepository.findAll().size());
//		
//		List<DownloadTask> tasks = taskRepository.findByTaskName("测试任务");
//		System.out.println("查询结果：" + tasks.size());
		
	}
	
}
