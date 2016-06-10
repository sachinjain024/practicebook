define([
  // Application.
  "app"
],

// Map dependencies from above array.
function(app) {

  // Create a new module.
  var User = app.module();

  // Default model.
  User.Model = Backbone.Model.extend({
  
  });

  // Default collection.
  User.Collection = Backbone.Collection.extend({
    model: User.Model,
    url: '/users'
  });

  User.Views.ModelView = Backbone.View.extend({
    tagName: 'li',
    template: 'users/model',
    serialize: function () { 
        return this.model.toJSON();
    }
  });

  User.Views.CollectionView = Backbone.View.extend({
    tagName: 'ul',
    initialize: function () {
        this.collection.on('reset', this.render, this);
        this.collection.on('add', function (model) {
            this.insertView(new User.Views.ModelView({ model: model })).render();
        }, this);
    },
    render: function (manage) {
        this.collection.forEach(function (model) {
            this.insertView(new User.Views.ModelView({ model: model })).render();
        }, this);
        return manage(this).render();
    }
  });

  User.Views.FormView = Backbone.View.extend({
    template: 'users/form',
    events: {
        'click button': 'add'
    },
    add: function () {
        var name = this.$("#name");
        this.collection.add({
            name: name.val()
        });
        name.val("");
    }
  });

  // Return the module for AMD compliance.
  return User;

});
