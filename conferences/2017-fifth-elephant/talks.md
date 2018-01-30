27-28 July Fifth Elephant Conference, Bangalore
--------------------------------------------

## Links
- https://fifthelephant.in/2017/

## Lessons from learning a nosql database
- Schema Agnostic Indexing (VLDB Paper)
- LSM vs BTree based data structure for persisting files
- Explore how a document is persisted
- Facebooks Unicorn

## Aerospike
- Aerospike paper (VLDB)
- Cluster formation in aerospike
- Paxos algorithm
- lockless data structures
- Secondary indexing in aerospike
- Schema Agnostic Indexing paper
- hybrid memory based system
- SSD and DRAM
- Log Structured File System
- B-trees and persistence
- Facebook unicorn

## Distributed Consensus
- Google Spanner
- Tensorflow - Based on disbelief paper (Jeff dean)
- Paxos: Implements consensus, extremely complex algorithm
- Part time Parliament - Paper
- zookeeper also uses parts of paxos
- How traditional relational dbs are CA ?
- 2 commit and 3 commit protocols
- Non locking concurrency protocols
- Why nosql can not ACID
- Synchnoized clocks
- Spanner works on Google Infra only and they have implemented sync clocks
- Cockroach db - Spanner outside Google Infra

## Which database to choose
- Regunathb, fk, adhar, curefit
- 451research.com
- State of db landscape
- Paper: How spanner is becoming a new sql system ?
- Postgres --> Cockroack db
- Vitess: Built by youtube team. Gives sql interface over nosql store
- Check adhar architecture in slides
- Curefit: Titan with Cassandra
- BerkleyDB, Espresso, Facebook TAO
- Document Stores have challenges in data storage
- B Tree is better for inplace writes
- LSM Btree for high perf writes
- Without schema understanding, querying of data becomes difficult
- Schema is not evil
- CAP is spectrum and not binary
- AP-reads and AP-writes
- Uber example
- Jepsen tests
- Data export and restore
- NFS vs HDFS
- FB Cold storage pattern
- Check deck
- Do we need a special graph db ?

## CQRS
- Read/write systems are separate
- curefit: Titan as storage backed with cassandra
- berkleydb: linked in espresso (sql)
- facebook tau - built on top of sql

## Distributed Machine Learning
- pipalacademy
- porodata
- Firefly
- Grid search
- Data parallelism and Task Parallelism
- scikit allows you to parallelize but not on different computers
- Available solutions - SparkML, Dask

## ML from dev to prod
- Semantics3 (Works in ecommerce domain)

## Interactive Visualization using Markdown
- https://fifthelephant.talkfunnel.com/2017/96-interactive-data-visualisation-using-markdown
- @amitkaps (http://amitkaps.com/talks)
- zipcode
- Color of Indian currency notes - Play animation
- GGPlot in R
- Imperative Code: Describes how each step is to be implemented
- Vega and vega-lite libraries
- visdown.com
- Highcharts

## What explains our marks (Nice talk)
- https://fifthelephant.talkfunnel.com/2017/60-what-explains-our-marks
- Gramener
- Spreadsheets are very powerful
- Pivot table
- T test (Compares average of 2 groups)
- github.com/gramener/autolysis
- gremener.com/nas
- Data analysis tools in MS Excel

## Maps love data - GeoVisualization
- mapbox @rasagy
- https://fifthelephant.talkfunnel.com/2017/94-maps-%5B%3F%5D-data-a-voyage-across-the-world-of-geo-vis
- Opacity color and size are used 
- Commerce data: US dept of commmerce
- Cartogram
- Tiles grids
- Zooming map for vancouver (3d colored map)
- Tableau, Mapbox studiom carb
- Mapboxgl, deck gl, ggmap (R)
- Slides from my previous Fifth Elephant talk on Using Data for Art: https://speakerdeck.com/rasagy/using-data-for-art
- ~400+ map visualization examples that I’ve collected: https://pinboard.in/u:rasagy/t:visualization/t:maps
- A visual collection of maps that I refer to for my projects: https://in.pinterest.com/rasagy/for-the-love-of-maps/
- Paper mentioned in the abstract: A tour through the visualization zoo: http://queue.acm.org/detail.cfm?id=1805128

## Designing ML Pipelines for transactional SMS data
- Paysense, Montane ventures
- SMS format
- How to stop other appps reading your sms ?
- FinTech apps read your sms
- Use adb to pull sms from your phone
- sklearn pipelines
- Tf-IDF
- Hashing Vectorizer
- Debit/credit/due/overdue words
- Balance/no balance - Sometimes present and sometimes not
- System/Library to apply given rules to text form (NLP) ?

## ML to guard open street map
- Gabbar, mapbox: Bhargav Koushik
- Instacart
- 2.5m per day edits
- How to avoid mistaken edits ?
- Try out map editor ?
- Edits -> Live (<10 mins)
- PokemonGo used open street maps for spawning pokemons
- Traditional validation - community approves nearby edits
- OSM cha - review things
- Can a system be designed - community of users using blockchian ?
- Rule based validation
- osm-compare github.com/mapbox
- gabbar: mllib in python + js
- jupyter heavily used
- gabbar submits its preditctions to osmcha to be reviewed by other users
- Python data science handbook

## 5 Lessons - Learning Product Matching
- semantics3
- @govind2c
- How do you get data / scrape ?
- Build a good dataset
	- Matches
	- NonMatches (Similar but not same e.g. iphone 6, iphone 7)
- Same background color, same website
- Identification of criminals from faces (paper)
- Model -> 90% correct
- One model to rule them all
- Bias towards younger people
- Spending time on your dataset can be rewarding
- Text: Diff vector space
- MultiModel deep learning paper
- ML as service offering
- Inference needs to be involved
- Apple Iphone7 on flipkart and Iphone 7 on amazon
	- We can inference to say that they are same products similarly machines need to infer such things
- Algorithmic APIs are non-deterministric
- govindc.com

## Image Matching
- Dataweave, Kumar Shubham
- Solr: How does it perform text search ? (Read paper)
- Evernote: How does it sync ?
- CoTraining approach
- Semantic Hash
- Preprocessing before hashing/generating
- Local sensitivity hashing
- Kernel sensitivity hashing

