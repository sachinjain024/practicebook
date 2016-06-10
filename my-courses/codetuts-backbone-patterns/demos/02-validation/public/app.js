var User = Backbone.Model.extend({
    defaults: {
        name: "",
        age: 0
    },
    validate: function (attrs) {
        if (attrs.age < 0) {
            return "age cannot be less than 0";
        }
        if (attrs.name === "") {
            return "name cannot be blank";
        }
    }
});
