package com.xyy.ssm.convertor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * �Զ����ַ���ת���ڵ���
 * 
 * Source  Դ    String����
 * Target  Ŀ��  date  ����
 * @author @author xiao
 *
 */

public class CustomGlobleStrToDateConvertor  implements Converter<String, Date>{

	@Override
	public Date convert(String source) {
		try {
			//ע�⵱ǰ��pattern�ĸ�ʽӦ�ú�ǰ����ʾ�ĸ�ʽһ��
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			return sdf.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
