var Document = Backbone.Model.extend({});

var DocumentView = Backbone.View.extend({
    template: Templates.DocumentView,
    render: function () {
        this.el.innerHTML = this.template(this.model.toJSON());
        return this;
    }
});

var doc = new Document({ name: "A Document", lines: 300, words: 9876 });

$("#main").append(new DocumentView({ model: doc }).render().el);
