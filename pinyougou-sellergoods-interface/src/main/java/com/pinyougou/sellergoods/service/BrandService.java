package com.pinyougou.sellergoods.service;

import java.util.List;
import java.util.Map;

import com.pinyougou.pojo.TbBrand;

import entity.PageResults;

/**
 * 品牌接口
 * @author DarryRing
 *
 */

public interface BrandService {
	
	List<TbBrand> findAll();
	
	PageResults findPaging(int pageNum, int pageSize);
	
	void addTbBrand(TbBrand tbBrand);
	
	TbBrand findOneTbBrandById(long tbBrandId);
	
	void updateTbBrand(TbBrand tbBrand);
	
	void deleteTbBrandByIds(long[] ids);
	
	PageResults findPaging(TbBrand tbBrand,int pageNum, int pageSize);
	
	List<Map> selectOptionList();

}
