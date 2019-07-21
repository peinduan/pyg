package com.pinyougou.bean;

import java.io.Serializable;
import java.util.List;

import com.pinyougou.pojo.TbBrand;

/**
 * 分页对象
 * @author DarryRing
 *
 */
public class PageBean implements Serializable{
	
	private List<TbBrand> result;
	private long totalCount;
	
	
	
	public PageBean(List<TbBrand> result, long totalCount) {
		super();
		this.result = result;
		this.totalCount = totalCount;
	}
	public List<TbBrand> getResult() {
		return result;
	}
	public void setResult(List<TbBrand> result) {
		this.result = result;
	}
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	
	
	
	
	
	
}
