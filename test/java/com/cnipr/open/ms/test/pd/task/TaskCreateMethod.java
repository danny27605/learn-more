/**
 * 文件名：TaskCreateMethod.java
 * 创建人：李春雨
 * 创建时间：2018年6月26日 下午3:12:27
 * 版权所有：知识产权出版社
 */
package com.cnipr.open.ms.test.pd.task;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.cnipr.open.ms.spi.pd.base.comm.HttpClientTool;

/**
 * <p>[测试创建任务接口]</p>
 *
 * @version v2.0
 * @since v2.0
 * @author 李春雨
 * @date 2018年6月26日 下午3:12:27
 * @Copyright 知识产权出版社
 */
public class TaskCreateMethod {

	public static void main(String[] args) {
		
		HttpClientTool client = new HttpClientTool();
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("clientId", "94904fb7de024de7a5cca6cbfbf51c1b"));
		params.add(new BasicNameValuePair("openId", "3073258A1BCD8EB74BC0C610DEDBF4EA"));
		params.add(new BasicNameValuePair("accessToken", "CD26C66F83937F77FEBFD479FEF43A97"));
		
		params.add(new BasicNameValuePair("taskName", "专利下载任务测试"));
		params.add(new BasicNameValuePair("taskDesc", "描述：专利下载任务测试"));
		params.add(new BasicNameValuePair("dbNames", "FMZL,SYXX,FMSQ"));
//		params.add(new BasicNameValuePair("searchExp", "名称=(涡轮发动机)"));
		params.add(new BasicNameValuePair("searchExp", "名称=(涡轮发动机) and 公开（公告）日 > 20180618"));
		
		params.add(new BasicNameValuePair("displayFields", "title,pubNumber,appNumber,pubDate,appDate,abs,patType,lprs,statusCode,grantDate,expireDate,applicantName,applicantType,applicantInfo,inventroName,patentee,nec,mainIpc,ipc,ipcSection,ipcClass,ipcSubClass,ipcGroup,ipcSubGroup,cpc,cpcSection,cpcClass,cpcSubClass,cpcGroup,cpcSubGroup,agencyName,agentName,priorityCountry,priorityNo,priority,citationIpc,citationNo,citationApplicant,citationCountry,citationInfo,citationOther,citationForwardIpc,citationForward,citationForwardApplicant,citationForwardCountry,citationForwardInfo,claimsPath,claimsType,instrPath,instrTif,independentClaims,cl,address,addrProvince,addrCity,addrCounty,appCoun,pubCountryCode,proCode,countryCode,countryName,provinceCode,provinceName,patentWords,titleKey,clKey,bgKey,claimsQuantity,independentClaimsQuantity,subClaimsQuantity,patentRightTransfer,applicationRightTransfer,exploitationNums,pledgeNums,preservationNums,citQuantity,patCitedQuantity,nplCitedQuantity,citationForwardNums,familyNums,reexamNums,invalidNums,initMainIpc,initIpc,eupMainIpc,eupIpc,refDoc,issueDate,divideInitAppNo,sameApp,censor,appResource,iapp,ipub,den,appDateYear,pubDateYear,draws,tifDistributePath,gazettePath,gazettePage,gazetteCount,pdfAddr,invalidList,firstJudgmentList,legalList,transferList,exploitationList,preservationList,feeList,storePatentWords,storeTitleKey,storeClKey,storeBgKey,mainIpcSta,ipcSta,productFeatureVector,declassifiedPublicationDate,reexamList,secondJudgmentList,iappNo,iappDate,ipubNo,ipubDate,drawsPic,patDocId,ver,tableSn,dbName"));
		params.add(new BasicNameValuePair("sortFields", "+appNumber"));
		params.add(new BasicNameValuePair("searchMode", "1"));	// 1,2
		params.add(new BasicNameValuePair("storageMode", "2"));	// 1,2
		params.add(new BasicNameValuePair("textFormat", "TRS"));// TRS,JSON
		params.add(new BasicNameValuePair("callbackUrl", "http://localhost:28002/test/callback"));// 接口回调函数
		params.add(new BasicNameValuePair("code", "Kevin"));	// 用户自定义字段

		// 调用下载任务创建接口
		String createTaskUrl = "http://pt.cnipr.com/cnipr-api-ms/rs/api/task/create";
//		String createTaskUrl = "http://localhost:28002/rs/api/task/create";
		String returnVal = client.httpPost(createTaskUrl, params, "UTF-8");
		System.out.println("调用下载任务返回结果：" + returnVal);
		
	}
	
}
