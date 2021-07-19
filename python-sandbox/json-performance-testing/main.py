# Python version 2.7

import timeit

import json
import simplejson
import ujson
from flask import json as flask_json


def load_json(f):
    return json.load(f)


def load_simplejson(f):
    return simplejson.load(f)


def load_ujson(f):
    return ujson.load(f)


def load_flask_json(f):
    return flask_json.load(f)


# file_name = 'f_search_response.json'
# file_name = 'g_search_response.json'
file_name = 'do_search_response.json'

print("Performance Testing with file {file_name}".format(file_name=file_name))
print("json:")
print(timeit.Timer('load_json(open(file_name))', 'from __main__ import load_json,file_name').timeit(10000))

print "simplejson:"
print timeit.Timer('load_simplejson(open(file_name))', 'from __main__ import load_simplejson,file_name').timeit(10000)

print "ujson:"
print timeit.Timer('load_ujson(open(file_name))', 'from __main__ import load_ujson,file_name').timeit(10000)

print "flask json:"
print timeit.Timer('load_flask_json(open(file_name))', 'from __main__ import load_flask_json,file_name').timeit(10000)
