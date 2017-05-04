# Introduction to graphX

Link: https://www.youtube.com/watch?v=mKEn9C5bRck

- Resilient Distributed Graph
- Representaion of graph in tables
	- Vetex (Id, V): V stores the data to be stored on Vertex
  - Edges (E): Data on Edge
  - Triplets ((Id1, V1), (Id2, V2), E)

- Aggregate Neighbour Concept
  - Most of the algorithms in graphlab or graphx work on top of this
  - Use Map reduce job
  - Mapper runs on each neighbouring node
  - Reducer runs on vertex for which computation is to be done

- Calculate the age of oldest follower
  - mapper return edge.source.age
  - reducer oldestF = max(oldestF, edge.source.age)

## To further explore
- CorrectEdges api
- Semantic graphs
- Asynchronous execution
- Matrix multiplication