var UserTracker = new Backbone.Marionette.Application();

UserTracker.addRegions({
    form: '#form',
    list: '#list'
});

var User = Backbone.Model.extend({});
var Users = Backbone.Collection.extend({ 
    model: User 
});

var UserView = Backbone.Marionette.ItemView.extend({
    template: '#userView' 
});

var NoUserView = Backbone.Marionette.ItemView.extend({ 
    template: '#noUsersView'
});

var UsersView = Backbone.Marionette.CollectionView.extend({ 
    itemView: UserView,
    emptyView: NoUserView
});

var FormView = Backbone.Marionette.ItemView.extend({ 
    template: '#formView',
    events: {
        'click button': 'createNewUser'
    },
    ui: {
        name: "#name",
        age : "#age"
    },
    createNewUser: function () {
        this.collection.add({
            name: this.ui.name.val(),
            age: this.ui.age.val()
        });
        this.ui.name.val("");
        this.ui.age.val("");
    }

});

UserTracker.addInitializer(function (options) {
    UserTracker.users = new Users();

    UserTracker.form.show(new  FormView({ collection: UserTracker.users }));
    UserTracker.list.show(new UsersView({ collection: UserTracker.users }));

});

UserTracker.start();
