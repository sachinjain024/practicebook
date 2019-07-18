class HeapSort(object):
    def __init__(self, arr):
        self.a = arr
        self.build_heap()
        self.sort()

    def build_heap(self):
        n = len(self.a)

        for i in range(n-1, n//2, -1):
            c = i
            p = (i-1)//2

            while self.a[p] > self.a[c] and p >= 0 and c >= 0:
                tmp = self.a[p]
                self.a[p] = self.a[c]
                self.a[c] = tmp

                c = p
                p = (c-1)//2

    def heapify(self, i, n):
        c1 = 2*i + 1
        c2 = 2*i + 2

        # Handle c1 and c2 both go out of range
        if c1 > n:
            return
        # Handle c2 goes out of range
        elif c2 > n:
            min_idx = c1
        else:
            min_idx = c1 if self.a[c1] < self.a[c2] else c2

        if self.a[i] < self.a[min_idx]:
            return
        else:
            tmp = self.a[i]
            self.a[i] = self.a[min_idx]
            self.a[min_idx] = tmp

            self.heapify(min_idx, n)

    def sort(self):
        o = []
        n = len(self.a)

        for i in range(n):
            o.append(self.a[0])

            self.a[0] = self.a[n-1-i]
            self.heapify(0, n-1-i)

        self.a = o


arr = [12, 20, 40, 50, 80, -10, -20, 0]
h = HeapSort(arr)

print(h.a)
