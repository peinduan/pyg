app.controller("baseController",function($scope){
	//定义复选框选中数组
	$scope.selectIds=[];
	
	//统计选中复选框
	$scope.updateSelection=function($event,id){
		if($event.target.checked){
			$scope.selectIds.push(id);
		}else{
			var index=$scope.selectIds.indexOf(id);
			$scope.selectIds.splice(index,1);
		}
	}
	
	
	//分页控件配置 
	$scope.paginationConf = {
			 currentPage: 1,//当前页
			 totalItems: 10,//总记录数
			 itemsPerPage: 10,//每页显示条数
			 perPageOptions: [10, 20, 30, 40, 50],//选择每页显示条数
			 onChange: function(){
			      $scope.reloadList();//重新加载
			 }
	}; 
	
	/*重新加载*/
	$scope.reloadList=function(){
		$scope.search($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);
	}
	
	
	
	$scope.jsonToString=function(jsonString,key){
		var json=JSON.parse(jsonString);
		var s="";
		for(var i=0;i<json.length;i++){
			if(i>0){
				s+=",";
			}
			s+=json[i][key];
		}
		return s;
	}
	
	
})
