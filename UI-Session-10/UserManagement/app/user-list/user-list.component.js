'use strict';

angular.module('userList').
component('userList',{
  templateUrl: 'user-list/user-list.template.html',
  controller: function UserListController($scope,$http){

    var self= this;

    $http.get('http://localhost:3000/users').then(function(response){
      self.users = response.data;
    });

            /*$scope.postData=function(){
                $http({
                    method:'POST',
                    url:'http://localhost:3000/users/',
                    data: $scope.user,
                    dataType:'json'
                });

                window.location.reload();
              };*/
              $scope.postData=function(){
               if($scope.user.id == null){
                console.log("Post data");
                $http({
                  method: 'POST',
                  url:'http://localhost:3000/users/',
                  data: $scope.user,
                  dataType:'json'
                });
              }else{
                console.log("Put data");
                $http.put('http://localhost:3000/users/' + $scope.user.id,$scope.user);
              }
              console.log("finally");

              window.location.reload();
            }

            $scope.editUser = function(id){
             console.log(id);
             console.log("Id get");
             $http({
              method: 'GET',
              url: 'http://localhost:3000/users/' + id
            }).then(function (response){
              $scope.user = response.data;
            });
            console.log("finally edit");
          }
        }
      });