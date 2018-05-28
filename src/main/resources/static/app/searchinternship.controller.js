 var app = angular.module('app.search', []);
    app.controller('SearchController', function($scope, $http) {
    	$scope.search = function(){

            var vm = this;
            vm.internships = [];
    		var url = "/internship/";
    		
    		var item = vm.searchbar;
            alert(item);
            var furl = url + item;

            var internshipsPromise = $http.get(furl);
            internshipsPromise.then(function(response){
                vm.internships = response.data;
    		});
        }
    	
    });