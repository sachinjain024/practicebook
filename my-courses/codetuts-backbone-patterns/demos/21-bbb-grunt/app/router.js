define([
  // Application.
  "app",
  // Modules
  "modules/User"
],

function(app, User) {

  // Defining the application router, you can attach sub routers here.
  var Router = Backbone.Router.extend({
    routes: {
      "": "index"
    },

    index: function() {
        users = new User.Collection();

        app.useLayout("main").setViews({
            "#form": new User.Views.FormView({ collection: users }),
            "#users": new User.Views.CollectionView({ collection: users })
        });
    }
  });

  return Router;

});
