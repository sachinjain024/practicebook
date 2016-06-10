var express = require('express')
  , http = require('http')
  , path = require('path');

var app = express();

app.configure(function(){
  app.use(express.static(path.join(__dirname, 'public')));
});

app.get('/', function (req, res) {
    res.render('index.jade');
});

app.get('/users', function (req, res) {
    //res.json([{ id: 1 } , { id: 2 }]);
    res.status(500).send("random error");
});


http.createServer(app).listen(3000);
