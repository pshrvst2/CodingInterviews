var myapp = angular.module('ui.bootstrap.demo', ['ngAnimate', 'ui.bootstrap']);

myapp.controller('temp_1Ctrl', function($scope, $http) {	
	$http.get("http://localhost:8080/qualcomm/api/getcountryname/")
    .success(function (response) {$scope.rawData = response;});
    
    $scope.quantity = 10;
    
    
    // for highlight and de-highlight
    $scope.isGrey = [];
    $scope.highlight = function(id) {
    $scope.isGrey[id] = 'event-checkIn-tb-highlight';

    };
    
});

myapp.controller('temp_2Ctrl', function($scope, $http) {	
	$scope.inputMax = null;
	$scope.inputMin = null;
	var pattern = /^\d+.?\d*$/;
	$scope.checkAndgetInfo = function(min, max){

		if(min ==" " || max == "" || min=="" || max==""|| min==null|| max==null)
		{
			alert("Insufficient Data! ");
		}
		else if(min.match(pattern)==null || max.match(pattern)==null){
			alert("invalid Input!");
		}
		else if(min>max){
			alert("Maximun value should be bigger than minimum value");
		}
		else
		{
			$scope.url = 'http://localhost:8080/qualcomm/api/getcountrynamewithrange/'+min+'/'+max;
			$http.post($scope.url)
			.success(function (response) {$scope.rawData = response;});
		}
	}
	
});