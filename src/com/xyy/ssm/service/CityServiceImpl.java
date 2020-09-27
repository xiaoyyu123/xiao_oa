package com.xyy.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyy.ssm.dao.CityMapper;
import com.xyy.ssm.pojo.City;
import com.xyy.ssm.pojo.CityExample;
import com.xyy.ssm.pojo.CityExample.Criteria;

@Service("cityService")
public class CityServiceImpl implements CityService {

	@Autowired
	private CityMapper cityMapper;
	
	@Override
	public List<City> findCityByProId(Integer provinceId) {
		
		CityExample example = new CityExample();
		
		Criteria criteria = example.createCriteria();
		
		criteria.andProvinceidEqualTo(provinceId);
		
		List<City> cityList = cityMapper.selectByExample(example);
		
		System.out.println("cityList = "+cityList);
		
		return cityList;
	}

}
