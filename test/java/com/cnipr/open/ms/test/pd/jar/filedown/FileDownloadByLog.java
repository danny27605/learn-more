/**  
 * 文件名：FileDownloadByLog.java 
 * 创建人：李春雨
 * 创建时间：2016-4-7 上午9:28:51
 * 版权所有：知识产权出版社
 */
package com.cnipr.open.ms.test.pd.jar.filedown;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>[通过读取日志下载丢失文件]</p>
 *
 * @author 李春雨
 * @version 1.0 Created on 2016-4-7 上午9:28:51 
 */
public class FileDownloadByLog {
	
	private static final Logger logger = LoggerFactory.getLogger(FileDownloadByLog.class);
	
	private static final String DATA_MISS = "【数据丢失】";		// 数据丢失--标志位

	private static final String EXIT_STR = "exit";			// 退出字符串
	
	
	public static void main(String[] args) {
		logger.info("【手动下载丢失文献】开始执行程序！");
		System.out.println("程序运行开始，读取日志路径信息。。。");
		// (1)从配置参数中读取日志路径
		String logFilePath = getLogPathFromArgs(args);
		if (StringUtils.isEmpty(logFilePath)) {
			System.out.println("提示：运行参数中无路径信息，请在控制台输入错误日志路径；如要退出程序，请输入“exit”。");
		}
		File logFile = new File(logFilePath);
		// (2)如果没有，则一直提示用户输入；如果用户输入“exit”，程序退出
		while (logFile == null || !logFile.exists()) {
			// 提示用户输入正确的错误日志路径
			String inputStr = readUserInput("提示：请输入正确的错误日志文件路径：");
			if (EXIT_STR.equals(inputStr)) {
				System.out.println("程序即将退出，谢谢使用！");
				System.exit(0);
			}
			logFile = new File(inputStr);
		}
		logger.info("【手动下载丢失文献】开始下载丢失文件！");
		// (3)开始下载丢失文件（根据日志文件内容）
		boolean success = downloadFileByHand(logFile);
		logger.info("【手动下载丢失文献】结束下载！程序运行结果 = {}", success);
		System.out.println("【手动下载丢失文献】结束下载！程序运行结果 = " + success);
	}
	
	/**
	 * 【从命令行参数中获取日志文件路径】
	 * @param args
	 * @return
	 */
	public static String getLogPathFromArgs(String[] args) {
		String logPath = "";
		if (args.length > 0) {
			logPath = args[0];
		}
		logger.info("从命令行读取日志路径信息：{}", logPath);
		return logPath;
	}
	
	/**
	 * 【从命令行用户输入中获取日志文件路径】
	 * @param prompt 提示用户输入日志路径的话语
	 * @return
	 */
	public static String readUserInput(String prompt) {
//		// jdk 1.4及以前版本写法（只能这么写）
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		try {
//			String str_4 = br.readLine();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		// jdk 1.6 写法
//		Console console = System.console();
//		String str_6 = console.readLine();
		// jdk 1.5 写法
		String input = "";
		System.out.println(prompt);
		Scanner scanner = new Scanner(System.in);
		if (scanner.hasNext()) {
			input = scanner.nextLine();
		}
		scanner.close();
		return input;
	}
	
	/**
	 * 【读取日志信息，手动下载丢失文件 - 入口类】
	 * @param logFile 要读取的日志文件
	 * @return 是否全部下载成功
	 */
	public static boolean downloadFileByHand(File logFile) {
		if (!logFile.exists()) {
			logger.error("【出错了！】-日志文件不存在！ logFile={}", logFile.toString());
			return false;
		}
		long total = 0L;	// 记录丢失数据总行数
		long count = 0L;	// 记录成功下载的行数
		try {
//			BufferedReader br = new BufferedReader(new FileReader(logFile));
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(logFile), "utf-8"));
			String log_line = null;
			boolean success = false;
			while ((log_line = br.readLine()) != null) {
				// 解析日志行成日志对象
				ErrorLogInfo logInfo = parseLogLineInfo(log_line);
				if (logInfo != null && logInfo.getErrType() == 1) {	// 错误类型为1，代表数据丢失错误
					total ++;
					logger.warn("srcPath={},destPath={}", logInfo.getSrcPath(), logInfo.getDestPath());
					if ("PDF".equals(logInfo.getDataType())) {	// PDF文件单独处理
						success = downloadPdfFile(logInfo.getSrcPath(), logInfo.getDestPath());
					} else {
						success = downloadFile(logInfo.getSrcPath(), logInfo.getDestPath());
					}
					if (success) {
						count ++;
					}
				}
			}
		} catch (IOException e) {
			logger.error("【手动下载丢失文件--》出错了！】文件地址：{}，错误信息：{}", logFile.getAbsoluteFile(), e.getMessage());
			e.printStackTrace();
		}
		long differ = total - count;
		logger.info("【手动下载丢失文献完毕】 丢失记录总数={}，成功下载={}，有※ {} ※行记录未成功下载！请查看日志并分析下原因。", new Object[]{total, count, (total-count)});
		return differ == 0 ? true : false;
	}
	
	/**
	 * 【解析日志行，并提取出有用信息】
	 * 【数据丢失】公开（公告）日=20160406，公开（公告）号=CN205142750U，申请号=CN201490000386.X，数据类型=PDF，源文件路径=http://pic.cnipr.com/pdfcn/Utility_model/2016/20160406/CN205142750U/PDF_PID/CN212014000000386CN00002051427500UPDFZH20160406CN00Q.PDF，目标文件路径=/home/webapp/week_update/temp/20160406/XX/CN205142750U/PDF_PID/CN201490000386.X.pdf，描述=全文图像pdf
	 * @param log_line
	 * @return
	 */
	public static ErrorLogInfo parseLogLineInfo(String log_line) {
		ErrorLogInfo logInfo = null;
		if (!"".equals(log_line) && log_line.contains(DATA_MISS)) {
			log_line = log_line.substring(log_line.indexOf(DATA_MISS) + 6);
			String[] arr = log_line.split("，");
			String pubDate = arr[0].split("=")[1];
			String pubNum = arr[1].split("=")[1];
			String appNum = arr[2].split("=")[1];
			String dataType = arr[3].split("=")[1];
//			String srcPath = arr[4].split("=")[1];
			String srcPath = arr[4].substring(arr[4].indexOf("=") + 1);
			String destPath = arr[5].split("=")[1];
			logInfo = new ErrorLogInfo(pubDate, pubNum, appNum, dataType, srcPath, destPath, 1);	// 1代表数据丢失错误
		}
		return logInfo;
	}
	
	/**
	 * 【手动下载文件】
	 * @param srcUrlStr 要下载文件的url字符串
	 * @param destPath 目标存储路径，若文件夹不存在则新建
	 * @return 下载是否成功
	 */
	public static boolean downloadFile(String srcUrlStr, String destPath) {
		try {
			return downloadFile(new URL(srcUrlStr), new File(destPath));
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 【手动下载文件】
	 * @param srcUrl 要下载文件的url地址
	 * @param destFile 目标存储路径，若文件夹不存在则新建
	 * @return 下载是否成功
	 */
	public static boolean downloadFile(URL srcUrl, File destFile) {
		try {
			if (isURLExist(srcUrl)) {	// 判断Url文件在服务器上是否存在
				if (!destFile.getParentFile().exists()) {
					destFile.getParentFile().mkdirs();
				}
			} 
			logger.info(srcUrl.toString());
			FileUtils.copyURLToFile(srcUrl, destFile);
		} catch (IOException e) {
			logger.error("【手动下载文件失败】srcUrl={}, destFile={}", srcUrl.toString(), destFile.getAbsolutePath());
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * 【判断服务器上的Url路径是否存在】
	 * @param srcUrl 完整Url路径 
	 * @return
	 */
	public static Boolean isURLExist(URL srcUrl) {
		InputStream is = null;
		try {
			is = srcUrl.openStream();
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			IOUtils.closeQuietly(is);
		}
	}
	
	/**
	 * 【从徐杰接口中拷贝pdf文件到本地】
	 * @param pdfFullUrl pdf文件在服务器上的完整url
	 * @param pdfSavePath pdf文件的本地保存位置
	 * 
	 * @return 拷贝是否成功
	 */
	public static boolean downloadPdfFile(String pdfInterUrl, String pdfSavePath) {
		boolean success = false;
		try {
			URL pdfUrl = new URL(pdfInterUrl);
			HttpURLConnection conn = (HttpURLConnection) pdfUrl.openConnection();
//			int statusCode = conn.getResponseCode();
			// 根据HTTP协议，Response Header中的Location字段，存放重定向地址，需要从Location中获得真正的pdf访问路径
			String truePdfUrl = conn.getHeaderField("Location");
			if (StringUtils.isNotBlank(truePdfUrl) && isURLExist(new URL(truePdfUrl))) {
				logger.info("pdfInterUrl={}, truePdfUrl={}", pdfInterUrl, truePdfUrl);
				// 设置连接超时和Socket超时时间：3分钟
				HttpURLConnection urlConn = (HttpURLConnection) new URL(truePdfUrl).openConnection();
				urlConn.setConnectTimeout(180000);
				urlConn.setReadTimeout(180000);
				
				copyInputStreamToFile(urlConn.getInputStream(), new File(pdfSavePath));
				success = true;
//				logger.debug("【从接口拷贝PDF文件成功】pdfInterUrl={},truePdfUrl={},pdfSavePath={}", new Object[] { pdfInterUrl, truePdfUrl, pdfSavePath });
			} else {
				logger.debug("【接口中的PDF文件不存在】pdfInterUrl={},truePdfUrl={},pdfSavePath={}", new Object[] { pdfInterUrl, truePdfUrl, pdfSavePath });
			}
		} catch (IOException e) {
			logger.error("【从接口拷贝PDF文件失败】errMsg={}:{},pdfInterUrl={},pdfSavePath={}", new Object[] { e.getClass().getName(), e.getMessage(), pdfInterUrl, pdfSavePath });
			e.printStackTrace();
		} 
		return success;
	}
	
    /**
     * <p>【将InputStream输入流复制到目标文件中】</p>
     * 如果它们不存在，则将创建到目的地的目录。如果目标已经存在，将被覆盖。源流被关闭。
     * @param source 源InputStream输入流
     * @param destination 目标文件
     * @throws IOException
     * @since v2.0
     */
    public static void copyInputStreamToFile(InputStream source, File destination) throws IOException {
    	FileUtils.copyInputStreamToFile(source, destination);
    }
    
}
