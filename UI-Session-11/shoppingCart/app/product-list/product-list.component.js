'use strict';

angular.module('productList').
    component('productList',{
        templateUrl: 'product-list/product-list.template.html',
        controller: function ProductListController($scope,$http,$window,$rootScope){
            
            var self= this;
             $rootScope.cartItems = 0 ;

            $http.get('http://localhost:3000/products').then(function(response){
                self.products = response.data;
            });

            $http.get('http://localhost:3000/cartItems').then(function(response){
                       $scope.cartItemList = response.data;
                       let itemProduct = 0;
                       let cart=0;
                       for(;cart<$scope.cartItemList.length;cart++){
                            itemProduct = itemProduct + $scope.cartItemList[cart].quantity;
                          }
                       $rootScope.cartItems = itemProduct;
              });

            $scope.addItem=function(product){
             
              var cartProduct = {
                id : product.id,
                name: product.name,
                price: product.price,
                url : product.url,
                quantity:1,
                total : product.price
              };

              $http({
                      method: 'POST',
                      url:'http://localhost:3000/cartItems/',
                      data: cartProduct,
                      dataType:'json'
                    }).then(function mySuccess(response) {
                           product.itemAdded = "true";
                           $http.put('http://localhost:3000/products/'+product.id,product);
                           $scope.cartItems =$scope.cartItems + 1;
                           $window.location.reload();
                     }, function myError(response) {
                          
                    });
              }

          $scope.findProductQuantity = function(id){
                  
                      let itemProduct;
                       let cart=0;
                       for(;cart<$scope.cartItemList.length;cart++){
                          if($scope.cartItemList[cart].id == id){
                            itemProduct = $scope.cartItemList[cart].quantity;
                          }
                      } 
                      return itemProduct;
                }

            $scope.decreaseItemQuantity = function (product){
                 let cart=0;
                       for(;cart<$scope.cartItemList.length;cart++){
                          if($scope.cartItemList[cart].id == product.id){
                             if($scope.cartItemList[cart].quantity > 0){
                                $scope.cartItemList[cart].quantity--;
                                $scope.cartItemList[cart].total = $scope.cartItemList[cart].quantity * $scope.cartItemList[cart].price;
                             }
                            $http.put('http://localhost:3000/cartItems/'+product.id,$scope.cartItemList[cart]);
                             if($scope.cartItemList[cart].quantity == 0)
                               {
                                  product.itemAdded = "false";
                                  $http.put('http://localhost:3000/products/'+product.id,product);
                                  $http.delete('http://localhost:3000/cartItems/'+product.id);
                                }
                            break;
                          }
                      }
                $rootScope.cartItems = $rootScope.cartItems - 1;
                if($rootScope.cartItems < 0)
                {
                  $rootScope.cartItems = 0;
                }
            }

            $scope.increaseItemQuantity = function (product){
               let cart=0;
                      for(;cart<$scope.cartItemList.length;cart++){
                          if($scope.cartItemList[cart].id == product.id){
                            $scope.cartItemList[cart].quantity++;
                            $scope.cartItemList[cart].total = $scope.cartItemList[cart].quantity * $scope.cartItemList[cart].price;
                            $http.put('http://localhost:3000/cartItems/'+product.id,$scope.cartItemList[cart]);
                            break;
                          }
                       } 
                  $rootScope.cartItems = $rootScope.cartItems + 1;
                }

            
        }
    });
