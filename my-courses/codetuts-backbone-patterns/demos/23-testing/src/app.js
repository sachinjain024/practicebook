var Book = Backbone.Model.extend({
    urlRoot: '/books'
});

var Books = Backbone.Collection.extend({
    model: Book,
    url: '/books',
    comparator: function (a, b) {
        var year = a.get('year') - b.get('year');
        if (year === 0 ) {
            return a.get('title') < b.get('title') ? -1 : 1;
        }
        return year;
    }
});

var BookView = Backbone.View.extend({
    template: _.template("<p><%= title %></p>"),
    render: function () {
        this.el.innerHTML = this.template(this.model.toJSON());
        return this;
    }
});

var BooksView = Backbone.View.extend({
    template: _.template("<h1> <%= count %> Books </h1><ul></ul>"),
    initialize: function () {
        this.collection.on('add', this.render, this);
    },
    render: function () {
        this.el.innerHTML = this.template({ count: this.collection.length });
        var ul = this.$('ul');
        this.collection.forEach(function (model) {
            ul.append(new BookView({ model: model }).render().el);
        });
        return this;
    }
});

