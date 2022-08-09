'use strict';

// Declare app level module which depends on views, and components

angular.module('data').service('UserInfoService', function() {
	this.getUserInfo = function(userId) {
		return 'Raju'
	};
})
