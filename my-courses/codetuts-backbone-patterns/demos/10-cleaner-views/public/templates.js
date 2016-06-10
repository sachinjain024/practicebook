this._.templateSettings.interpolate = /\{\{(.+?)\}\}/g

var Templates = {};

Templates.DocumentView = [
    "<h2>{{name}}</h2>", 
    "<ul>", 
    "<li>Lines: {{lines}}</li>", 
    "<li>Words: {{ words }}</li>", 
    "</ul>"].join('');

Templates.DocumentsView = [
    "<h1> {{length}} Documents </h1>"
].join('');

for (var temp in Templates) {
    if(Templates.hasOwnProperty(temp)) {
        Templates[temp] = this._.template(Templates[temp]);
    }
}
