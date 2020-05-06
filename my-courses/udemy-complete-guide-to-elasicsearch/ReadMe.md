Complete Guide to Elastic Search
--------------------------------

## Setup

1. Download es package https://www.elastic.co/downloads/elasticsearch
2. Run bin/elasticsearch
3. Open http://localhost:9200

## References
- https://www.elastic.co/guide/en/elasticsearch/reference/current/index.html
- https://www.elastic.co/webinars/getting-started-elasticsearch
- https://medium.com/htc-research-engineering-blog/overview-of-elasticsearch-c388220f3e98
- https://www.youtube.com/watch?v=1EnvkPf7t6Y
- https://www.youtube.com/watch?v=UPkqFvjN-yI
- https://www.youtube.com/watch?v=oPObRc8tHgQ
- [ELK Stack Introduction](https://www.youtube.com/watch?v=MRMgd6E9AXE)

## Directory Structure
- bin
	* Executable
	* SQL Cli to run SQL queries on elastic search
- config
	* .yml file to store configs (path of data, network info, cluster name, node name etc)
	* logging config
- lib
	* All dependent libraries
- modules
	* Every functionality in ES is provided by the modules in this directory
- plugin
	* Any third party plugin