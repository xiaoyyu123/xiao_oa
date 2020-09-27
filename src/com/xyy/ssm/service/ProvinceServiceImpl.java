package com.xyy.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyy.ssm.dao.ProvinceMapper;
import com.xyy.ssm.pojo.Province;
import com.xyy.ssm.pojo.ProvinceExample;

@Service(value="provinceService")
public class ProvinceServiceImpl implements ProvinceService {

	//ע��־ò�Dao������� provincemapper
	@Autowired
	private ProvinceMapper proivnceMapper;
	
	/**
	 * ��ѯ����ʡ����Ϣ�ķ���
	 */
	@Override
	public List<Province> findProvinceAllInfo() {
		
		ProvinceExample example = new ProvinceExample();
		
		List<Province> provinceList  = proivnceMapper.selectByExample(example);
		
		System.out.println("service :provinceList"+provinceList);
		
		return provinceList;
	}

}
