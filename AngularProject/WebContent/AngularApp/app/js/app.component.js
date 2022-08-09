(function(app) {
  app.AppComponent = ng.core
    .Component({
      selector: 'my-app',
      template: '<app-header></app-header><hero-form></hero-form>',
      directives: [app.HeroFormComponent,app.HeaderComponent]
    })
    .Class({
      constructor: function() {}
    });
})(window.app || (window.app = {}));