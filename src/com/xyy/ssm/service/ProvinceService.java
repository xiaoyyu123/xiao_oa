package com.xyy.ssm.service;

import java.util.List;

import com.xyy.ssm.pojo.Province;

public interface ProvinceService {

	/**
	 * 查询所有省份信息的方法
	 * @return
	 */
	List<Province> findProvinceAllInfo();

}
