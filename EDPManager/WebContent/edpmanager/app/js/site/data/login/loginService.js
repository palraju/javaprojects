'use strict';

// Declare app level module which depends on views, and components
angular.module('data').service('LoginService', function(UserInfoService) {
	this.sayHello = function(userId) {
		var userInfo = UserInfoService.getUserInfo(userId);
		return userInfo;
	};

})
