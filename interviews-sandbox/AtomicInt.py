import threading


class AtomicInt(object):
    def __init__(self, value=0):
        self._value = value
        self._lock = threading.Lock()

    def add(self, v):
        with self._lock:
            self._value += v
            return self

    def sub(self, v):
        with self._lock:
            self._value -= v
            return self

    def get(self):
        return self._value

    def set(self, v):
        with self._lock:
            self._value = v
            return self


x = AtomicInt(100)

# Run in two threads
threads = [(threading.Thread(target=x.set, args=(10*(i+1),))) for i in range(2)]
for t in threads:
    t.start()

for t in threads:
    t.join()

print('Complete')
print(x.get())
