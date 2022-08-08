d = {
    'x': 100,
    'y': 200,
    'z': 300
}

def test(a,b,c):
    print(a,b,c)

# When you flatten a dictionary with single asterisk, you get list of keys
test(*d)

# When you flatten a dict with double asterisk, we get key value pairs as flattened and we can pass the values to another method
def test2(**args):
    print(args)

test2(**d)

# When you flatten a dict with double asterisk, method expects keyword arguments and hence p,q,r are unrecognized and gives error
# def test3(p,q,r):
#     print(p,q,r)
# test3(**d)
print('Test4.....')
def test4(p=None,q=None,r=None,x=None,y=None,z=None):
    print(p,q,r,x,y,z)

test4(**d)
