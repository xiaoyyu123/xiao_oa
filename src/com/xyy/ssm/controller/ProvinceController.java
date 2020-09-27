package com.xyy.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xyy.ssm.pojo.Province;
import com.xyy.ssm.service.ProvinceService;

@Controller
@RequestMapping("/province")
public class ProvinceController {

	//注入service 层的这个类
	@Autowired
	private ProvinceService provinceService;
	
	@ResponseBody
	@RequestMapping("/findProvinceAllInfo")
	public List<Province> findProvinceAllInfo(){
		
		List<Province> provinceList = provinceService.findProvinceAllInfo();
		
		System.out.println("controller : provinceList"+provinceList);
	
		return provinceList;
	}
}
