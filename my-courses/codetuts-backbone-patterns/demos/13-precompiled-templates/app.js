var express = require('express'), http = require('http');
var app = express();

app.configure(function(){
  app.use(app.router);
  app.use(express.static(__dirname + '/public'));
});

app.get('/', function (req, res) {
    res.render('index.jade'); 
});

var compiledTemplates = null;

app.get('/templates.js', function (req, res) {
    var Templates, temp;

    if (!compiledTemplates) {
        Templates = require('./public/templates').Templates;
        compiledTemplates = "var Templates = {};\n\n";

        for (temp in Templates) {
            if (Templates.hasOwnProperty(temp)) {
                compiledTemplates += "Templates." + temp + " = " + Templates[temp].source + ";\n\n";
            }
        }
    }

    res.type("application/javascript").send(compiledTemplates); 
});

http.createServer(app).listen(3000);
