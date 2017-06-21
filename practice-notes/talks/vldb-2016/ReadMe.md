Day 1
-----

## Digital India
- How India is growing from data poor to data rich
- Adhar is central id of every user
- Based on biometric and no intelligence
- data.gov.in
- Open authentication like if adhar belongs to some user
- Digital Locker
- Scope of machine learnig will be very high because the availability of data will be very high

### Delhivery
- Last mile problem
- Address fix issue
- Machine learning based solution to solve the address issue
- Benefit of 114 Km to 67 Km and savings of roughly 2 hours
- Multiple problems in how people write addresses
  - Spelling
  - Wrong pin code
  - Landmarks which does not exists on map

### Eko
- Platform to bring cash earning users to wallets
- Multiple outlets to convert to cash
- Retailers buy prepaid vouchers
- Abhinav

### UPI
- Universal Payment Interface

## Main Memory DBMS
- Different Indexing techniques
- Paul Larson
- Efficient Paging 

## Enabling Real Time Business Intelligence
- Stone brooks
- NoSql -> SQL -> Nosql
- Hybrid Transactional Analytic Processing
- New System: Hybrid of OLTP and OLAP
- By C Mohan
- IBM Research

# Day 2
-------

## Keynote by Ion stoica
- Challenges with upcoming hardware
- How to scale software to be used with new generations hardware
- Moore law (Intel slowed this down)
- Code to be run on cpu, gpu, fpga, asic etc.
- L1, L2, L3 cache ?

## Flipkart data infstrastructure
- Developing a data platform
- Product management defined schemas
- Convert data into standard schemas
- Run algos and do analysis on them
- Link: http://www.slideshare.net/sharad_ag/data-infrastructure-at-flipkart-vldb-2016/sharad_ag/data-infrastructure-at-flipkart-vldb-2016

## Review Generator
- Prof. Gautam Das, University of Texas Arlington
- Input: Product with a set of attributes like Mobile phone with battery, cpu, cores, memory etc.
- User dont want to write reviews
- Given user contentment and couple of other input parameters we can map these to positive and negative attributes using ML classifiers
- Automatic review generation
- For example: contentment: 0.75, K-factor: 0.2 generates Awesome battery power, good camera
- User just needs to provide very minimzed input and rest of the work is done by machine

## Level Graph
- Open Source library written in JS
- Stores all permutations of subject, object, predicate
- Open map data
- Chrome Indexed DB
- Matteo collina Github profile (Node committer)

## Efficient Non-Equi joins
- Find out number of persons who have more salary but pay less tax e.g. a.salary > b.salary and a.tax < b.tax
- Such people may be doing some fraud in taxes 
- Take a bit array
- Sort tha table with salary and tax (2 copies)
- Start with salary table and find its index in tax table and record the index in bit array

### Bit Array Base solution
- When we record the index in bit array and if there is 1 right to any bit to current index then that particular index should come in result

    T1              T2
    Salary Tax      Tax Salary
    100     10      7   120
    120     7       10  100
    140     15      15  140

    Bit Array: 0 0 0

- When we process record (100, 10) its index in T2 is 1, Bit Array: 0 1 0
- T1(120, 7) Index in T2 is 0 when we try to update bit array and check all the bits right to it, we set those records against this paritcular record in the result

### MapR
- mapr academy has good courses on spark, hbase etc
- Complete sandbox of hadoop stack
- Customers like walmart, yahoo etc
- MapR certifications
- Self owned database etc

# Day 3
-------

## KeyNote by Anand Rajaraman
- rocketship.vc
- Private data, public data, 4g data etc
- Paysa: Predict your salary as per your skill set
- Cuberon: Startup for Anamoly explanation. Why is there a hike or drop in normal data curve ?
- Teradata
- Innovators dilemma: Book/Paper
- Descartes labs: Startup to predict amount of crop this season based on weather predictions etc.
- Unicorn: Startup which has passed all series of funding
- Lifecycle of startup
- Crunchbase, Angellist have lot of data about individuals, skills and how much to pay and how much people are getting paid
- Amazon Mechanical Turk
- Cyborg: Central place for having all data for single person fb, amazon, google data and generate intelligent decisions
- Marketing Myopic: Research paper
- datawocky gmail
- Data science ethics mooc by Prof HV Jagdish on edx
