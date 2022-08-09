'use strict';

//Declare Top Level module for all Controllers
angular.module('content').controller('CustomerController', function($scope, CustomerService, $location) {
	$scope.customerList = [];
    console.log("location", $location,$scope);
    $scope.testing = 'World';
	$scope.cancelPage = function() {
		$location.path("/customer");
	}

	$scope.addCustomer = function() {
		console.log("I am here for adding", $scope.customer);
	}

	CustomerService.getCustomers().then(function(result) {
		if (!result.data.error) {
			$scope.customerList = result.data.response;
		}
		console.log("customerList", $scope.customerList);
	});

});
