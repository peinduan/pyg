package com.pinyougou.sellergoods.service;

import java.util.List;

import com.pinyougou.bean.PageBean;
import com.pinyougou.pojo.TbBrand;

/**
 * 品牌接口
 * @author DarryRing
 *
 */

public interface BrandService {
	
	List<TbBrand> findAll();
	
	PageBean findPaging(int pageNum, int pageSize);

}
