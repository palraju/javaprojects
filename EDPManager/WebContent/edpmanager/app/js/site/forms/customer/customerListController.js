'use strict';

// Declare Top Level module for all Controllers
angular.module('content').controller('CustomerListController', function($scope, dataTable) {
	if ($scope.customersInfo) {
		dataTable.render($scope, '', "customersList", $scope.customersInfo);
	}		
});


