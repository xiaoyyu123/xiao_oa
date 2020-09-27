package com.xyy.ssm.utils;

import java.util.UUID;

/**
 * ����һ����ȡ�ļ�����string�Ĺ�����
 * @author xiao
 * 
 *
 */
public class StringUtils {
	
    /**
     * ��ȡ�ļ����ĺ�׺
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
