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

       /* function apply(name){
            var url = "/application/" + ;
            $http.post(url).then(function(response){
                vm.bookings = response.data;
            });
        }*/
    }
})();