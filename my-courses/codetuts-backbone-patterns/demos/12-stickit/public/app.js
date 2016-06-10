var Product = Backbone.Model.extend({});

var ProductView = Backbone.View.extend({
    template: _.template("<h1 id='name'></h1><p id='price'></p><%= num %>"),
    bindings: {
        '#name': { modelAttr: 'name' },
        '#price': { modelAttr: 'price' }
    },
    render: function () {
        this.el.innerHTML = this.template({ num: 10 });
        this.stickit();
        return this;
    }
});

var p = new Product({ name: "Camera", price: "$500.00" });
var pv = new ProductView({ model: p });

$("#main").append(pv.render().el);
