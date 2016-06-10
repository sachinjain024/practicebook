var Book = Backbone.Model.extend({ });

var Books = Backbone.Collection.extend({
    model: Book,
    /*comparator: function (a) {
        return a.get('title');
    }*/
    comparator: function (a, b) {
        if (a.get('title') === b.get('title')) {
            return a.get('year') - b.get('year');
        } else {
            return (a.get('title') < b.get('title')) ? -1 : 1;
        }
    }
});

var books = new Books();

books.add({ title: "Book B", year: 2011 });
books.add({ title: "Book C", year: 2009 });
books.add({ title: "Book A", year: 2012 });
books.add({ title: "Book B", year: 2012 });
books.add({ title: "Book C", year: 2010 });
books.add({ title: "Book A", year: 2008 });

console.log(books.pluck('title'));
console.log(books.pluck('year'));

// books.add({ title: "Book A", year: 2007 });
