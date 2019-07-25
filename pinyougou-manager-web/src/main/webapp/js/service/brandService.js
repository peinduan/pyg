/*品牌服务*/
app.service("brandService",function($http){
	this.findAll=function(){
		return $http.get("../brand/findAll.do");
	}
	
	this.deleteSelection=function(selectIds){
		return $http.get("../brand/deleteTbBrandByIds.do?ids="+selectIds);
	}
	
	this.addTbBrand=function(entity){
		return $http.post("../brand/addTbBrand.do",entity);
	}
	
	this.updateTbBrand=function(entity){
		return $http.post("../brand/updateTbBrand.do",entity);
	}
	
	this.findOneTbBrandById=function(tbBrandId){
		return $http.get("../brand/findOneTbBrandById.do?tbBrandId="+tbBrandId);
	}
	
	this.findPaging=function(pageNum,pageSize){
		return $http.get("../brand/findPaging.do?pageNum="+pageNum+"&pageSize="+pageSize);
	}
	
	this.search=function(pageNum,pageSize,searchEntity){
		return $http.post("../brand/searchPaging.do?pageNum="+pageNum+"&pageSize="+pageSize,searchEntity);
	}
	
	//品牌列表
	this.selectOptionList=function(){
		return $http.get('../brand/selectOptionList.do');
	}
});