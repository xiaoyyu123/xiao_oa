package com.xyy.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xyy.ssm.pojo.City;
import com.xyy.ssm.service.CityService;

@Controller
@RequestMapping("/city")
public class CityController {
	
	//注入service 层的这个类
	@Autowired
	private CityService cityService;
	
	@ResponseBody
	@RequestMapping("/findCityByProvId")
	public List<City> findCityByProvId(Integer provinceId){
		
		List<City> cityList =  cityService.findCityByProId(provinceId);
		
		System.out.println(" controller : cityList ="+cityList);
		
		return cityList;
	}

}
