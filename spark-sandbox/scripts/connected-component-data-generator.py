from random import randint

outputFile = open("data/connected-component-data2.txt", 'w')

for x in range(10000):
    randomString = str(randint(1, 999)) + " " + str(randint(1, 999)) + "\n"
    outputFile.write(randomString)

outputFile.close()
