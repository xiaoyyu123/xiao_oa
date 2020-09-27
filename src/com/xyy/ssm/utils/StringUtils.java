package com.xyy.ssm.utils;

import java.util.UUID;

/**
 * 定义一个获取文件名的string的工具类
 * @author xiao
 * 
 *
 */
public class StringUtils {
	
    /**
     * 获取文件名的后缀
     * @param name
     * @return
     */
	public static String subStringName(String name){
		
		String replace = UUID.randomUUID().toString().replace("-", "");
		
		String uuidStr = replace.substring(replace.length()-18, replace.length()) ;
		
		String subStr = name.substring(name.lastIndexOf("."),name.length());
		
		return uuidStr+subStr;
	}
	
	public static String getId(){
	    
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	 
	}
}
