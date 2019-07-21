package com.pinyougou.sellergoods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.bean.PageBean;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;


@Service
public class BrandServiceImpl implements BrandService {
	
	@Autowired
	private TbBrandMapper brandMaper;

	/**
	 * 查询所有品牌
	 */
	@Override
	public List<TbBrand> findAll() {
		// TODO Auto-generated method stub
		return brandMaper.selectByExample(null);
	}

	
	/**
	 * 分页查询所有品牌
	 */
	@Override
	public PageBean findPaging(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		Page<TbBrand> page = (Page<TbBrand>) brandMaper.selectByExample(null);
		return new PageBean(page.getResult(),page.getTotal());
	}

}
