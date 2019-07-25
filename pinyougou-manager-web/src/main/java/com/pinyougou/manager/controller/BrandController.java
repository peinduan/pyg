package com.pinyougou.manager.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;

import entity.PageResults;
import entity.Result;

@RestController
@RequestMapping("/brand")
public class BrandController {
	
	@Reference
	private BrandService brandService;
	
	/**
	 * 查询所有品牌
	 */
	@RequestMapping("/findAll")
	public List<TbBrand> findAll(){
		return brandService.findAll();
	}
	
	/**
	 * 分页查询所有品牌
	 */
	@RequestMapping("/findPaging")
	public PageResults findPaging(int pageNum, int pageSize){
		return brandService.findPaging(pageNum,pageSize);
	}
	
	/**
	 * 添加品牌
	 * @param tbBrand
	 * @return
	 */
	@RequestMapping("/addTbBrand")
	public Result findPaging(@RequestBody TbBrand tbBrand){
		try {
			brandService.addTbBrand(tbBrand);
			return new Result(true, "添加成功");
		} catch (Exception e) {
			// TODO: handle exception
			return new Result(false, "添加失败");
		}
	}
	
	/**
	 * 根据id查询品牌
	 */
	@RequestMapping("/findOneTbBrandById")
	public TbBrand findOneTbBrandById(long tbBrandId){
		return brandService.findOneTbBrandById(tbBrandId);
	}
	
	/**
	 * 修改品牌
	 */
	@RequestMapping("/updateTbBrand")
	public Result updateTbBrand(@RequestBody TbBrand tbBrand){
		try {
			brandService.updateTbBrand(tbBrand);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			// TODO: handle exception
			return new Result(false, "修改失败");
		}
	}
	
	/**
	 * 删除品牌
	 */
	@RequestMapping("/deleteTbBrandByIds")
	public Result deleteTbBrandByIds(long[] ids) {
		// TODO Auto-generated method stub
		try {
			brandService.deleteTbBrandByIds(ids);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			// TODO: handle exception
			return new Result(false, "删除失败");
		}	
	}
	
	/**
	 * 分页条件查询所有品牌
	 */
	@RequestMapping("/searchPaging")
	public PageResults findPaging(@RequestBody TbBrand tbBrand,int pageNum, int pageSize){
		return brandService.findPaging(tbBrand,pageNum,pageSize);
	}
	
	@RequestMapping("/selectOptionList")
	public List<Map> selectOptionList(){
		return brandService.selectOptionList();
	}
	

}
