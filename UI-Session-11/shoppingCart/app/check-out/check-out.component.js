'use strict';

angular.module('checkOut').
    component('checkOut',{
        templateUrl: 'check-out/check-out.template.html',
        controller: function CheckOutController($scope,$http,$rootScope,$window){

          Array.prototype.clear = function() {
                while (this.length) {
                  this.pop();
                }
              };


        	 var self= this;
            $rootScope.cartItems = 0 ;
            $rootScope.cartArray = [];
          
            $scope.totalAmount=0;
            $scope.totalItemsToBePlaced=0;

            $scope.user = {
            	"name":"",
            	"address":"",
            	"city":"",
            	"number":""
            }

        	$http.get('http://localhost:3000/products').then(function(response){
                $scope.products = response.data;
            });

          $http.get('http://localhost:3000/cartItems').then(function(response){
                       $scope.cartItemList = response.data;
                       let cart=0;
                       let itemAdded = 0;
                       for(;cart<$scope.cartItemList.length;cart++){
                            $rootScope.cartArray[cart] = $scope.cartItemList[cart];
                            itemAdded = itemAdded + $rootScope.cartArray[cart].quantity;
                          }
                       $rootScope.cartItems = itemAdded;
                       $scope.totalItemsToBePlaced = $rootScope.cartItems;
                       self.itemInTheCart = $rootScope.cartArray;
                       $scope.getTotalAmount();
             });


            $scope.getTotalAmount = function(){
                    $scope.totalAmount = 0;
                    let cart=0;
                    let itemAdded = 0;
                    for(;cart<$rootScope.cartArray.length;cart++){
                            $scope.totalAmount = $scope.totalAmount + $rootScope.cartArray[cart].quantity * $rootScope.cartArray[cart].price ;
                          }
                    console.log("Total amount : "+$scope.totalAmount);
            }

            $scope.placeTheOrder = function(user){
                let flag="false";
            		let order = {
            			"name":user.name,
            			"address":user.address,
            			"city":user.city,
            			"number":user.number,
            			"date":new Date(),
            			"items":$rootScope.cartArray
            		}
                console.log(order.name);
            		$http({
               				method: 'POST',
                			url:'http://localhost:3000/order/',
                			data: order,
                			dataType:'json'
              			}).then(function mySuccess(response) {
              					console.log("Order Added Succesfully!");
              			 }, function myError(response) {
                    			console.log("Order Failed!")
             		 });
                //alert("Your Order Is Placed.");
            }

             


        }
    });
