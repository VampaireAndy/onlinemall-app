package com.example.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import android.util.Log;

public class Util {

	public static String URL="http://192.168.2.25:8080/OnlineMall";
	public static String userlogin="/LoginAppServlet";  //servlet
	public static String mymsg="/MyMsgServlet";
	public static String allmsg="/MyAllMsgServlet";
	public static String findGoods="/FindGoodsServlet";
	public static String findGoodsType = "/FindGoodsTypeServlet";
	
	//分别获取个人信息还是全部信息的区分标识符 
	//和后台的一一对应
	public static String WelcomeMymsg="MyMsg";
	public static String WelcomeAllmsg="AllMsg";
	
	/**
	 * 简单名称值对节点的封装如:name=clh&pwd=clh
	 * @param map
	 * @return
	 */
	public static String getPair(Map<String, String> map){
		List<NameValuePair> androidParams=new ArrayList<NameValuePair>();
		for(String key:map.keySet()){
			androidParams.add(new BasicNameValuePair(key,map.get(key).toString()));
		}
		String data=URLEncodedUtils.format(androidParams, "UTF-8");
		
		return data;		
	}
	
}
