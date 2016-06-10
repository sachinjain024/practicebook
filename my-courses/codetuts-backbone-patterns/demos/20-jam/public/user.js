define(['backbone', 'underscore', 'jquery'], function (BB, _, $) {
    var User = { Views: {} };

    User.Model = Backbone.Model.extend({});

    User.Collection = Backbone.Collection.extend({
        model: User.Model,
        url: '/users'
    });

    User.Views.ModelView = Backbone.View.extend({
        tagName: "li",
        render: function () {
            this.el.innerText = this.model.get('name');
            return this;
        }
    });

    User.Views.CollectionView = Backbone.View.extend({
        tagName: "ul",
        render: function () {
            this.collection.forEach(function (model) {
                this.el.appendChild(new User.Views.ModelView({ model: model }).render().el);
            }, this);
            return this;
        }
    });

    return User;
});
