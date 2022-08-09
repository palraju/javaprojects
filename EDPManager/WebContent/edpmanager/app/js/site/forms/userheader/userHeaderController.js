'use strict';

//Declare Top Level module for all Controllers
angular.module('content').controller('UserHeaderController', function ($scope, $rootScope, LoginService,$location,$state) {
  console.log(" I am in user Header Controller", $scope.userInfo,$state,$location);
});;

