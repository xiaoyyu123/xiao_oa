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
	 * ��ҳ��ѯ
	 * * �����pagehelper��̨��ҳ�����ɷ�ҳ
	 * 1.�������jar��
	 * 2.��ʼ����ҳ����
	 * 3.��ѯ��ǰҳ������
	 * 4.��װ��pageInfo��
	 * 5.�����ݷ�װ��ĳ����װ���ݵĹ�����
	 * @param indexpage
	 * @return
	 */
	@Override
	public PageBean<Customer> findCustomerByPage(Integer indexpage ,String custSource,String custName,String custLevel) {
		
		//1. Ĭ����ҳ ��û�д��ݲ���
		if(indexpage == null){
			indexpage = 1;
		}
		//2.��ʼ����ҳ����PageHelper.startPage("��ǰҳ��","ÿҳ������");
		PageHelper.startPage(indexpage, 5);
		//3.��ȡ��ǰҳ��������Ϣ		
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
		//4.�ѻ�ȡ�������ݹ��뵽PageInfo��
		PageInfo<Customer> pageInfo = new PageInfo<Customer>(customerList); 
		//5. �ڰ�������Ϣ��װ��һ����������ȥ,�õ���ǰҳ ��ÿҳ��С ���ܵļ�¼�� ����ǰҳ������
		PageBean<Customer> CustomerpageBean = new PageBean<Customer>();
				
		CustomerpageBean.setIndexpage(indexpage);
		CustomerpageBean.setPageSize(pageInfo.getPageSize());
		CustomerpageBean.setCountRow(pageInfo.getTotal());
		CustomerpageBean.setDataList(customerList);
				
		return CustomerpageBean;		
	
	}

	
	/**
	 * ��������idɾ��
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
