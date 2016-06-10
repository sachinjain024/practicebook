var Item = Backbone.Model.extend({
    urlRoot: '/items',
    parse: function (response) {
        return response.item;
    },
    toJSON: function () {
        return {
            item: this.attributes
        };
    }
});
