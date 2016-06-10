var express = require('express'), http = require('http');
var app = express();

app.configure(function(){
  app.use(express.static(__dirname + '/public'));
});

app.get('/', function (req, res) {
    res.render('index.jade'); 
});

http.createServer(app).listen(3000);
