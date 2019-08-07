/**  
 * 文件名：LogInfo.java 
 * 创建人：李春雨
 * 创建时间：2016-4-7 上午10:32:30
 * 版权所有：知识产权出版社
 */
package com.cnipr.open.ms.test.pd.jar.filedown;

/**
 * <p>[日志信息基类]</p>
 *
 * @author 李春雨
 * @version 1.0 Created on 2016-4-7 上午10:32:30 
 */
public class LogInfo {
	
	private String logId;		// 日志记录Id
	
	private String logDate;		// 日志发生日期
	
	private String logLevel;	// 日志级别
	
	private String threadName;	// 线程名
	
	private String className;	// 类名称
	
	private String logInfo;		// 日志正文
	
	private String descript;	// 描述

	public LogInfo() {
		super();
	}

	public LogInfo(String logId, String logDate, String logLevel, String threadName, String className, String logInfo, String descript) {
		this.logId = logId;
		this.logDate = logDate;
		this.logLevel = logLevel;
		this.threadName = threadName;
		this.className = className;
		this.logInfo = logInfo;
		this.descript = descript;
	}

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public String getLogDate() {
		return logDate;
	}

	public void setLogDate(String logDate) {
		this.logDate = logDate;
	}

	public String getLogLevel() {
		return logLevel;
	}

	public void setLogLevel(String logLevel) {
		this.logLevel = logLevel;
	}

	public String getThreadName() {
		return threadName;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getLogInfo() {
		return logInfo;
	}

	public void setLogInfo(String logInfo) {
		this.logInfo = logInfo;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}
	
}
