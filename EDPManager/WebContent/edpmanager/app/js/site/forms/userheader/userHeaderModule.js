angular.module('form').directive('userHeaderInfo', function() {
  return {
    restrict: 'E',
    scope: {
      userInfo: '=info',
      state: '=state'
    },
    templateUrl: './app/js/site/forms/userheader/tpl/userHeader.tpl.html',
    controller: 'UserHeaderController'
  };
});