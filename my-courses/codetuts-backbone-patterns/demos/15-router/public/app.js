var v = new (Backbone.View.extend({
    el: "#main",
    render: function (message) {
        this.el.innerHTML = message;
    }
}));

/* Router Best Practices / Things to Know
 *
 * You're familiar with the basics of routes
 *
 * 1. Routes are matched in order
 * 2. Route functions can be either methods on the Router class or as events on the router instance
 * 3. Use this.route in initialize if you want to use regex
 * 2. Script tags require root slash (show when using multi-part routes)
 * 3. A default root (*other) will collect all other routes
 * 4. Sometimes they'll need resetting (talk about?)
 * 5. Server Side Route Precedence: assets > API > App 
 *
 */

var r = new (Backbone.Router.extend({
    routes: {
        "":          "index",
        "data":      "data", // doesn't work
        "users":     "allUsers",
        "users/new": "createUser",
        "users/:id": "showUser",
        "*other": "defaultRoute"
    },
    initialize: function () {
        this.route(/^pages\/(\d\d?)\/(\d\d?)/, "pages");
    },
    pages: function (start, end) {
        v.render("getting pages " + start + " to " + end);
    },
    index: function () {
        v.render("the index <a href='/data'>Data</a>");
    },
    data: function () {
        v.render("data");
    },
    allUsers: function () {
        v.render("showing all users");
    },
    showUser: function (id) {
        v.render("showing user #" + id);
    },
    createUser: function () {
        v.render("showing form for creating new user");
    },
    defaultRoute: function (route) {
        v.render(route);
    }
}));

r.on('route:showUser', function (id) {
    v.render("showing user #" + id + "; from event");
});

Backbone.history.start({ pushState: true });

r.navigate("users");
