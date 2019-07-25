app.controller("brandController",function($scope,$http,$controller,brandService){
	
	$controller("baseController",{$scope:$scope});
			
	$scope.findAll=function(){
		brandService.findAll().success(function(data) {
			$scope.list=data;
		});
	}
	
	
	//删除所选品牌
	$scope.deleteSelection=function(){
		if($scope.selectIds.length==0){
			alert("请选择需要删除的品牌");
			return;
		}
		if(confirm("是否确定删除所选品牌")){
			brandService.deleteSelection($scope.selectIds).success(function(data) {
				if(data.success){
					$scope.reloadList();
				}else{
					alert(data.message);
				}
				
			});
		}
	}
	
	/*新增品牌*/
	$scope.saveTbBrand=function(){
		var object=null;
		if($scope.entity.id!=null){
			object=brandService.updateTbBrand($scope.entity);
		}else{
			object=brandService.addTbBrand($scope.entity);
		}
		object.success(function(data) {
			if(data.success){
				alert(data.message);
				$scope.reloadList();
			}else{
				alert(data.message);
			}
		});
	}
	
	/*根据id查询品牌*/
	$scope.findOneTbBrandById=function(tbBrandId){
		brandService.findOneTbBrandById(tbBrandId).success(function(data) {
			$scope.entity=data
		});
	}
	
	
	
	/*分页查询所有品牌*/
	$scope.findPaging=function(pageNum,pageSize){
		brandService.findPaging(pageNum,pageSize).success(function(data) {
			$scope.list=data.rows;
			$scope.paginationConf.totalItems=data.total;
		});
	}
	
	/*初始化查询条件*/
	$scope.searchEntity={};
	
	
	/*分页条件查询所有品牌*/
	$scope.search=function(pageNum,pageSize){
		brandService.search(pageNum,pageSize,$scope.searchEntity).success(function(data) {
			$scope.list=data.rows;
			$scope.paginationConf.totalItems=data.total;
		});
	}
});