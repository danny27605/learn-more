/**
 * 文件名：ResourceUtilsTest.java
 * 创建人：李春雨
 * 创建时间：2018年4月9日 上午11:41:58
 * 版权所有：知识产权出版社
 */
package com.cnipr.open.ms.test.pd.common;

import java.util.ResourceBundle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.cnipr.open.ms.spi.pd.base.comm.Constants;
import com.cnipr.open.ms.spi.pd.base.comm.ErrorInfoResource;
import com.cnipr.open.ms.spi.pd.base.util.ResourceUtils;

/**
 * <p>[ResourceUtils测试类]</p>
 *
 * @version v2.0
 * @since v2.0
 * @author 李春雨
 * @date 2018年4月9日 上午11:41:58
 * @Copyright 知识产权出版社
 */
@RunWith(SpringRunner.class)
public class ResourceUtilsTest {
	
	ResourceUtils resourceUtils = ResourceUtils.getInstance();
	
	@Test
	public void testResourceUtils() {
		System.out.println("测试资源文件操作类：" + ResourceUtils.class);
		
		ResourceUtils resourceUtils = ResourceUtils.getInstance();
		String pdf_inter_api = resourceUtils.getMessage(Constants.DEFAULT_SYSTEMCONFIG_FILE, "pdf_interface_url");
		
		ResourceBundle resourceBundle = ResourceBundle.getBundle(Constants.DEFAULT_SYSTEMCONFIG_FILE);
		String client_id = resourceUtils.getMessage(resourceBundle, "interface_client_id");
		
		String pdf_interface_url = pdf_inter_api + client_id;
		System.out.println("PDF_INTERFACE_URL = " + pdf_interface_url);
		System.out.println("PDF_INTERFACE_URL = " + Constants.PDF_INTERFACE_URL);
		
	}
	
	@Test
	public void testErrorInfoResource() {
		System.out.println("测试错误信息提示资源类：" + ErrorInfoResource.class);
		
		String error_code = "1051311"; 
		String error_msg = ErrorInfoResource.getErrorMessage(error_code);
		
		ResourceBundle errorResource = ResourceBundle.getBundle(Constants.DEFAULT_ERRORCODE_NAME);
		String error_msg1 = resourceUtils.getMessage(errorResource, error_code);
		
		System.out.println("error_code=" + error_code +", error_msg="+ error_msg +"||"+ error_msg1);
	}
}
