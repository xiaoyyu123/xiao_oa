package com.xyy.ssm.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xyy.ssm.pojo.Customer;
import com.xyy.ssm.service.CustomerService;
import com.xyy.ssm.utils.PageBean;
import com.xyy.ssm.utils.StringUtils;


@Controller
@RequestMapping("/cust/api/v_1.0")
public class CustomerController {
	
	@Autowired
	private CustomerService customerSerivce;
	
	@ResponseBody
	@RequestMapping("/findCustomerByPage")
	public PageBean<Customer> findCustomerByPage(Integer indexpage,String custSource,String custName,String custLevel){
		
		System.out.println("indexpage" + indexpage + ",custSource:" + custSource + ",custName:" + custName + ",custLevel:"
				+ custLevel);
		PageBean<Customer> customerPageBean = customerSerivce.findCustomerByPage(indexpage,custSource,custName,custLevel);
		
		System.out.println("customerPageBean == "+customerPageBean);
		
		return customerPageBean;
		
	}
	
	@RequestMapping(value="/deleteCustomerById/{id}")
	public String deleteCustomerById(@PathVariable("id") Long custId){
		
		System.out.println("custId==="+custId);
		
		int rows = customerSerivce.deleteCustomerById(custId);
		
		System.out.println("rows == "+rows);
		
		return "redirect:/showCustomer.jsp";
	}
	
	
	@RequestMapping("/addCustomerInfo")
	public String addCustomerInfo(String provinceName,String city,String address,MultipartFile picFile,Customer customer){
		
		System.out.println("pronvinceName ="+provinceName);
		System.out.println("city ="+city);
		System.out.println("address ="+address);
		//ƴ��ʡ�к������ֵ
		String custAddress = provinceName+"-"+city+"-"+address;
		
		customer.setCustAddress(custAddress);
		//��ȡ�ļ���
		String  fileName = picFile.getOriginalFilename();
				
		if (org.apache.commons.lang.StringUtils.isNotBlank(fileName)) {
			//������
			String newFileName = StringUtils.subStringName(fileName);
			//����file����
			File file = new File("D:\\java��Ƶ\\��ҵ\\images\\"+newFileName);
			//ִ���ļ��ϴ�file
			 try {
					picFile.transferTo(file);
						
				    customer.setPicFilepath(newFileName);
							
				} catch (IllegalStateException | IOException e) {
					
					e.printStackTrace();
				}
					
			}
			//����service,������ݵĳ־û�
			int rows = customerSerivce.addCustomerInfo(customer);
				
			System.out.println("rows == "+rows);
				
			return "redirect:/showCustomer.jsp";
		
	}
	
	
	@RequestMapping(value="/findCustomerById/{id}",method={RequestMethod.GET})
	public String findCustomerById(@PathVariable("id") Long custId,Model model){
		
		System.out.println("custId == "+custId);
		
		Customer customer = customerSerivce.findCustomerById(custId);
		
		System.out.println("customer == "+customer);
		
		String address = customer.getCustAddress();
		
		String[] addresss  = address.split("-");
		
		model.addAttribute("proName", addresss[0]);
		model.addAttribute("cityName", addresss[1]);
		model.addAttribute("address", addresss[2]);
	
		model.addAttribute("cust", customer);
		
		return "editCustomer";
	}

	
	@RequestMapping("/editCustomerInfo")
	public String editCustomerInfo(String provinceName,String city,String address,MultipartFile picFile,Customer customer){
		
		//ƴ��ʡ�к������ֵ
		String custAddress = provinceName+"-"+city+"-"+address;
		customer.setCustAddress(custAddress);
		
		String uuinName = picFile.getOriginalFilename();
		if(org.apache.commons.lang.StringUtils.isNotBlank(uuinName)){
			
			String newPicName =StringUtils.subStringName(uuinName);
			//�ļ��ϴ�
			try {
				picFile.transferTo(new File("D:\\java��Ƶ\\��ҵ\\images\\"+newPicName));
				
				customer.setPicFilepath(newPicName);
			
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		int rows = customerSerivce.editCustInfo(customer);
		
		return "redirect:/showCustomer.jsp";
		
	}
}
