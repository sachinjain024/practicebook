var express = require('express'), http = require('http');
var app = express();

app.configure(function(){
  app.use(express.bodyParser());
  app.use(express.static(__dirname + '/public'));
});

var docs = {
        1: { text: "this is the document", id: 1 }
    },
    notes = {
        1: {
            1: { text: "this is a note", id: 1 },
            2: { text: "this is another note", id: 2 }
        }
    },
    d = 2,
    n = 2;

app.get('/', function (req, res) { res.render('index.jade'); });

app.get("/documents", function (req, res) {
    var results = [];
    for (var doc in docs) { if(docs.hasOwnProperty(doc)) {
        results.push(docs[doc]);
    }}
    res.json(results);
});

app.post('/documents', function (req, res) {
    var doc = req.body;
    doc.id = d++;
    docs[doc.id] = doc;
    res.json(doc);
});

app.put('/documents/:id', function (req, res) {
    docs[req.params.id] = req.body;
    res.json(req.body);
});

app.post('/documents/:id/notes', function (req, res) {
    var note = req.body, id = req.params.id;
    note.id = n++;
    if (!notes[id]) notes[id] = {};
    notes[id][note.id] = note;
    res.json(note);
});

app.put('/documents/:did/notes/:nid', function (req, res) {
    notes[req.params.did][req.params.nid] = req.body;
    res.json(req.body);
});

app.get('/documents/:id/notes', function (req, res) {
    var results = [], n = notes[req.params.id];
    for (var id in n) { if(n.hasOwnProperty(id)) {
        results.push(n[id]);
    }}
    res.json(results);
});

http.createServer(app).listen(3000);
