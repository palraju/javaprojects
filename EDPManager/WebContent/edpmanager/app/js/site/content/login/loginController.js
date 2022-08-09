'use strict';

//Declare Top Level module for all Controllers
angular.module('content').controller('LoginController', function ($scope, $rootScope, LoginService,$location) {
 $scope.sayHello = function () {
     var sayHello = LoginService.sayHello();
     console.log('sayHello',sayHello);
 }
 
 $scope.login = {"email":"mail.rajupal@gmail.com", "password": "mypassword"};
 $scope.sayHello();
 $scope.doLogin = function() {
	 	console.log("Hello");
	 	var data = {};
	 	data.firstName = "Raju";
	 	data.lastName = "Pal";
	 	data.email = "mail.rajupal@gmail.com";
	 	console.log("data", data);
		if ($scope.loginForm.$valid) {	
			 window.sessionStorage["userInfo"] = JSON.stringify(data);
			 $rootScope.userInfo = JSON.parse(window.sessionStorage["userInfo"]);
			 $location.path("/dashboard");				
		}
	};
});;

