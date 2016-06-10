var User = Backbone.Model.extend({
    defaults: {
        name: "",
        age: 0
    },
    validate: function (attrs) {
        if (attrs.age < 0) {
            return "age cannot be less than 0";
        }
        if (attrs.name === "") {
            return "name cannot be blank";
        }
    }
});

var u = new User();
/*
u.on('error', function (model, error) {
    console.log(error);
});

u.set({ name: '' });
u.set({ age: -2 });
*/

var Users = Backbone.Collection.extend({
    model: User,
    url: '/users'
});


var users = new Users();
/*
users.fetch({ 
    success: function (collection, response) {
        console.log("fetched from server");
    }
});*/

users.on('reset', function (collection, response) {
    console.log("fetched from server");
});

users.on('error', function (collection, response) {
    console.log(response.responseText);
});

//users.fetch();


/**********************************
 * Available Events
 *
 * For Collections
 * - add
 * - remove
 * - reset
 * - error
 *
 * For Models
 * - change[:<attr>]
 * - sync (after server confirms save and destroy)
 * - destroy (when model.destroy())
 * - error
 *
 * Custom
 * - trigger("name", data, data)
*/
