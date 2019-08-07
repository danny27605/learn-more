package com.cnipr.open.ms.test.pd.pdf;

import org.apache.commons.codec.digest.DigestUtils;

public class Test2 {
	
	private static String MD5_SALT ="cnipr_#123@open";
	public static String rewriteUrl(String url) {
		
		String []arr1=url.split("/res/");
		String newUrl=arr1[0]+"/res/";
		String []arr=arr1[1].split("/");
		StringBuffer sbf2=new StringBuffer();
		long num = Long.parseLong(arr[3]);
		long a = num%64;
		String string = String.valueOf(((num%64)+1));
		sbf2.append("/data/data").append(string).append("/")
				.append(arr[7]).append("/")
				.append(arr[8]).append("/")
				.append(arr[9]).append("/")
				.append(arr[10]).append("/")
				.append(arr[11]);




//		sbf2.append(arr[1]).append("/")
//		.append(arr[2]).append("/")
//		.append(arr[3]).append("/")
//		.append(System.currentTimeMillis() / 1000).append("/")
//		.append(60*60*24*70).append("/")
//		.append(arr[6]).append("/")
//		.append(arr[7]).append("/")
//		.append(arr[8]).append("/")
//		.append(arr[9]).append("/")
//		.append(arr[10]).append("/")
//		.append(arr[11]);
		String absUrl2=sbf2.toString();


		return absUrl2;
	}


	 public static void main(String args[]) {
		 String url="asdfaf = http://pt.cnipr.com/res/5c804b00ea0591d01b7d5ef0572012ac/40BEA4/279587/4274009270/1562725810/4800/rs4/PAT/35/18/CN2019107919654B_20190709" +
				 "/201711340457.GIF";
		 System.out.println("newUrl="+rewriteUrl(url));
		 System.out.println(4274009270L%64+1);
	 }

}
