package com.xyy.ssm.utils;

import java.util.List;
/**
 * ��װ��ҳ�����Ĺ�����
 * @author xiao
 *
 * @param <T>
 */
public class PageBean<T> {
	
	private Integer indexpage; //��ǰҳ 1
	
	private Integer pageSize ; //ÿҳ��С 5
	
	private Integer beginRows; //��ʼ��
	
	private Integer totalPage; //��ҳ��
	
	private Long countRow; //�ܼ�¼��  select count(1) from ����
	
	private List<T> dataList; //����ÿҳ������
	
	public Integer getIndexpage() {
		return indexpage;
	}
	
	public void setIndexpage(Integer indexpage) {
		this.indexpage = indexpage;
	}
	
	public Integer getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	//�Զ���ȡ��ʼ��
	public Integer getBeginRows() {
		
		return (getIndexpage()-1)*getPageSize();
	}

	public Integer getTotalPage() {
		totalPage = (int) ((getCountRow()%getPageSize()==0)?getCountRow()/getPageSize():getCountRow()/getPageSize()+1);
		return totalPage;
	}
	
	
	public Long getCountRow() {
		return countRow;
	}

	public void setCountRow(Long countRow) {
		this.countRow = countRow;
	}
	
	public List<T> getDataList() {
		return dataList;
	}
	
	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

}
