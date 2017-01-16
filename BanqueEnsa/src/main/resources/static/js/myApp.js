var app=angular.module("myBanqueApp",[]);
app.controller("myBanqueController", function($scope,$http) {
	
	$scope.compte=null;
	$scope.codeCompte=null;
	$scope.operation={type:"versement",montant:0,cpte2:null}
	$scope.pageOperations=[];
	$scope.pageCourant=0;
	$scope.pageSize=3;
	
	$scope.pages=[];
	$scope.errorMessage=null;
	
	

	
	
	$scope.chargerCompte=function(){
		$scope.pageCourant=0;
		$http.get("/comptes/"+$scope.codeCompte)
		.success(function(data){
			$scope.compte=data;
			$scope.chargerOperations();
			
		}).error(function(data){
			$scope.errorMessage=data.message;
			$scope.compte=null;
			
		});
		
		
			
		
	};
	
	$scope.gotopage=function(p){
		$scope.pageCourant=p;
		$scope.chargerOperations();
	}
	
$scope.chargerOperations=function(){
	
	
		$scope.errorMessage=null;
		$http.get("/operations?codecompte="+$scope.codeCompte+"&page="+$scope.pageCourant+"&size="+$scope.pageSize)
		.success(function(data){
			$scope.pageOperations=data;
			$scope.pages=new Array(data.totalpages);
		});
		
	};
	
	
	
	$scope.saveOperation=function(){
		
		var params="";
		if($scope.operation.type=='virement'){
			params="cpte1="+$scope.codeCompte+"&cpte2="+$scope.operation.cpte2+"&montant="+$scope.operation.montant+"&codeemp=1";
		}else{
			params="code="+$scope.codeCompte+"&montant="+$scope.operation.montant+"&codeemp=1";
		}
		
		$http({
	        method : 'PUT',
	        url    : $scope.operation.type,
	        data   :params,
	        headers:{'Content-Type':'application/x-www-form-urlencoded'}
	      })
	         .success(function(data){
	             $scope.chargerCompte();
	             //$scope.loadOperations();
	      }) .error(function(data){
	             $scope.errorMessage=data.message;
	             //$scope.loadOperations();
	      })
	      
	      ;
		
	};
	
});