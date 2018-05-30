(function () {
    'use strict';

    angular
        .module('app.internship', [])
        .controller('InternshipsController', InternshipsController);

    InternshipsController.$inject = ['$http'];

    function InternshipsController($http) {
        var vm = this;

        vm.internships = [];
        vm.getAll = getAll;
        vm.search = search;
        vm.apply = apply;
       // vm.apply = apply;

        init();

        function init(){
            getAll();
           // apply();
        }

        function getAll(){
            var url = "/internship/";
            var internshipsPromise = $http.get(url);
            internshipsPromise.then(function(response){
                vm.internships = response.data;
            });
        }

        function search(){
            var item = document.getElementById("searchkey").value;
            //alert(item);

            if(item == "") {
                getAll();
            } else {

                var url = "/internship/" + item;
                var internshipsPromise = $http.get(url);
                internshipsPromise.then(function(response){
                    vm.internships = [response.data];
                });

            }
        }

       function apply(student, internship){

           //var myFile = document.getElementById("resume");

            var fileInput = document.getElementById('resume');
    
            if( document.getElementById("resume").files.length == 0 ){
                alert("Please upload your resume before applying!");
            } else {

                var file = fileInput.files[0];
                var formData = new FormData();
                formData.append('file', file);

                var url = "/application?student=" + student +"&internship=" + internship; 

                var xhr = new XMLHttpRequest();

                xhr.open('POST', url, true);
                xhr.send(formData);

                alert("Application sent!");

              //  alert("Application sent!");
            }
                
        }
 
    }
})();