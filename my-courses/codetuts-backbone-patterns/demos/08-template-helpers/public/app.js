var Person = Backbone.Model.extend({});

// Helper Function:
var PersonView = Backbone.View.extend({
    template: _.template($("#personView").html()),
    render: function () {
        this.el.innerHTML = this.template({ person: this.model.toJSON(), twitterLink: this.twitterLink });
        return this;
    },
    twitterLink: function (handle) {
        return "<a href='http://twitter.com/" + handle + "'>@" + handle + "</a>";
    }
});


// Mixin: Wrapping _.template
var template = function (templateString) {
    var templateFn = _.template(templateString);
    return function (context) {
        return templateFn(_.extend({}, template.fn, context));
    };
};
template.fn = {};
template.fn.twitter = function (handle) {
    return "<a href='http://twitter.com/" + handle + "'>@" + handle + "</a>";
}

// Partials

var People = Backbone.Collection.extend({
    model: Person
});

var PersonView = Backbone.View.extend({
    template: template($("#personView").html()),
    render: function () {
        this.el.innerHTML = this.template({ person: this.model.toJSON() });
        return this;
    }
});

var PeopleView = Backbone.View.extend({
    template: template($("#peopleView").html()),
    render: function () {
        this.el.innerHTML = this.template();
        this.collection.each(function (model) {
            this.el.appendChild(new PersonView({ model: model }).render().el);
        }, this);
        return this;
    }
});

var people = new People();

people.add({
    name: "Andrew Burgess",
    age: 22,
    twitter: "andrew8088"
});

people.add({
    name: "Jeffrey Way",
    age: null,
    twitter: "jeffrey_way"
});

var peopleView = new PeopleView({ collection: people });

$("#main").append(peopleView.render().el);
