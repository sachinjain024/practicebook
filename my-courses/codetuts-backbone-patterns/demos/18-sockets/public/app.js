var SOCKET = io.connect('http://localhost');

Backbone.sync = function (method, model, options) {
    var success = function (data) {
        if (options.success) options.success(data, null, null);
        model.trigger('sync', model, data, options);
    };
    
    var data;
    switch (method) {
        case "create":
        case "update":
            data = model.toJSON();
            break;
        case "read": 
        case "delete":
            data = { id: model.get('id') };
            break;
    }
    SOCKET.emit(method, data, success);
};

var User = Backbone.Model.extend({});
var Users = Backbone.Collection.extend({
    model: User,
    url: '/users'
});

var users = new Users();

users.fetch({
    success: function () {
        console.log(users.pluck('name'));
        users.create({ name: "David" }, {
            success: function () {
                console.log(users.pluck('name'));
                users.get(1).save({ age: 22 }, {
                    success: function () {
                        console.log(users.pluck('age'));
                        users.get(2).destroy({
                            success: function () {
                                console.log(users.pluck('name'));
                            }
                        });
                    }
                });
            }
        });
    }
});
