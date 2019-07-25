package com.pinyougou.sellergoods.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.pojo.TbBrandExample.Criteria;
import com.pinyougou.sellergoods.service.BrandService;

import entity.PageResults;


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
	public PageResults findPaging(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		Page<TbBrand> page = (Page<TbBrand>) brandMaper.selectByExample(null);
		return new PageResults(page.getTotal(),page.getResult());
	}


	/**
	 * 添加品牌
	 * @param tbBrand
	 * @return
	 */
	@Override
	public void addTbBrand(TbBrand tbBrand) {
		// TODO Auto-generated method stub
		brandMaper.insert(tbBrand);
		 
	}

	/**
	 * 根据id查询品牌
	 */
	@Override
	public TbBrand findOneTbBrandById(long tbBrandId) {
		// TODO Auto-generated method stub
		return brandMaper.selectByPrimaryKey(tbBrandId);
	}

	/**
	 * 修改品牌
	 */
	@Override
	public void updateTbBrand(TbBrand tbBrand) {
		// TODO Auto-generated method stub
		brandMaper.updateByPrimaryKey(tbBrand);
	}
	
	/**
	 * 删除品牌
	 */
	@Override
	public void deleteTbBrandByIds(long[] ids) {
		// TODO Auto-generated method stub
		for(long id:ids) {
			brandMaper.deleteByPrimaryKey(id);
		}	
	}

	/**
	 * 条件查询品牌
	 */
	@Override
	public PageResults findPaging(TbBrand tbBrand, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		TbBrandExample tbBrandExample = new TbBrandExample();
		if (tbBrand!=null) {
			Criteria createCriteria = tbBrandExample.createCriteria();
			if (tbBrand.getName()!=null&&tbBrand.getName().length()>0) {
				createCriteria.andNameLike("%"+tbBrand.getName()+"%");
			}
			if (tbBrand.getFirstChar()!=null&&tbBrand.getFirstChar().length()>0) {
				createCriteria.andFirstCharLike("%"+tbBrand.getFirstChar()+"%");
			}
		}
		PageHelper.startPage(pageNum, pageSize);
		Page<TbBrand> page = (Page<TbBrand>) brandMaper.selectByExample(tbBrandExample);
		return new PageResults(page.getTotal(),page.getResult());
	}


	@Override
	public List<Map> selectOptionList() {
		// TODO Auto-generated method stub
		return brandMaper.selectOptionList();
	}

}
