// User Module

var APP = APP || {};

(function (APP) {
    var User = { Views: {} };

    User.Model = Backbone.Model.extend({});

    User.Collection = Backbone.Collection.extend({
        model: User.Model,
        url: '/users'
    });

    User.Views.ModelView = Backbone.View.extend({
        template: APP.Templates.UserModel,
        render: function () {
            this.el.innerHTML = this.template(this.model.toJSON());
            return this;
        }
    });

    User.Views.CollectionView = Backbone.View.extend({
        template: APP.Templates.UserCollection,
        render: function () {
            this.el.innerHTML = this.template({ length: this.collection.length });
            this.collection.forEach(function (model) {
                this.el.appendChild(new User.Views.ModelView({ model: model}).render().el);
            }, this);
            return this;
        }
    });

    APP.User = User;

}(APP));
