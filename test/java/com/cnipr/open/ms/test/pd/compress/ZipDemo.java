/**
 * 文件名：ZipDemo.java
 * 创建人：李春雨
 * 创建时间：2018年5月31日 下午9:23:54
 * 版权所有：知识产权出版社
 */
package com.cnipr.open.ms.test.pd.compress;

import com.cnipr.open.ms.spi.pd.task.util.Compressor;

/**
 * <p>[TODO 简要描述该类功能]</p>
 *
 * @version v2.0
 * @since v2.0
 * @author 李春雨
 * @date 2018年5月31日 下午9:23:54
 * @Copyright 知识产权出版社
 */
public class ZipDemo {
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		String sourceFolderPath = "E:\\ZipTest\\FM";
		String destZipFilePath = "E:\\ZipTest\\CreateSplitZipFileFromFolder1.zip";
//		String includes = "**\\*\\CLA_DES_DRA\\*.*";
		String includes = "**";	// 全部压缩
		Compressor.compress(sourceFolderPath, destZipFilePath, includes);
		System.out.println("要压缩的源文件夹路径： " +sourceFolderPath+ "，压缩后的文件路径： " + destZipFilePath);
		
		long cost = (System.currentTimeMillis() - start) / 1000;
		System.out.println("Ant 压缩文件夹完成~~ 耗时（秒）：" + cost);
		
//		String destDirPath = "E:/20140725_tmp";
//		Compressor.uncompress(destZipFilePath, destDirPath);
//		System.out.println("要解压的zip包路径： " +destZipFilePath+ "，解压后的文件路径： " + destDirPath);
	}
}
