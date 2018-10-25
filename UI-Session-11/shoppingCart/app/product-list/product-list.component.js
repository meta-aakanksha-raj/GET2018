'use strict';

angular.module('productList').
    component('productList',{
        templateUrl: 'product-list/product-list.template.html',
        controller: function ProductListController($scope,$http,$rootScope){
            
            var self= this;
            $rootScope.cartItems = 0 ;
            $rootScope.cartArray = [];
            
            $scope.printContent = function (){
                console.log("---------");
                for(let i=0;i<$rootScope.cartArray.length;i++)
                {
                    console.log("id : "+$rootScope.cartArray[i].id +" name : "+ $rootScope.cartArray[i].name +" quantity : "+$rootScope.cartArray[i].quantity);
                }
                console.log("----------")
            }

            $scope.printContent();

            $http.get('http://localhost:3000/products').then(function(response){
                self.products = response.data;
            });

            $http.get('http://localhost:3000/cartItems').then(function(response){
                       $scope.cartItemList = response.data;
                       let cart=0;
                       let itemAdded = 0;
                       for(;cart<$scope.cartItemList.length;cart++){
                            $rootScope.cartArray[cart] = $scope.cartItemList[cart];
                            itemAdded = itemAdded + $rootScope.cartArray[cart].quantity;
                            $scope.totalAmount = $scope.totalAmount + $rootScope.cartArray[cart].total ;
                          }
                       $rootScope.cartItems = itemAdded;
                       
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

              $rootScope.cartArray.push(cartProduct);
              $rootScope.cartItems = $rootScope.cartItems + 1;
              $http({
                method: 'POST',
                url:'http://localhost:3000/cartItems/',
                data: cartProduct,
                dataType:'json'
              }).then(function mySuccess(response) {
                     product.itemAdded = "true";
                     $http.put('http://localhost:3000/products/'+product.id,product);
               }, function myError(response) {
                    
              });
              $scope.printContent();
            }

          $scope.findProductQuantity = function(id){  
                    let itemProduct;
                    let cart=0;
                    for(;cart<$rootScope.cartArray.length;cart++){
                        if($rootScope.cartArray[cart].id==id)
                            {
                                itemProduct=$rootScope.cartArray[cart].quantity;
                            }
                    }
                    return itemProduct;
                }

            $scope.decreaseItemQuantity = function (product){
                let cart=0;
                for(;cart<$rootScope.cartArray.length;cart++)
                {
                    if($rootScope.cartArray[cart].id==product.id)
                        {
                            if($rootScope.cartArray[cart].quantity > 0)
                            {
                                $rootScope.cartItems = $rootScope.cartItems - 1;
                                $rootScope.cartArray[cart].quantity--;
                                $rootScope.cartArray[cart].total=$rootScope.cartArray[cart].quantity*$rootScope.cartArray[cart].price;
                                $http.put('http://localhost:3000/cartItems/'+product.id,$rootScope.cartArray[cart]);
                            }
                            if($rootScope.cartArray[cart].quantity <= 0)
                            {
                                $rootScope.cartArray[cart].quantity = 0;
                                $rootScope.cartArray.splice(cart, 1);
                                product.itemAdded = "false";
                                $http.put('http://localhost:3000/products/'+product.id,product);
                                $http.delete('http://localhost:3000/cartItems/'+product.id); 
                            }
                            if($rootScope.cartItems < 1)
                            {
                                $rootScope.cartItems = 0;
                            }
                            break;
                        }
                }
                $scope.printContent();
                
            }

            $scope.increaseItemQuantity = function (product){
                let cart=0;
                    for(;cart<$rootScope.cartArray.length;cart++)
                    {
                        if($rootScope.cartArray[cart].id==product.id)
                            {
                                $rootScope.cartItems = $rootScope.cartItems + 1;
                                $rootScope.cartArray[cart].quantity++;
                                $rootScope.cartArray[cart].total=$rootScope.cartArray[cart].quantity*$rootScope.cartArray[cart].price;
                                $http.put('http://localhost:3000/cartItems/'+product.id,$rootScope.cartArray[cart]);
                                break;
                            }
                    }
                 $scope.printContent();
                  
            }
        }
    });
