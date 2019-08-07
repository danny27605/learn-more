/**
 * 文件名：BugTest.java
 * 创建人：李春雨
 * 创建时间：2019年3月27日 上午10:51:39
 * 版权所有：知识产权出版社
 */
package com.cnipr.open.ms.test.pd.bug;

import com.cnipr.open.ms.spi.pd.task.util.FileDownUtils;

/**
 * <p>[程序Bug测试]</p>
 *
 * @version v2.0
 * @since v2.0
 * @author 李春雨
 * @date 2019年3月27日 上午10:51:39
 * @Copyright 知识产权出版社
 */
public class BugTest {
	
	public static void main(String[] args) {

		String srcUrlPath = "https://open.cnipr.com/cnipr-api/rs/api/fulltext/ft1/ADA5196C487387860F46DE14A01B2C69?pid=JP2018086648(A)";
		String destFilePath = "e:/home/webapp/dl/dl1/temp/2019/20190310/ff8080816964f86d01696563c4f00008/PDF/2018/20181228/JP2018086648(A).pdf";
		FileDownUtils.copyURLToFile(srcUrlPath, destFilePath);
		System.out.println(destFilePath);
	}
}
