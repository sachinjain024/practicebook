# JSON Load Performance in Python 2.7

## Setup

    mkvirtualenv json-performance-testing
    pip install -r requirements.txt

## Run

    python main.py

## Output

### 10000 Iterations

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