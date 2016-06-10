(function (exports) {
    "use strict";

    if (typeof require === 'function') {
        this._ = require('./underscore-min');
    }

    this._.templateSettings.interpolate = /\{\{(.+?)\}\}/g;

    var Templates = {};

    Templates.DocumentView = [
        "<h1>{{name}}</h1>", 
        "<ul>", 
        "<li>Lines: {{lines}}</li>", 
        "<li>Words: {{ words }}</li>", 
        "</ul>"].join('');

    for (var temp in Templates) {
        if(Templates.hasOwnProperty(temp)) {
            Templates[temp] = this._.template(Templates[temp]);
        }
    }

    exports.Templates = Templates;

}).call(this, typeof window === 'undefined' ? exports : window);
