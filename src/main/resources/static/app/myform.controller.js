
    var app = angular.module('app.controllers', []);
    app.controller('StudentRegistrationController', function($scope, $http, $location) {
    	$scope.submitForm = function(){
    		var url = "/studentregistration";
    		
    		var config = {
                    headers : {
                        'Accept': 'text/plain'
                    }
            }
    		var data = {
                username: $scope.username,
                password: $scope.password,
                email: $scope.email,
                name: $scope.name,
                age: $scope.age,
                university: $scope.university
            };
    		
    		$http.post(url, data, config).then(function (response) {
    			$scope.postResultMessage = response.data;
    		}, function error(response) {
    			$scope.postResultMessage = "Error with status: " +  response.statusText;
    		});
    		
    	   $scope.username = "";
           $scope.password = "";
           $scope.email = "";
           $scope.name = "";
           $scope.age = "";
           $scope.university = "";
    	}
    });
    