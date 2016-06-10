var express = require('express')
  , http = require('http')
  , path = require('path');

var app = express();

app.configure(function(){
    app.use(express.bodyParser());
    app.use(express.static(path.join(__dirname, 'public')));
});

app.get('/', function (req, res) {
    res.render('index.jade');
});

var people = [
    { name: "Andrew", id: 1 },
    { name: "Paul"  , id: 2 }
], id = 3;

app.get('/people', function (req, res) {
    res.json(people);
});

app.get('/people/:id', function (req, res) {
    res.json(people[req.params.id - 1]);
});

app.post('/people/new', function (req, res) {
    var person = req.body;
    person.id = id++;
    people.push(person);
    res.json(person);
});

app.post('/people/:id/update', function (req, res) {
    var person = req.body;
    people[req.params.id - 1] = person;
    res.json(person);
});

app.get('/people/:id/delete', function (req, res) {
    delete people[req.params.id - 1];
    res.json(true);
});

http.createServer(app).listen(3000);
