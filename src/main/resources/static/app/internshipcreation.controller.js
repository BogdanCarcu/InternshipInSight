var app = angular.module('app.internshipcreator', []);
    app.controller('InternshipCreatorController', function($scope, $http, $location) {
    	$scope.submitForm = function(company_username){
    		
            var url = "/internship";
    		

    		var config = {
                    headers : {
                        'Accept': 'text/plain'
                    }
            }

            var true_name = company_username;

            var data = {

                    internshipId: 0,
                    name: $scope.name,
                    date: $scope.date,
                    description: $scope.description,
                    duration: $scope.duration,
                    company: true_name,

                };
                
                $http.post(url, data, config).then(function (response) {
                    $scope.postResultMessage = response.data;
                }, function error(response) {
                    $scope.postResultMessage = "Error with status: " +  response.statusText;
                });
            

    	   $scope.name = "";
           $scope.date = "";
           $scope.description = "";
           $scope.duration = "";
    	}
    });
    