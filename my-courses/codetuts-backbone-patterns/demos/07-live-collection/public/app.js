var Tweets = Backbone.Collection.extend({
    initialize: function (models, options) {
        this.query = options.query;
    },
    url: function () {
        return "http://search.twitter.com/search.json?q=" + this.query + "&callback=?";
    },
    parse: function (response) {
        return response.results;
    },
    getTweets: function () {
        this.fetch({
        //    add: true
        });
        setTimeout(_.bind(this.getTweets, this), 10000);
    }
});

var TweetsView = Backbone.View.extend({
    tagName: "ul",
    initialize: function () {
        this.collection.on('add', this.render, this);
    },
    render: function () {
        this.collection.each(function (model) {
            var li = document.createElement('li'); 
            li.innerText = model.get('text');
            this.$el.prepend(li);
        }, this);
        return this;    
    }
});


var cats = new Tweets([], { query: "cats" });
var catsView = new TweetsView({ collection: cats });
cats.getTweets();
