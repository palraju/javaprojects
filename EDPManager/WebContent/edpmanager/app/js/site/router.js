'use strict';
angular.module('routers', []);

//Routers
myApp.config(function($stateProvider) {
	//Login
	$stateProvider.state('login', {
		url : "/login",
		templateUrl : 'app/view/common/login.html',
		controller : 'LoginController'
	});

	//Dashboard
	$stateProvider.state('dashboard', {
		url : "/dashboard",
		templateUrl : 'app/view/dashboard/dashboard.html',
		controller : 'DashBoardController'
	});

	//Customer
	$stateProvider.state('customer', {
		url : "/customer",
		templateUrl : 'app/view/customer/customer.html',
		controller : 'CustomerController'
	});

	//Product
	$stateProvider.state('product', {
		url : "/product",
		templateUrl : 'app/view/product/product.html',
		controller : 'ProductController'
	});

	//Order
	$stateProvider.state('order', {
		url : "/order",
		templateUrl : 'app/view/order/order.html',
		controller : 'OrderController'
	});

	//Add Customer
	$stateProvider.state('addCustomer', {
		url : '/addCustomer',
		templateUrl : 'app/view/customer/addCustomer.html',
		data:{
			auth:true
		}
	});

});
