/**  
 * 文件名：ErrorLogInfo.java 
 * 创建人：李春雨
 * 创建时间：2016-4-7 上午10:38:37
 * 版权所有：知识产权出版社
 */
package com.cnipr.open.ms.test.pd.jar.filedown;

/**
 * <p>[错误日志信息]</p>
 *
 * @author 李春雨
 * @version 1.0 Created on 2016-4-7 上午10:38:37 
 */
public class ErrorLogInfo extends LogInfo {
	
	private String pubDate;		// 公开日
	
	private String pubNum;		// 公开号
	
	private String appDate;		// 申请日
	
	private String appNum;		// 申请号
	
	private String dataType;	// 数据类型
	
	private String srcPath;		// 源文件路径
	
	private String destPath;	// 目标文件路径
	
	private int errType;		// 错误类型：0、未定义；1、【数据丢失】；2、网络错误
	
	private boolean success;	// 重新下载是否成功

	public ErrorLogInfo(String pubDate, String pubNum, String appNum, String dataType, String srcPath, String destPath, int errType) {
		super();
		this.pubDate = pubDate;
		this.pubNum = pubNum;
//		this.appDate = appDate;
		this.appNum = appNum;
		this.dataType = dataType;
		this.srcPath = srcPath;
		this.destPath = destPath;
		this.errType = errType;
	}
	
	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public String getPubNum() {
		return pubNum;
	}

	public void setPubNum(String pubNum) {
		this.pubNum = pubNum;
	}

	public String getAppDate() {
		return appDate;
	}

	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}

	public String getAppNum() {
		return appNum;
	}

	public void setAppNum(String appNum) {
		this.appNum = appNum;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getSrcPath() {
		return srcPath;
	}

	public void setSrcPath(String srcPath) {
		this.srcPath = srcPath;
	}

	public String getDestPath() {
		return destPath;
	}

	public void setDestPath(String destPath) {
		this.destPath = destPath;
	}

	public int getErrType() {
		return errType;
	}

	public void setErrType(int errType) {
		this.errType = errType;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	@Override
	public String toString() {
		return "ErrorLogInfo [pubDate=" + pubDate + ", pubNum=" + pubNum + ", appDate=" + appDate + ", appNum=" + appNum + ", dataType=" + dataType + ", srcPath=" + srcPath + ", destPath=" + destPath + ", errType=" + errType + "]";
	}
	
}
