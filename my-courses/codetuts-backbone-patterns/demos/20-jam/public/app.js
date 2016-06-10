define(["backbone", "jquery", "underscore", "user"], function (BB, $, _, User) {
    var APP = {};
    
    APP.AppView = Backbone.View.extend({
        el: "#main",
        initialize: function () {
            this.users = new User.Collection([{ name: "Andrew" }, { name: "Paul" }, { name: "David" }]);
        },
        render: function () {
            this.el.appendChild(new User.Views.CollectionView({ collection: this.users }).render().el);
        }
    });

    return APP;
});
