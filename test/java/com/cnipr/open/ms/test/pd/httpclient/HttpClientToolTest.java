/**
 * 文件名：HttpClientToolTest.java
 * 创建人：李春雨
 * 创建时间：2018年4月27日 上午11:02:02
 * 版权所有：知识产权出版社
 */
package com.cnipr.open.ms.test.pd.httpclient;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.cnipr.open.ms.spi.pd.base.comm.HttpClientTool;

/**
 * <p>[TODO 简要描述该类功能]</p>
 *
 * @version v2.0
 * @since v2.0
 * @author 李春雨
 * @date 2018年4月27日 上午11:02:02
 * @Copyright 知识产权出版社
 */
public class HttpClientToolTest {
	
	public static void main(String[] args) {
		HttpClientTool client = new HttpClientTool();
		
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("openid", "123456"));
		params.add(new BasicNameValuePair("access_token", "654321"));
		
		params.add(new BasicNameValuePair("dbs", "FMZL,SYXX,FMSQ,WGZL"));
		params.add(new BasicNameValuePair("exp", "公开（公告）日=20180420"));
//		params.add(new BasicNameValuePair("displayCols", "pid,sysid,appNumber,pubNumber,appDate,pubDate,title,dbName"));
		params.add(new BasicNameValuePair("returnValues", "pid,sysid,appNumber,pubNumber,appDate,pubDate,title,dbName"));
		params.add(new BasicNameValuePair("from", "0"));
//		params.add(new BasicNameValuePair("to", "5"));
		params.add(new BasicNameValuePair("size", "5"));
//		params.add(new BasicNameValuePair("order", "+申请日"));
//		params.add(new BasicNameValuePair("option", "1"));

		String clientId = "94904fb7de024de7a5cca6cbfbf51c1b";
		String openId = "OPENID";
		String accessToken = "ACCESS_TOKEN";
//		String sf1Url = "https://open.cnipr.com/cnipr-api/rs/api/search/sf1/" + clientId;
		String sf1Url = "http://open.cnipr.com/cnipr-api/patent-query-spi/patent/query/" + clientId;

		String result = client.httpPost(sf1Url, params, "UTF-8");
		System.out.println(result);
		
		
//		Object obj = JSON.parse(result);
//		System.out.println(obj);
//		JSONObject json = JSON.parseObject(result);
//		System.out.println(json.get("total"));
//		
//		JSONArray array = json.getJSONArray("results");
//		
//		for (Object o : array) {
//			System.out.println(o);
//		}

	}
	
}
