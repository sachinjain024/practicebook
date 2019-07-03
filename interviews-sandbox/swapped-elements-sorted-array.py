n = int(input('Enter the num of elements in array: '))

a = []
print('Enter the input array')
for i in range(n):
    a.append(int(input('num: ')))


# Swap back the elements in their proper position
def insertion_sort_approach(a):
    for i in range(n):
        if i is 0:
            continue

        j = i

        while j > 0 and a[j-1] > a[j]:
            # Swap a[j-1] and a[j]
            tmp = a[j]
            a[j] = a[j-1]
            a[j-1] = tmp

            j -= 1

    return a


insertion_sort_approach(a)
print(a)
