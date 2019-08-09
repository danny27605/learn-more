package com.cnipr.open.ms.test.pd.bug;

import com.google.common.collect.Lists;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

import java.io.File;
import java.util.ArrayList;

/**
 * zip4j测试使用
 *
 * @author Bi Yunfei
 * @date 2019/7/26 13:40
 */
public class Zip4jTest {

	public static void main(String[] args) throws ZipException {
		//zip();
		//upZip();
		//addFileToZip();
		//zipFile();
		//deleteFile();
	}

	/**
	 * 设置压缩包密码
	 *
	 * @throws ZipException
	 */
	private static void zipFile() throws ZipException {
		// 生成的压缩文件
		ZipFile zipFile = new ZipFile("D:\\test.zip");
		ZipParameters parameters = new ZipParameters();
		// 压缩方式
		parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
		// 压缩级别
		parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
		parameters.setEncryptFiles(true);
		parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);
		parameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
		parameters.setPassword("111");
		// 要打包的文件夹
		File currentFile = new File("D:\\test");
		File[] fs = currentFile.listFiles();
		// 遍历test文件夹下所有的文件、文件夹
		for (File f : fs) {
			if (f.isDirectory()) {
				zipFile.addFolder(f.getPath(), parameters);
			} else {
				zipFile.addFile(f, parameters);
			}
		}
	}

	/**
	 * 删除压缩文件中文件
	 */
	public static void deleteFile() {
		try {
			ZipFile zipFile = new ZipFile("D:\\test.zip");
			zipFile.removeFile("ks/add");
		} catch (ZipException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 添加文件到压缩包中
	 */
	public static void addFileToZip() {
		try {
			ZipFile zipFile = new ZipFile("D:\\hello.zip");
			ZipParameters parameters = new ZipParameters();
			parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
			parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
			ArrayList<File> addFiles = Lists.newArrayList();
			addFiles.add(new File("D:\\Hello.txt"));
			addFiles.add(new File("D:\\Hello1.txt"));
			parameters.setRootFolderInZip("ks/");
			zipFile.addFiles(addFiles, parameters);

		} catch (ZipException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 解压
	 */
	public static void upZip() {
		try {
			System.err.println("开始解压");
			ZipFile zipFile = new ZipFile("D:\\hello.zip");
			zipFile.extractAll("D:\\hello");
			System.err.println("解压完成");
		} catch (ZipException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 压缩
	 *
	 * @throws ZipException
	 */
	public static void zip() throws ZipException {
		//生成的压缩文件
		ZipFile zipFile = new ZipFile("D:\\hello.zip");
		ZipParameters parameters = new ZipParameters();
		//压缩方式
		parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
		//压缩级别
		parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
		//要打包的文件夹
		File file = new File("D:\\log");
		File[] fs = file.listFiles();
		//遍历文件夹下所有文件、文件夹
		for (File file1 : fs) {
			if (file1.isDirectory()) {
				zipFile.addFolder(file1.getPath(), parameters);
			} else {
				zipFile.addFile(file1, parameters);
			}
		}
	}
}
