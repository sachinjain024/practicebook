// App

var APP = APP || {};

(function (APP) {

    var AppView = Backbone.View.extend({
        el: "#main",
        initialize: function () {
            this.users = new APP.User.Collection([
                { name: "Andrew", email: "andrew@gmail.com" }, 
                { name: "Paul",   email: "paul@gmail.com"   }, 
                { name: "David",  email: "david@gmail.com" }
            ]);
            this.posts = new APP.Post.Collection([
                { title: "Post 1", content: "content for post 1" },
                { title: "Post 2", content: "content for post 2" },
                { title: "Post 3", content: "content for post 3" }
            ]);
            this.render();
        },
        render: function () {
            this.$el
                .empty()
                .append(new APP.User.Views.CollectionView({ collection: this.users }).render().el)
                .append(new APP.Post.Views.CollectionView({ collection: this.posts }).render().el);
            return this;
        }
    });

    new AppView();

}(APP));
