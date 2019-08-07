/**
 * 文件名：RabbitMQTest.java
 * 创建人：李春雨
 * 创建时间：2018年4月11日 上午9:44:09
 * 版权所有：知识产权出版社
 */
package com.cnipr.open.ms.test.pd.pdf;

import org.junit.Test;

import com.cnipr.open.ms.spi.pd.task.util.PdfUtils;

/**
 * <p>[测试生成服务器端的pdf文件url地址]</p>
 * 
 * 专利大数据系统（http://image.zldsj.com）的图片、PDF资源服务器所在的内网IP地址为：10.10.1.106，为了更快的下载PDF文件，我们修改了hosts配置,添加下面两句，请知晓:
 * # ipph pdf server address
 * 10.10.1.106 image.zldsj.com
 * 
 * @author 李春雨
 * @version 1.0 Created on 2018-4-12 上午9:44:09 
 */
public class PdfUrlTest {
	
	// https://open.cnipr.com/cnipr-api/rs/api/fulltext/ft1/ADA5196C487387860F46DE14A01B2C69?pid=CN206688316U
	// http://image.zldsj.com/P/PID/CNU0/2017/1201/00000000206688/11C11S31M2010FCA/CN206688316U.PDF
	
	/**
	 * 【测试从徐杰接口中获取PDF方法-HttpClient方式】
	 * 最终是从image.zldsj.com服务器获取pdf
	 */
	@Test
	public void testCase4HttpClient() {
		
		String pn = "CN108261639A";
		// PDF本地存放路径
		String pdfSavePath = "E:/PDF_PID/" + pn + "-HttpClient" + ".pdf";
		
		long start = System.currentTimeMillis();
		// 拼接PDF文件在服务器上的url路径（改走徐杰接口服务器获取）
		String pdfInterUrl = PdfUtils.generatePdfUrlByPid(pn);
		PdfUtils.copyPdfUrlToLocal2(pdfInterUrl, pdfSavePath);
		System.out.println("【HttpClient方式下载pdf】保存地址：" + pdfSavePath);
		long cost = (System.currentTimeMillis() - start) / 1000;
		System.out.println("下载耗时（秒）：" + cost);
	}
	
	/**
	 * 【测试从徐杰接口中获取PDF方法-HttpUrl方式】
	 * 最终是从image.zldsj.com服务器获取pdf
	 */
	@Test
	public void testCase4HttpURL() {
		
		String pn = "CN103974969B";
		// PDF本地存放路径
		String pdfSavePath = "E:/PDF_PID/" + pn + "-HttpUrl" + ".pdf";
		
		long start = System.currentTimeMillis();
		// 拼接PDF文件在服务器上的url路径（改走徐杰接口服务器获取）
		String pdfInterUrl = PdfUtils.generatePdfUrlByPid(pn);
		PdfUtils.copyPdfUrlToLocal(pdfInterUrl, pdfSavePath);
		System.out.println("【HttpURL方式下载pdf】保存地址：" + pdfSavePath);
		long cost = (System.currentTimeMillis() - start) / 1000;
		System.out.println("下载耗时（秒）：" + cost);
	}
	
}
