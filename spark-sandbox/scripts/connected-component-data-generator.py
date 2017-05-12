from random import randint

outputFile = open("../data/connected-component-data2.txt", 'w')

for x in range(50000):
    randomString = str(randint(0, 99)) + " " + str(randint(0, 99)) + "\n"
    outputFile.write(randomString)

outputFile.close()
