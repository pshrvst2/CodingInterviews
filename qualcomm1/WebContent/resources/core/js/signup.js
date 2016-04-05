var myapp = angular.module('ui.bootstrap.demo', ['ngAnimate', 'ui.bootstrap']);

myapp.controller('SignupCtrl', function ($scope, $http) {
	
	$scope.inputName = null;
	$scope.inputPW = null;
	$scope.inputEmail = null;
	$scope.checkAndSignup = function(name, email, pw, pwc){
		if (pw == pwc)
		{
			if(name =="" || email == "" || pw == "")
			{
				alert("Insufficient Data! ");
			}
			else
			{
				$scope.url = 'http://uiuc-class.me:8080/classme/api/createmember/'+name+'/'+email+'/'+pw
				$http.post($scope.url)
					.success(function (response) {
				    	if(response.result =='good')
				    	{
				    		window.location.replace("http://uiuc-class.me:8080/classme/profile/"+email+"/");
				    	}
				    	});
			}
		}

	}
	
	});



myapp.controller('loginCtrl', function ($scope, $http, $location) {
	
	$scope.inputName = null;
	$scope.inputPW = null;
	//$scope.userName = 'classme@gmail.com';
	$scope.password ='123';
	$scope.url ="";
	$scope.checkCredential = function(email, pw){
		if(email == null || pw == null )
		{
			alert("Insufficient Data! ");
		}
		else
		{
			$scope.url = 'http://uiuc-class.me:8080/classme/api/login/'+email+'/'+pw;
			$http.get($scope.url)
			    .success(function (response) {
			    	if(response.result =='good')
			    	{    		
			    		window.location.replace("http://uiuc-class.me:8080/classme/profile/"+email+"/");
		
			    	}
			    	});
		}
	}

	});

myapp.controller('temp_1Ctrl', function ($scope, $http, $location) {
	
//	$scope.inputName = null;
//	$scope.inputPW = null;
//	//$scope.userName = 'classme@gmail.com';
//	$scope.password ='123';
//	$scope.url ="";
//	$scope.checkCredential = function(email, pw){
//		if(email == null || pw == null )
//		{
//			alert("Insufficient Data! ");
//		}
//		else
//		{
//			$scope.url = 'http://uiuc-class.me:8080/classme/api/login/'+email+'/'+pw;
//			$http.get($scope.url)
//			    .success(function (response) {
//			    	if(response.result =='good')
//			    	{    		
//			    		window.location.replace("http://uiuc-class.me:8080/classme/profile/"+email+"/");
//		
//			    	}
//			    	});
//		}
//	}

	});


myapp.controller('profileCtrl', function ($rootScope, $scope, $http,  $uibModal, $log) {
		//$scope.currentEmail = shareDataService.getData();
		//console.log($scope.param);
		var email = $scope.param; 
		$scope.url = 'http://uiuc-class.me:8080/classme/api/getmember/'+email+'/';
		//$scope.url ='http://uiuc-class.me:8080/classme/api/getmember/xchen135@illinois.edu/';
		//$scope.url ='http://uiuc-class.me:8080/classme/api/getmemberforprofile/';
		$http.get($scope.url)
			.success(function (response) {  		
	    		$scope.user = response;
	    	});
		$scope.url2 = 'http://uiuc-class.me:8080/classme/api/getcourseinfo/'+email+'/';
		$http.get($scope.url2)
	    .success(function (response) {$scope.courses = response;});
		
	    $scope.quantity = 10;
	    
	    $scope.updateDesc = function(desc){
			if(email == null || desc == null )
			{
				alert("Insufficient Data! ");
			}
			else
			{
				
				$scope.urlUpate = 'http://uiuc-class.me:8080/classme/api/updatemember/'+email+'/'+desc;
				$http.post($scope.urlUpate)
				    .success(function (response) {
				    	
				    	if(response.result =='good')
				    	{	    		
				    		window.location.replace("http://uiuc-class.me:8080/classme/profile/"+email+"/");
				    	}
				    	});
			}
		}
	    
	    $scope.animationsEnabled = true;

	    $scope.open = function () {
	      var modalInstance = $uibModal.open({
	        animation: $scope.animationsEnabled,
	        templateUrl: 'myModalContent.html',
	        controller: 'modalInstanceCtrl',
	        size: 'lg',
	        scope: $scope,
	        resolve: {
	            email: function () {
	              return $scope.param;
	            }
	          }
	      });

	      modalInstance.result.then(function (selectedItem) {
	        $scope.selected = selectedItem;
	      }, function () {
	        $log.info('Modal dismissed at: ' + new Date());
	      });
	    };

	    $scope.toggleAnimation = function () {
	      $scope.animationsEnabled = !$scope.animationsEnabled;
	    };
	    
	    $rootScope.$on('update', function(event, data) {
	    	console.log('updating');
	    	$scope.url2 = 'http://uiuc-class.me:8080/classme/api/getcourseinfo/'+email+'/';
	    	$http.get($scope.url2)
	    		.success(function (response) {$scope.courses = response;
	    		console.log($scope.courses);
	    		});
	    });
	    
	    $scope.deleteWatch = function(num, crn) {
	    	var url = ("http://uiuc-class.me:8080/classme/api/deletewatch/" + $scope.param + "/" + num + "/" + crn);
	    	console.log(url);
	    	$http.post(url)
			.success(function (response){$scope.$emit('update', {});});
	    }
});

angular.module('ui.bootstrap.demo').controller('modalInstanceCtrl', function ($scope, $rootScope, $modalInstance, $http, email) {
	  $http.get("http://uiuc-class.me:8080/classme/api/getclasslist/")
			.success(function (response) {$scope.classes = response;});
	  
	  $scope.$watch('item', function(){
		  $http.get("http://uiuc-class.me:8080/classme/api/getcrnforclass/"+$scope.item)
			     .success(function (response) {$scope.crns = response;});
	  }, true);
	  
	  $scope.ok = function (item, crn) {
		var url = ("http://uiuc-class.me:8080/classme/api/addwatch/" + email + "/" + item + "/" + crn);
		console.log(url);
		$http.post(url)
			.success(function (response){$rootScope.$broadcast('update', {});});
	    $modalInstance.close();
	  };

	  $scope.cancel = function () {
	    $modalInstance.dismiss('cancel');
	  };
	  
	});

/*
myapp.service('shareDataService', function($rootScope) {
	//  var currnetEmail =null;

	  var updateData = function (newObj){
		  $rootScope.test = newObj
	  }
	  var getData = function(){
	      return $rootScope.test;
	  }
	  
	  return {
	    updateData: updateData,
	    getData: getData
	  };
});
*/