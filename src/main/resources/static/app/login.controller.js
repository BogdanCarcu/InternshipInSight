var myApp = angular.module('app.login', []);
 
myApp.controller('LoginController', function($scope, $http, $window) {
 
    $scope.submit = function () {
  
      var url_student = "/student.html";
      var url_company = "/company.html";
      var url = "/login";

      var uname = $scope.username;
      var password = $scope.password;

      var furl = url + '?username=' + uname + '&password=' + password;

      $http.get(furl).then(function (response) {
          var getResultMessage = response.data;
          
          var json = JSON.stringify(getResultMessage);
          var maybe_student = json.substring(2, 9);
          var maybe_company = json.substring(2, 9);

          alert(maybe_company);
          alert(maybe_student);

          var username = response.data["username"];
          
          if(maybe_student == 'student') {

              $window.location.href = '/student.html/' + username;

          } 

          else if(maybe_company == 'company') {

        	  $window.location.href = '/company.html/' + username;

          } else {

              alert("Incorrect username/password!");

          }


        }, function error(response) {
          getResultMessage = "Error with status: " +  response.statusText;
      });

      
    };
 
});