var express = require('express')
  , http = require('http')
  , path = require('path');

var app = express();

app.configure(function(){
  //app.use(app.router);
  app.use(express.static(path.join(__dirname, 'public')));
});

app.get("/data", function (req, res) {
    res.json({ "test": "testing" });
});

app.get('/*', function (req, res) {
    res.render('index.jade');
});

http.createServer(app).listen(3000);
