var express = require('express'), http = require('http');
var app = express();

app.configure(function(){
  app.use(express.static(__dirname + '/public'));
});

var things = [
    { id: 1, text: "one" },
    { id: 2, text: "two" },
    { id: 3, text: "three" },
    { id: 4, text: "four" },
];

app.get('/', function (req, res) {
    res.render('index.jade', { things : JSON.stringify(things) }); 
});

http.createServer(app).listen(3000);
