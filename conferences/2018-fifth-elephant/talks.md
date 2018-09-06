26-27 July Fifth Elephant Conference, Bangalore
--------------------------------------------

## Links
- https://fifthelephant.in/2018/
- sli.do

## Salesforce (Hyd)
- Built Apache Phoenix
- Provide recommendations on customer's data

## A Study in classification (Semantics3)
- https://fifthelephant.talkfunnel.com/2018/65-a-study-in-classification
- Slides: https://goo.gl/781M2n
- Harmonized System 
	- Commodity Codes 
	- Maintained by World Custom Organizations
	- Signed by 180 countires
- Example: Kissan JAM 
	- Category1: Preparation of vegetables, fruits erc (GST = 12%)
	- Category2: Confectionary item (GST = 18%)
- State of Art: Currently category assignment is done manually by scanning bar code 
- One of the biggest challenges in solving such problems with ML classification is the availability of labelled data
- Sources for data
	- International shipping orders
	- Third party aggregators
	- Manual labelling
- Always calculate cost involved if your business goes wrong

## Improving product discovery
- https://fifthelephant.talkfunnel.com/2018/49-improving-product-discovery-via-relevance-and-rank
- Talk Overview: https://www.youtube.com/watch?v=GUVbKM26Dbc&feature=youtu.be
- Relevance and Ranking
- Pattern Mining: Computing score between two products
- Collaborative Filtering for Recommendations
- Attributes Similarity
- Visual Similarity (dedup same products from different sellers but show visual similar products)
- Weights for different attributes, visuals will be different
- Goal of recommenders
	- Engagement vs Conversions
	- Diversity + Surprise
- Ranking: Insights
	- Total Products: ~200M
	- Products Pairs Scored: ~2B (From multiple scoring engines)
- How to handle spike sale days (BBD sale)
	- Delete anamoly days 
	- Add label saleDay
- Position Bias in mobile phones
	- Right side products more browsed and clicked
- https://tech.flipkart.com/beyond-item-item-pattern-mining-recommending-collections-c9883640381b

## Role of Intuition in Data Science (Avi Patchava, InMobi)
- https://fifthelephant.talkfunnel.com/2018/81-the-power-of-intuition-in-data-science-and-why-it
- Spot Opportunities for interesting questions, does not depend upon knowledge of math
- There are people wtih both opinions. Data vs Intuition
- Book Suggestion: Sources of Power, The hour between dog and wolf
- InMobi use case: Predict if a user will interact or not
- Look at data with greate curiousity

## Entity Search on text & graph (@umasawant)
- https://fifthelephant.talkfunnel.com/2018/63-needle-in-a-haystack-entity-search-on-text-and-gra
- WebSearch is more about answers these days and not just information
- e.g. BradPitt movies -> Only movies and not other wikipedia links etc
- 28% queries seeking entities
- Existing Search Engines
	- Lack of coverage
	- Lack of robustness
- Search engines work on knowledge graphs
- Proposed solution is to infuse entities, releationships into existing knowledge graphs to get better results
- Actor (Prbhas) -- ActedIn -- Film (Bahubali) ... EntityType (EntityName) -- Releationship -- EntityType (EntityName)
- Example queries
	- Fastest ODI double century
	- Bahubali lead roles
	- Which phones have unsafe batteries
- Public Knowledge Graphs
	- WikiPedia
	- DBPedia
	- Freebase
	- Yago
	- WikiData
	- NELL
- Prop KGs
	- Google KG
	- MS Satori
	- LinkedIn profressional graph
	- facebook social graph
- Not easy to cover all KGs in one KG
- Web Text + Knowledge Graph
- Query Interpretation and break it down to entities, types etc
- CNN 
- Problem is hard to collect labelled data
- https://tagme.d4science.org/tagme/
- TagMe - Trained using wikipedia
- ClueWeb09 - WebPage Corpus
- Product, Reviews: Ecommerce KG

## Apache SOLR, lucidworks
- Spelling Autocomplete, Suggestions, Full text search
- Distributed search - Solr Cloud
