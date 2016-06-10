_.templateSettings.interpolate = /\{\{(.*?)\}\}/g;

var APP = APP || {};

(function (APP) {
    var Templates = {};

    Templates.UserModel = [
        "<h1> {{name}} </h1>",
        "<p>{{email}}</p>"
    ].join("\n");

    Templates.UserCollection = [
        "<h1> Users ({{length}}) </h1>"
    ].join("\n");

    Templates.PostModel = [
        "<h1> {{title}} </h1>",
        "<p>{{ content }}</p>"
    ].join("\n");

    Templates.PostCollection = [
        "<h1> All Posts </h1>",
        "<ul>",
        "</ul>"
    ].join("\n");

    for (var temp in Templates) {
        if (Templates.hasOwnProperty(temp)) {
            Templates[temp] = _.template(Templates[temp]);
        }
    }

    APP.Templates = Templates;
}(APP));
