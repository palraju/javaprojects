(function(app) {
  app.HeaderComponent = ng.core
    .Component({
      selector: 'app-header',
      templateUrl: 'app/js/site/form/header/template/header.tpl.html'
    })
    .Class({
      constructor: function() {
       console.log("Hello World");
      }
    });
 })(window.app || (window.app = {}));