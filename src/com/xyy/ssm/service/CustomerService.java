package com.xyy.ssm.service;

import com.xyy.ssm.pojo.Customer;
import com.xyy.ssm.utils.PageBean;

public interface CustomerService {

	/**
	 * 分页查询
	 * 使用后台插件 pageHelper
	 * @param indexpage
	 * @return
	 */
	PageBean<Customer> findCustomerByPage(Integer indexpage ,String custSource,String custName,String custLevel);

	/**
	 * 根据主键id删除
	 * @param custId
	 * @return
	 */
	int deleteCustomerById(Long custId);

	/**
	 * 添加数据带文件上传
	 * @param customer
	 * @return
	 */
	int addCustomerInfo(Customer customer);

	/**
	 * 根据主键Id查询信息的方法
	 * @param custId
	 * @return
	 */
	Customer findCustomerById(Long custId);

	/**
	 * 根据主键Id修改信息的方法
	 * @param customer
	 * @return
	 */
	int editCustInfo(Customer customer);

}
