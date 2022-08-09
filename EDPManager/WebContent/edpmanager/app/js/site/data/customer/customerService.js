'use strict';

// Declare app level module which depends on views, and components

angular.module('data').service('CustomerService', function($http) {
	this.getCustomers = function() {
		return $http.get('./mockdata/customers.json').success(function(data) {
			return data;
		});
	}
})
