# JSON Load Performance in Python 2.7

## Setup

    mkvirtualenv json-performance-testing
    pip install -r requirements.txt

## Run

    python main.py

## Output

### File Sizes

```
sachinjain@sachin-gmbp json-performance-testing % du -sh *.json
4.0K    do_search_response.json
596K    f_search_response.json
1.2M    g_search_response.json
```

### 10000 Iterations - F Search API f_search_response.json

```
(json-performance-testing) sachinjain@sachin-gmbp json-performance-testing % python main.py   
json:
59.6284041405
simplejson:
19.8500010967
ujson:
25.0676109791
flask json:
19.4392149448
```

Note - Flask Internally uses SimpleJSON only.

### 10000 Iterations - G Search API g_search_response.json

```
json:
315.356371164
simplejson:
119.157536983
ujson:
136.077108145
flask json:
126.67850709
```

### 10K Iterations - DO Search API do_search_response.json

```
json:
0.532896995544
simplejson:
0.357424974442
ujson:
0.306300878525
flask json:
0.42800617218
```