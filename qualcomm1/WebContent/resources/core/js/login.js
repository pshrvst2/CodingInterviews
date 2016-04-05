//var myapp = angular.module('ui.bootstrap.demo', ['ngAnimate', 'ui.bootstrap']);
//
//
//myapp.controller('loginCtrl', function ($scope, $http) {
//	
//	$scope.inputName = null;
//	$scope.inputPW = null;
//	$scope.url ="";
//	$scope.checkCredential = function(email, pw){
//		if(email == null || pw == null )
//		{
//			alert("Insufficient Data! ");
//		}
//		else
//		{
//			$scope.url = 'http://localhost:8080/classme/api/login/'+email+'/'+pw;
//			$http.get($scope.url)
//			    .success(function (response) {
//			    	if(response.result =='good')
//			    	{
//			    		$rootScope.userEmail = email;		    		
//			    		window.location.replace("http://localhost:8080/classme/memberlist/");
//			    	}
//			    	});
//		}
//	}
//
//	});
//
//
