/**
 * 文件名：AppContextHolderTest.java
 * 创建人：李春雨
 * 创建时间：2018年5月4日 上午9:56:13
 * 版权所有：知识产权出版社
 */
package com.cnipr.open.ms.test.pd.common;

import java.util.List;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cnipr.open.ms.spi.pd.config.AppContextHolder;
import com.cnipr.open.ms.spi.pd.task.service.DisplayFieldService;
import com.cnipr.open.ms.spi.pd.task.view.DisplayField;

/**
 * <p>[TODO 简要描述该类功能]</p>
 *
 * @version v2.0
 * @since v2.0
 * @author 李春雨
 * @date 2018年5月4日 上午9:56:13
 * @Copyright 知识产权出版社
 */
@SpringBootTest
public class AppContextHolderTest {
	
	@Test
	public void ApplicationContextHolder() {
		DisplayFieldService displayFieldService = AppContextHolder.getBean("displayFieldService", DisplayFieldService.class);
		List<DisplayField> disFields = displayFieldService.getDefaultDisplayFields("CN");
		System.out.println("返回字段数: " + disFields.size());
	}
	
}
