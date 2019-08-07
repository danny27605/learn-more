package com.cnipr.open.ms.test.pd.pdf;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;


public class Test {

	public static void rewriteUrl(String url) {
		url="http://pt.cnipr.com/res/5c804b00ea0591d01b7d5ef0572012ac/40BEA4/279587/4274009270/1562725810/4800/rs4/PAT/35/18/CN2019107919654B_20190709/201711340457.GIF";
		String []arr1=url.split("/res/");
		String newUrl=arr1[0]+"/res/";
		String []arr=arr1[1].split("/");
		StringBuffer sbf2=new StringBuffer();
		sbf2.append(arr[1]).append("/")
		.append(arr[2]).append("/")
		.append(arr[3]).append("/")
		.append(System.currentTimeMillis() / 1000).append("/")
		.append(60*60*24*70).append("/")
		.append(arr[6]).append("/")
		.append(arr[7]).append("/")
		.append(arr[8]).append("/")
		.append(arr[9]).append("/")
		.append(arr[10]).append("/")
		.append(arr[11]);
		String absUrl2=sbf2.toString();

		newUrl=newUrl+DigestUtils.md5Hex(absUrl2+ MD5_SALT)+"/"+absUrl2;
		System.out.println("newUrl="+newUrl);
	}

	private static String MD5_SALT ="cnipr_#123@open";
	 public static void main(String args[]) {
//		 http://pt.cnipr.com/res/df90e65cee56c69756ca176231325139/F694B6/d2ac0b/**/1564620550/1200/rs4
//		 1927069414
//		 data/data39/PAT/73/77/CN2019305272976S_20190726/000004.JPG
		 System.out.println("data="+((1927069414%64)+1));



		 rewriteUrl("");
		 //ipph+公开日
		 String pid="CN2019109733039A_20190510";
		  pid="CN106041595B";
		 String clientId="abcdef";
		 String openId="abcdef";
		 String resource_name="HDA0001932078220000031.GIF";
		  resource_name="CN00000379437925.JPG";
			Long keyHash=Murmur3.hash_x86_32(pid.getBytes(), pid.getBytes().length, 983);
			Long firstPah=Murmur3.hash_x86_32(pid.getBytes(), pid.getBytes().length, 991)%256;
			Long secondPah=Murmur3.hash_x86_32(pid.getBytes(), pid.getBytes().length, 997)%128;
			//http://pt.cnipr.com/res/5c804b00ea0591d01b7d5ef0572012ac/40BEA4/279587/4274009270/1562725810/4800/rs4/PAT/35/18/CN2019107919654B_20190709/201711340457.GIF


			StringBuffer sbf2=new StringBuffer();
			sbf2.append(clientId.substring(0, 6)).append("/")
			.append(openId.substring(0, 6)).append("/")
			.append(keyHash).append("/")
			.append(System.currentTimeMillis() / 1000).append("/")
			.append(60*60*10).append("/")
			.append("rs1").append("/")
			.append("PAT").append("/")
			.append(firstPah).append("/")
			.append(secondPah).append("/")
			.append(pid).append("/")
			.append(resource_name);
			String absUrl2=sbf2.toString();
			System.out.println((keyHash%64)+1);
			System.out.println("absUrl="+absUrl2);
			String url2="http://pt.cnipr.com/res/"+DigestUtils.md5Hex(absUrl2+ MD5_SALT)+"/"+absUrl2;
			System.out.println("url2="+url2);
	 }

}
