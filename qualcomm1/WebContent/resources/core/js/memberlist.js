var myapp = angular.module('ui.bootstrap.demo', ['ngAnimate', 'ui.bootstrap']);
//angular.module('ui.bootstrap.demo').controller('memberlistCtrl', function($scope, $http) {
myapp.controller('memberlistCtrl', function($scope, $http) {	
    $http.get("http://uiuc-class.me:8080/classme/api/getmemberlist/")
    .success(function (response) {$scope.names = response;});
    
    $scope.quantity = 10;

    $scope.updateDesc = function(email, desc){
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
			    		window.location.replace("http://uiuc-class.me:8080/classme/memberlist/");
			    	}
			    	});
		}
	}
    
    $scope.deleteUser = function(email){
		if(email == null )
		{
			alert("Insufficient Data! ");
		}
		else
		{
			
			$scope.urlDelete = 'http://uiuc-class.me:8080/classme/api/deletemember/'+email+'/';
			$http.post($scope.urlDelete)
				.success(function (response) {
			    	if(response.result =='good')
			    	{
			    		window.location.replace("http://uiuc-class.me:8080/classme/memberlist/");
			    	}
			    	});

		}
	}
});