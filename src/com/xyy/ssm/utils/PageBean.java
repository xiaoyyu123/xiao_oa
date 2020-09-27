package com.xyy.ssm.utils;

import java.util.List;
/**
 * 封装分页参数的工具类
 * @author xiao
 *
 * @param <T>
 */
public class PageBean<T> {
	
	private Integer indexpage; //当前页 1
	
	private Integer pageSize ; //每页大小 5
	
	private Integer beginRows; //起始行
	
	private Integer totalPage; //总页码
	
	private Long countRow; //总记录数  select count(1) from 表名
	
	private List<T> dataList; //保存每页的数据
	
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
	
	//自动获取起始行
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
