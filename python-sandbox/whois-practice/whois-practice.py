import csv
import pythonwhois

sites_to_check = open("data.csv")
exampleReader = csv.reader(sites_to_check)
exampleReader = list(exampleReader)
outputFile = open('output.csv', 'w', newline='')
outputWriter = csv.writer(outputFile)

new_list = []

for domain in exampleReader[0:3000]:
    dict = pythonwhois.get_whois(domain[1])
    try:
        country = dict['contacts']['registrant']['country']
        temp_list = [domain[1], country]
        new_list = new_list + [temp_list]
        outputWriter.writerow(temp_list)
    except:
        pass

outputFile.close()
