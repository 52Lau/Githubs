package com.lau.githubs.common;

import java.util.List;

public class Page {
	/**
	 * 每页数据长度
	 * */
	public Integer pageSize = 10;
	
	/**
	 * 
	 * 页数
	 * 
	 * */

	public Integer pageNum = 1;
	
	/**
	 *数据总行数 
	 * 
	 * */

	public Integer resultCount = 0;
	/**
	 * 
	 * 数据集合
	 * 
	 * */

	public List<?> list;
	
	/**
	 * 总页数
	 * 
	 * */
	
	public Integer totalPage;

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public Integer getPageSize() {
		if(null==pageSize){
			pageSize = 10;
		}
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNum() {
		if(null==pageNum||(pageNum-1)*getPageSize()>getResultCount()){
			pageNum = 1;
		}
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getResultCount() {
		if(null==resultCount){
			resultCount = 0;
		}
		return resultCount;
	}

	public void setResultCount(Integer resultCount) {
		this.resultCount = resultCount;
	}

	public int getFirstIndex() {
		return (getPageNum() - 1) * pageSize;
	}
	//总共页数
	public Integer getTotalPage() {
		int i = getResultCount()%getPageSize();
		if(i==0){
			return getResultCount()/getPageSize();
		}
		return getResultCount()/getPageSize()+1;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getLastIndex() {
		return getFirstIndex()+pageSize;
	}
}
