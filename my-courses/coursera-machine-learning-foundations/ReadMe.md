# Machine Learning Specialization

## Installtion
- https://turi.com/download/install-graphlab-create-command-line.html

## Week1
- Optimization and Tuning of Parameters: Gradient Descent
- Prediction e.g. House Pricing: Regression
- Recommendation: Matrix factorization (Collaborative filtering)
- Classification: Logistic Regression
- SFrames vs Pandas: SFrames work on data which does not fit into memory while Pandas functions work with data only in memory
- SFrames -> Scalable Frames
- Two methods of defining functions in python
  - def isOdd(x):
     return x%2 == 1
  - isOdd = lambda x: x%2 == 1

## Week2
- Regression tools can be used for Classification as well apart from Prection
- Given an email and determining whether it is spam or not - Classification
- Problem Statement: Predicting the price of house
- Considered area of house as one parameter
- Linear Regression: Predicting the price based on single parameter
- Degree of equation is different than degree of model (Or number of parameters used to tune the model)
- Linear Regression: Line F(price) = w0 + w1x
- Linear Regression: Quadratic F(price) = w0 + w1x + w2x^2
- Model parameters = Independent variable, covariate, predictive, feature etc.
- RSS: Residual sum of squares (Sum of squares of difference between actual price and suggested price)
- We have to minimize RSS

### Overfitting
- If we use higher order polynomial (say 13th order), we can actually fit the exact and all points but that tends to overfitting
- With overfitting, we minimize RSS but we get bad predictions
- Training Error: RSS on training set
- Test Error: RSS on test data set
- As model complexity is increased, training error tends to 0 and test error first increases but increases later on.
- We should choose complexity of model carefully.

### More features
- We can add more features to our model like #bathrooms, #bedrooms etc.
- Visualize each feature as another dimension and with 2 parameters our curve will look like a hyperplane in hypercube

### Additional examples
- Stock prediction (Past history, recent news etc)
- Salary after ML specialization (performance, forumResponses, time to take course etc)
- Tweet Popularity: Predict how many retweets - Followers, Followers of followers, hashtags, number of tweets in the hashtags etc.

## Week 3
- Intelligent Restaurant Review System
- Till now, we have learnt about predicting the values given preious behavior
- Classification problem involves classifing data into certain buckets.
- Gives data a score about each bucket and then categorizing it into most favorable bucket.
- Standard examples include spam detection, object identification in images etc.

### Simple Threshold classifier
- Build a dictionary of good and bad words
- E.g. Good = [Sushi, awesome, good, great, tasty etc]
- Bad = [Terrible, bad, waste etc]
- y = Num(Good) - Num(Bad) words inside review
- If y > 0 then positive rating else negative rating

#### Problems
1. How to come up with dictionary of good and bad words
2. Words have different degree of sentiments e.g. better > good
3. Single word is not enough e.g. It would have been better if I had not visited here.

- 1,2 are solved by Linear classifier
- 3 is solved by more complex classifier

### Linear Classifier
- Assign positive and negative weights to each of the important words

    {
      good: 1,
      better: 1.1,
      great: 1.2,
      awesome: 2,
      bad: -1,
      worse: -1.2,
      terrible: -2,
      restaurant, where, we, the: 0
    }

- Use the similar approach and find out the score of the restaurant and we can have a positive or negative rating

### Decision Boundaries
- Decision boundary separates positive and negative predictions
- 2 Features: Line, 3 Features: Plane and so on..

### Measuring Error
- In classification we measure error differently than in regression.
- Error = Num of mistakes/Num of data points
- Accuracy = #CorrectPredictions/#DataPoints
- Error = 1 - Accuracy

### Good Accuracy
- With our model we should healthily beat random guessing
- With 2 choice, random guessing is like 50% accuracy on average

- False positives and false negatives have different impact in different domains
- False positive: Email is marked as spam (Higher cost)
- Confusion Matrix (True Label vs Predicted Label

### Model Bias
- Data quality is most important factor
- Test error reduces with more and more data in training set
- But it does not go to zero even with infinite data and this gap is called model bias
- Complex models tends to have lesser bias but needs more data to train

- Many models provide probabilities for belonging to certain class.
- Useful in practical situations

### GraphLab
- Calling show() on a SFrame column gives you frequency of each value in that column

    e.g. products['name'].show() // Print all product names and the number of reviews against it

## Week4: Clustering and Retrieval of articles

### Problem Statements
- How do you compare two articles and give them a similarity score ?
- How to retrieve articles of similar interest ?

### Bag of words model
- Throw all the words of the document and shuffle the bag and count each word.
- It is a vector where each index represents the index in vocabulary and the value is the frequency of the word in doc

    {
      the: 24,
      some: 5,
      football: 1,
      pelle: 2
    }

- Similarity(doc1, doc2) = Bag1(doc1) * Bag2(doc2)

#### Problems
- Biased towards doc length. Suppose doc1 and doc2 are replicated then similarity score increases a lot for same documents.
- Frequent and meaningless words contribute heavily towards similarity (e.g. a, the, that, this)
- Rare words can be missed and may be important (e.g. football)

#### Normalization
- In order to solve bias towards length, we do normalization. Divide each frequency by sqrt(sum(sq(allFrequencies)))

    Sqrt(Sum(f1^2 + f2^2 + f3^2))

#### Prioritizing Important words using TF IDF
- Important words: Frequent in a document (Common locally) but rare in the corpus (rare gloabally)
- TF-IDF: Term Frequency Inverse Document Frequency
- TF increases the weight a word based on its frequency in this document
- IDF reduces the weight of word based on its presence in other documents

    IDF = log(#docs/(1 + #docsContainingWord))

    Example: the, messi
    TF: Suppose: the comes 1000 times in this document and messi comes 5 times in this document
    IDF: Document corpus has 64 documents and 63 contains the and 3 contains Messi)

    IDF(the) = log(64/1+63) = log1 = 0
    IDF(messi) = log(64/1+3) = log16 = 4

    TFIDF = tf * idf

    tfidf(the) = 1000 * 0 = 0
    tfidf(messi) = 5 * 4 = 20

    Note: Important word got the higher weight using tfidf approach

- Nearest neighbour search approach to get recommendation about next article

### Clustering models and algorithms

- Supervised learning: When we are given a set of labels and we have to predict/classify a document for a label
- Unsupervised learning: Input is a vector of words and output is the group/clustering of documents
- In USL, we get center of cluster and shape/spread of cluster
- In order to identify which cluster a particular point belongs to:
    - Distance from center
    - Centre and shape of cluster

#### K-means clustering: Dividing your data into k clusters
1. Randomly choose k centers
2. Based on distance, assign data points to clusters
3. Change centers to nearest centers
4. Repeat until convergence

### Other examples
1. Grouping of patients by disease type
2. Grouping of areas by crime rate to better task police
3. Giving labels to users by his purchase history (Clustering and then apply all the labels to him)

### ML Block diagram
- Input: <DocumentId, DocumentText>
- Output: Estimated Cluster Label
- Quality Metric: Distance to centres
- ML Model: Clustering
- Algorithm to train model: K-means clustering
- Input to generate quality metric: TFIDF and distance to centres of previous iteration
