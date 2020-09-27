package com.xyy.ssm.service;

import java.util.List;

import com.xyy.ssm.pojo.City;

public interface CityService {

	/**
	 * 根据province省份表ID查询对应的所有城市
	 * @param provinceId
	 * @return
	 */
	List<City> findCityByProId(Integer provinceId);

}
