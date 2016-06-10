var User = Backbone.Model.extend({});

var showUserView = Backbone.View.extend({
    template: _.template($("#showUserView").html()),
    initialize: function () {
        this.model.on('change', this.render, this);
    },
    render: function () {
        this.el.innerHTML = this.template(this.model.toJSON());
        return this;
    }
});

var editUserView = Backbone.View.extend({
    template: _.template($("#editUserView").html()),
    events: {
        "click button" : "saveChanges"
    },
    render: function () {
        this.el.innerHTML = this.template(this.model.toJSON());
        return this;
    },
    saveChanges: function () {
        this.model.set({ name: this.$("#name").val() });
        this.model.set({ twitter: this.$("#twitter").val() });
    }
});

var me = new User({ name: "Andrew", twitter: "andrew8088" });

var showUserView = new showUserView({ model: me });
var editUserView = new editUserView({ model: me });

$("#main")
    .append(showUserView.render().el)
    .append(editUserView.render().el);
