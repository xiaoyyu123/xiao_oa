package com.xyy.ssm.service;

import java.util.List;

import com.xyy.ssm.pojo.City;

public interface CityService {

	/**
	 * ����provinceʡ�ݱ�ID��ѯ��Ӧ�����г���
	 * @param provinceId
	 * @return
	 */
	List<City> findCityByProId(Integer provinceId);

}
