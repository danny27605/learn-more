/**
 * 文件名：ObjectTest.java
 * 创建人：李春雨
 * 创建时间：2018年8月7日 下午12:40:09
 * 版权所有：知识产权出版社
 */
package com.cnipr.open.ms.test.pd.reflect;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.cnipr.open.ms.spi.pd.base.comm.Constants;
import com.cnipr.open.ms.spi.pd.search.comm.ExportFields;
import com.cnipr.open.ms.spi.pd.search.dto.ApplicantInfoDto;
import com.cnipr.open.ms.spi.pd.search.dto.PatentDto;
import com.cnipr.open.ms.spi.pd.search.util.PatentUtils;
import com.cnipr.open.ms.spi.pd.search.util.TRSUtils;
import com.cnipr.open.ms.spi.pd.task.view.DisplayField;
import com.google.common.collect.Lists;

/**
 * <p>[TODO 简要描述该类功能]</p>
 *
 * @version v2.0
 * @since v2.0
 * @author 李春雨
 * @date 2018年8月7日 下午12:40:09
 * @Copyright 知识产权出版社
 */
public class ObjectTest {

	/**
	 * <p>【TODO 简要描述该方法作用】</p>
	 */
	public static void main(String[] args) {
		PatentDto patent = new PatentDto();
		patent.setAbs("李春雨");
		patent.setPubNumber(new String[] {"公开号1", "公开号2", "公开号3"});
		List<ApplicantInfoDto> applicantList = Lists.newArrayList();
		for (int i = 0; i < 3; i++) {
			ApplicantInfoDto applicantDto = new ApplicantInfoDto();
			applicantDto.setApplicantInfoCountry("CN" + i);
			applicantDto.setApplicantInfoName("李春雨" + i);
			applicantDto.setApplicantInfoType("工矿企业" + i);
			applicantList.add(applicantDto);
		}
		patent.setApplicantInfo(applicantList);
		System.out.println(patent.getClass().isPrimitive());
		System.out.println(patent.getClass().isSynthetic());
		
		String displayFields = "title,pubNumber,appNumber,pubDate,appDate,abs,patType,lprs,statusCode,grantDate,expireDate,applicantName,applicantType,applicantInfo,inventroName,patentee,nec,\r\n" + 
				"mainIpc,ipc,ipcSection,ipcClass,ipcSubClass,ipcGroup,ipcSubGroup,cpc,cpcSection,cpcClass,cpcSubClass,cpcGroup,cpcSubGroup,\r\n" + 
				"agencyName,agentName,priorityCountry,priorityNo,priority,citationIpc,citationNo,citationApplicant,citationCountry,citationInfo,citationOther,citationForwardIpc,citationForward,citationForwardApplicant,citationForwardCountry,citationForwardInfo,\r\n" + 
				"claimsPath,claimsType,instrPath,instrTif,independentClaims,cl,address,addrProvince,addrCity,addrCounty,appCoun,pubCountryCode,proCode,\r\n" + 
				"countryCode,countryName,provinceCode,provinceName,patentWords,titleKey,clKey,bgKey,claimsQuantity,independentClaimsQuantity,subClaimsQuantity,patentRightTransfer,applicationRightTransfer,exploitationNums,pledgeNums,preservationNums,citQuantity,patCitedQuantity,nplCitedQuantity,citationForwardNums,\r\n" + 
				"familyNums,reexamNums,invalidNums,initMainIpc,initIpc,eupMainIpc,eupIpc,refDoc,issueDate,divideInitAppNo,sameApp,censor,\r\n" + 
				"appResource,iapp,ipub,den,appDateYear,pubDateYear,\r\n" + 
				"draws,tifDistributePath,pages,gazettePath,gazettePage,gazetteCount,\r\n" + 
				"pdfAddr,invalidList,firstJudgmentList,\r\n" + 
				"legalList,transferList,exploitationList,preservationList,feeList,\r\n" + 
				"storePatentWords,storeTitleKey,storeClKey,storeBgKey,mainIpcSta,ipcSta,productFeatureVector,\r\n" + 
				"declassifiedPublicationDate,reexamList,secondJudgmentList,iappNo,iappDate,ipubNo,ipubDate,\r\n" + 
				"drawsPic,patDocId,ver,tableSn,dbName";
		ExportFields exportFields = new ExportFields(displayFields);
		exportFields.getTextFields().addAll(exportFields.getBibFields());
		exportFields.getTextFields().addAll(exportFields.getXmlFields());
		try {
			// 获取系统默认以及用户定义的返回字段
			Map<String, DisplayField> userDisplayFields = PatentUtils.getUserDisplayFields("client_id", "CN");
			
			TRSUtils.writeToTrsFile(new File("E://test.trs"), patent, exportFields, userDisplayFields, Constants.DEFAULT_ENCODING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(patent);
	}

}
