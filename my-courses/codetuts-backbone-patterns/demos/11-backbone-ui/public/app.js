var Person = Backbone.Model.extend({}),
    People = Backbone.Collection.extend({});

var Genders = new Backbone.Collection([{ name: "Female", id: 1 }, { name: "Male", id: 0 }]);

var people = new People();

// name: Textbox
// birthday: Date Picker
// gender: Radio Group
// married: checkbox

people.add({ name: "John Doe", gender: Genders.get(0), birthday: new Date(1990, 5, 15), married: false });
people.add({ name: "Jane Smith", gender: Genders.get(1), birthday: new Date(1985, 10, 10), married: true });
people.add({ name: "Tom Smith", gender: Genders.get(0), birthday: new Date(1980, 1, 20), married: true });
people.add({ name: "Sally Fox", gender: Genders.get(1), birthday: new Date(1998, 7, 31), married: false });

var sally = people.models[3];

var table = new Backbone.UI.TableView({
    model: people,
    columns: [
        { title: "Name", content: 'name' },
        { title: "Gender", content: "gender", output: function (val) { return val.get('name'); } },
        { title: "Birthday", content: "birthday", output: function (val) { return val.toString(); } },
        { title: "Married", content: "married", output: function (val) { return val ? "yes" : "no"; }  }
    ]
});

var textbox = new Backbone.UI.TextField({
    model: sally,
    content: 'name'
});

var calendar = new Backbone.UI.Calendar({
    model: sally,
    content: 'birthday'
});

var radios = new Backbone.UI.RadioGroup({
    model: sally,
    content: 'gender',
    alternatives: Genders,
    altLabelContent: 'name'
});

var checkbox = new Backbone.UI.Checkbox({
    model: sally,
    content: 'married',
    labelContent: 'married'
});

var AppView = Backbone.View.extend({
    el: "#main",
    render: function () {
        this.$el.append(table.render().el);
        this.$el.append(textbox.render().el);
        this.$el.append(calendar.render().el);
        this.$el.append(radios.render().el);
        this.$el.append(checkbox.render().el);
    }
});

new AppView().render()
