// Post Module

var APP = APP || {}; 

(function (APP) {
    var Post = { Views: {} };

    Post.Model = Backbone.Model.extend({});

    Post.Collection = Backbone.Collection.extend({
        model: Post.Model,
        url: '/posts'
    });

    Post.Views.ModelView = Backbone.View.extend({
        template: APP.Templates.PostModel,
        render: function () {
            this.el.innerHTML = this.template(this.model.toJSON());
            return this;
        }
    });

    Post.Views.CollectionView = Backbone.View.extend({
        template: APP.Templates.PostCollection,
        render: function () {
            this.el.innerHTML = this.template();
            this.collection.forEach(function (model) {
                this.$('ul').append(new Post.Views.ModelView({ model: model}).render().el);
            }, this);
            return this;
        }
    });

    APP.Post = Post;

}(APP));
