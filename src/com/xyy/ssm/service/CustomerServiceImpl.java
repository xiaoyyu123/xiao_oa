package com.xyy.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xyy.ssm.dao.CustomerMapper;
import com.xyy.ssm.pojo.Customer;
import com.xyy.ssm.pojo.CustomerExample;
import com.xyy.ssm.pojo.CustomerExample.Criteria;
import com.xyy.ssm.utils.PageBean;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerMapper customerMapper;
	
	/**
	 * 分页查询
	 * * 想采用pagehelper后台分页插件完成分页
	 * 1.导入相关jar包
	 * 2.初始化分页参数
	 * 3.查询当前页的数据
	 * 4.封装到pageInfo中
	 * 5.把数据封装成某个封装数据的工具类
	 * @param indexpage
	 * @return
	 */
	@Override
	public PageBean<Customer> findCustomerByPage(Integer indexpage ,String custSource,String custName,String custLevel) {
		
		//1. 默认首页 ，没有传递参数
		if(indexpage == null){
			indexpage = 1;
		}
		//2.初始化分页参数PageHelper.startPage("当前页面","每页的条数");
		PageHelper.startPage(indexpage, 5);
		//3.获取当前页的数据信息		
		CustomerExample example = new CustomerExample(); 
		Criteria criteria = example.createCriteria();
		
		custName = "%"+custName+"%";
		custSource = "%"+custSource+"%";
		custLevel = "%"+custLevel+"%";
		
		criteria.andCustNameLike(custName);
		criteria.andCustSourceLike(custSource);
		criteria.andCustLevelLike(custLevel);
		
		List<Customer> customerList =  customerMapper.selectByExample(example);
		System.out.println("service : customerList ===" +customerList);
		//4.把获取到的数据灌入到PageInfo中
		PageInfo<Customer> pageInfo = new PageInfo<Customer>(customerList); 
		//5. 在把数据信息封装到一个工具类中去,得到当前页 、每页大小 、总的记录数 、当前页的数据
		PageBean<Customer> CustomerpageBean = new PageBean<Customer>();
				
		CustomerpageBean.setIndexpage(indexpage);
		CustomerpageBean.setPageSize(pageInfo.getPageSize());
		CustomerpageBean.setCountRow(pageInfo.getTotal());
		CustomerpageBean.setDataList(customerList);
				
		return CustomerpageBean;		
	
	}

	
	/**
	 * 根据主键id删除
	 * @param custId
	 * @return
	 */
	@Override
	public int deleteCustomerById(Long custId) {
		
		int rows = customerMapper.deleteByPrimaryKey(custId);
		
		System.out.println("service : rows"+rows);
		
		return rows;
	}


	@Override
	public int addCustomerInfo(Customer customer) {
		int rows = customerMapper.insertSelective(customer);
		System.out.println("rows==="+rows);
		return rows;
	}


	@Override
	public Customer findCustomerById(Long custId) {

		Customer customer =	customerMapper.selectByPrimaryKey(custId);
		
		System.out.println("service: customer==="+customer);
		
		return customer;
	}


	@Override
	public int editCustInfo(Customer customer) {
		
		int rows = customerMapper.updateByPrimaryKey(customer);
		
		return rows;
	}

}
