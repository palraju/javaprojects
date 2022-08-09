angular.module('form').directive('customerList', function() {
  return {
    restrict: 'E',
    scope: {
      customersInfo: '=info'
    },
    templateUrl: './app/js/site/forms/customer/tpl/customerList.tpl.html',
    controller: 'CustomerListController'
  };
});