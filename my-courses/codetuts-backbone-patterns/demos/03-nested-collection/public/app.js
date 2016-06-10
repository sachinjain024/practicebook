var Document = Backbone.Model.extend({
    initialize: function () {
        this.notes = new Notes([], { doc: this });
    },
    addNote: function (test) {
        this.notes.create({ text: test });
    }
});

var Documents = Backbone.Collection.extend({
    model: Document,
    url: "/documents",
    initialize: function () {
        this.on('reset', this.getNotes, this);
    },
    getNotes: function (collection) {
        collection.forEach(function (model) {
            model.notes = new Notes([], { doc: model});
            model.notes.fetch();
        });
    }
});

var Note = Backbone.Model.extend({ });

var Notes = Backbone.Collection.extend({
    model: Note,
    initialize: function (models, options) {
        this.doc = options.doc;
        this.on('reset', this.showNotes, this);
    },
    url: function () {
        return this.doc.url() + "/notes";
    }
});

ds = new Documents();
