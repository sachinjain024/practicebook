var Document = Backbone.Model.extend({});
var Documents = Backbone.Collection.extend({
    model: Document
});

var DocumentView = Backbone.View.extend({
    template: Templates.DocumentView,
    render: function () {
        this.el.innerHTML = this.template(this.model.toJSON());
        return this;
    }
});

var DocumentsView = Backbone.View.extend({
    templates: Templates.DocumetnView,
    render: function () {
        this.el.innerHTML = this.template({ length : this.collection.length });
        this.collection.forEach(function (model) {
            this.el.appendChild( new DocumentView({ model: model }).render().el);
        });
        return this;
    }
});


var doc = new Document({ name: "A Document", lines: 300, words: 9876 });

$("#main").append(new DocumentView({ model: doc }).render().el);
