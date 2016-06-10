var express = require('express'), http = require('http');
var app = express();

app.configure(function(){
  app.use(express.bodyParser());
  app.use(express.static(__dirname + '/public'));
});

var id = 1;

app.get('/', function (req, res) {
    res.render('index.jade'); 
});

app.get('/items', function (req, res) {

});

app.post('/items', function (req, res) {
    var item = req.body;
    item.id = id++;
    res.json({ item: item, duration: 300 });
});

http.createServer(app).listen(3000);
