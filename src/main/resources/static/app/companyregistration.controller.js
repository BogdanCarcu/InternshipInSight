
    var app = angular.module('app.controllers2', []);
    app.controller('CompanyRegistrationController', function($scope, $http, $location) {
    	$scope.submitForm = function(){
    		var url = "/companyregistration";
    		
    		var config = {
                    headers : {
                        'Accept': 'text/plain'
                    }
            }
    		var data = {
                username: $scope.username,
                password: $scope.password,
                name: $scope.name,
                numberOfEmployees: $scope.numberOfEmployees,
        
            };
    		
    		$http.post(url, data, config).then(function (response) {
    			$scope.postResultMessage = response.data;
    		}, function error(response) {
    			$scope.postResultMessage = "Error with status: " +  response.statusText;
    		});
    		
    	   $scope.username = "";
           $scope.password = "";
           $scope.name = "";
           $scope.numberOfEmployees = "";
    	}
    });
    