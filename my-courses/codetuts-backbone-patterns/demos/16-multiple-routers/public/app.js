var v = new (Backbone.View.extend({
    el: "#main",
    render: function (message) {
        this.el.innerHTML = message;
    }
}));

var r1 = new (Backbone.Router.extend({
    routes: {
        "":      "index",
        "first": "first"
    },
    index: function () {
        v.render("index");
    },
    first: function () {
        v.render("first router");
    }
}));

var r2 = new (Backbone.Router.extend({
    routes: {
        "":       "otherIndex",
        "second": "second"
    },
    otherIndex: function () {
        v.render("second router, other index");
    },
    second: function () {
        v.render("second router");
    }
}));

Backbone.history.start({ pushState: true });
