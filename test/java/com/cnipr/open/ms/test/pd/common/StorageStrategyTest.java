/**
 * 文件名：StorageStrategyTest.java
 * 创建人：李春雨
 * 创建时间：2018年7月4日 下午2:52:02
 * 版权所有：知识产权出版社
 */
package com.cnipr.open.ms.test.pd.common;

import org.junit.Test;

import com.cnipr.open.ms.spi.pd.search.comm.StorageStrategyEnum;
import com.cnipr.open.ms.spi.pd.search.service.StorageStrategy;

/**
 * <p>[文献存储策略测试类]</p>
 *
 * @version v2.0
 * @since v2.0
 * @author 李春雨
 * @date 2018年7月4日 下午2:52:02
 * @Copyright 知识产权出版社
 */
public class StorageStrategyTest {

	@Test
	public void test() {
		System.out.println(StorageStrategyEnum.STRATEGY_1.getStoreMode());
		StorageStrategy strategy = StorageStrategyEnum.STRATEGY_1.getStrategy();
		System.out.println(strategy);
		
		int storeMode = 2;
		StorageStrategy storageStrategy = StorageStrategyEnum.getStrategy(storeMode);
		System.out.println(storageStrategy);
//		storageStrategy.saveRecord("", new ExportFields("dbName"), new PatentDto(), "TRS");
	}
	
}
