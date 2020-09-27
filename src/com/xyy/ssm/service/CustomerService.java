package com.xyy.ssm.service;

import com.xyy.ssm.pojo.Customer;
import com.xyy.ssm.utils.PageBean;

public interface CustomerService {

	/**
	 * ��ҳ��ѯ
	 * ʹ�ú�̨��� pageHelper
	 * @param indexpage
	 * @return
	 */
	PageBean<Customer> findCustomerByPage(Integer indexpage ,String custSource,String custName,String custLevel);

	/**
	 * ��������idɾ��
	 * @param custId
	 * @return
	 */
	int deleteCustomerById(Long custId);

	/**
	 * ������ݴ��ļ��ϴ�
	 * @param customer
	 * @return
	 */
	int addCustomerInfo(Customer customer);

	/**
	 * ��������Id��ѯ��Ϣ�ķ���
	 * @param custId
	 * @return
	 */
	Customer findCustomerById(Long custId);

	/**
	 * ��������Id�޸���Ϣ�ķ���
	 * @param customer
	 * @return
	 */
	int editCustInfo(Customer customer);

}
