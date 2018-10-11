"use strict";

angular.module('userList').
	component('userList',{
		templateUrl : 'userList/user-list.template.html',
		controller : function UserListController($scope,$http){

			$scope.userData;

            var self= this;

            $http.get('http://localhost:3000/users').then(function(response){
                self.users = response.data;
                });

            $scope.show=function(userData){
                self.userData = userData;
            }

            $scope.postData=function(){
                $http({
                    method:'POST',
                    url:'http://localhost:3000/users/',
                    data: $scope.user,
                    dataType:'json'
                });

                window.location.reload();
            };

            	/*var url = 'puturl', data = 'parameters' , config='contenttype';
*/
				/*$http({
					method:'PUT',
					url: 'http://localhost:3000/users/',
					data: $scope.user,
					dataType:'json'
				});*//*.then(function (response) {
				url, data, config
				// This function handles success

				}, function (response) {
				*/	
				 $scope.UpdateData = function () {
			           /* var data = $.param({
			                name: $scope.name,
			                phone: $scope.phone,
			                location: $scope.location
			            });*/

			            $http.put('/api/Default?'+ data)
			            .success(function (data, status, headers) {
			                $scope.ServerResponse = data;
			            })
			            .error(function (data, status, headers, config) {
			                $scope.ServerResponse =  htmlDecode("Data: " + data +
			                    "\n\n\n\nstatus: " + status +
			                    "\n\n\n\nheaders: " + header +
			                    "\n\n\n\nconfig: " + config);
			            });
			     	        window.location.reload();
						// this function handles error

						};			
				}
	});