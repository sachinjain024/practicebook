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
- hybrid memory based system
- SSD and DRAM

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
- LSM Bteer for high perf writes
- Without schema understanding and querying of data becomes difficult
- Jepsen tests
- NFS vs HDFS
- FB Cold storage pattern
- Check deck

## Distributed Machine Learning
- pipalacademy
- porodata
- Firefly
- Grid search
- Data parallelism and Task Parallelism
- scikit allows you to parallelize but not on different computers

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

