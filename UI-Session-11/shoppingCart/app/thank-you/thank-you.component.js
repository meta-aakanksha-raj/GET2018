'use strict';

angular.module('thankYou').
    component('thankYou',{
        templateUrl: 'thank-you/thank-you.template.html',
        controller: function ProductListController($scope,$http,$window,$rootScope,$routeParams){

        		$rootScope.cartItems = 0 ;
            $rootScope.cartArray = [];


            	$scope.totalAmount=0;
            	$scope.show = $routeParams.show;

        		let self = this;



        		$scope.getTotalAmount = function(){
                    $scope.totalAmount = 0;
                    let cart=0;
                    let itemAdded = 0;
                    for(;cart<$rootScope.cartArray.length;cart++){
                            $scope.totalAmount = $scope.totalAmount + $rootScope.cartArray[cart].quantity * $rootScope.cartArray[cart].price ;
                          }
                    console.log("Total amount : "+$scope.totalAmount);
            	}

            	$http.get('http://localhost:3000/products').then(function(response){
                	$scope.products = response.data;
            });

            	$scope.clearTheCart = function(){
              console.log("Clearing the cart function called");
              console.log("cartArray's length : "+$rootScope.cartArray.length);
              for(let i=0;i<$rootScope.cartArray.length;i++){
                    console.log("Inside the for loop.");
                    let product;
                    console.log("produxt's length : "+$scope.products.length);
                    for(let j=0;j<$scope.products.length;j++){
                        if($rootScope.cartArray[i].id==$scope.products[j].id)
                            {
                                product = $scope.products[j] ;
                                break;
                            }
                    }
                    product.itemAdded = "false";
                    $http.put('http://localhost:3000/products/'+product.id,product);
                    $http.delete('http://localhost:3000/cartItems/'+product.id);
                    console.log("Deleting : "+product.name);
                }
                for(let i=0;i<$rootScope.cartArray.length;i++){
                    $rootScope.cartArray[i].quantity = 0;
                }
                $rootScope.cartArray.clear();
                $rootScope.cartItems = 0;
                $scope.totalAmount = 0;
             }


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
                       $scope.clearTheCart();
                       $scope.getTotalAmount();
                      
             });

              $http.get('http://localhost:3000/order').then(function(response){
                  self.orders = response.data;
            });
            }

       });