(function () {
    'use strict';

    angular
        .module('app.application', [])
        .controller('ApplicationsController', ApplicationsController);

    ApplicationsController.$inject = ['$http'];

    function ApplicationsController($http) {
        var vm = this;

        vm.applications = [];
        vm.getAll = getAll;
        vm.review = review;
        vm.accept = accept;
        vm.inform = inform;
        vm.redirect = redirect;
       // vm.apply = apply;
       // vm.apply = apply;

        init();

        function init(){
           // getAll();
           // apply();
        }

        function getAll(company){

            var url = "/detailedapplication/" + company;
            var internshipsPromise = $http.get(url);
            internshipsPromise.then(function(response){
                
                vm.applications = response.data;

            });
        }

        function review(student, internship){

                        var url = "/cvreview?student=" + student +"&internship=" + internship; 

                        var xhr = new XMLHttpRequest();

                        xhr.open('GET', url, true);

                        xhr.send();
                        xhr.responseType = 'blob';
                        xhr.onload = function(e) {
                        if (this.status == 200) {
                            // Create a new Blob object using the response data of the onload object
                            var blob = new Blob([this.response], {type: 'image/pdf'});
                            //Create a link element, hide it, direct it towards the blob, and then 'click' it programatically
                            let a = document.createElement("a");
                            a.style = "display: none";
                            document.body.appendChild(a);
                            //Create a DOMString representing the blob and point the link element towards it
                            let url = window.URL.createObjectURL(blob);
                            a.href = url;
                            a.download = student + ' Resume.pdf';
                            //programatically click the link to trigger the download
                            a.click();
                            //release the reference to the file by revoking the Object URL
                            window.URL.revokeObjectURL(url);
                        }else{
                            //deal with your error state here
                        }
                    };                        
                              
            }
        function accept(student, internship, btn){

                        var url = "/feedback/acceptance/?student=" + student +"&internship=" + internship; 

                        var xhr = new XMLHttpRequest();

                        xhr.open('PUT', url, true);

                        xhr.send();
    
                        xhr.onload = function(e) {
                        if (this.status == 200) {
                            
                            alert("Candidate accepted!");
                            //document.getElementById("accept").disabled = true;
                            btn.target.disabled = true;

                        }else{
                            //deal with your error state here
                        }
    
                    };                        
                              
            }
        function inform(){
            var item = document.getElementById("internship").value;

            if(item == "") {
                
                alert("No input internship!");    

            } else {

                var url = "/feedback/info?internship=" + item;
            
                $http.post(url).then(function(response){

                    var getResultMessage = response.data;
                    var json = JSON.stringify(getResultMessage);  
                   // alert(json);

                    if(json == 'true') {
                        
                        alert("Candiates were informed about internship: " + item);
                    } else {

                        alert("A problem occured. Please try again!");

                    }
                   
                 
                });

            }
        }

         function redirect(company) {

             var newWin = window.open('/internship.html/' + company, 'e');

      } 
    }
})();