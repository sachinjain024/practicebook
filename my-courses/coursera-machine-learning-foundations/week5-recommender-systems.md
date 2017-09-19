# Week5 - Recommender Systems

## Applications and simple recommender systems
- Amazon product recommendations
- Movie recommendations
- Youtube personalization
- Medicine recommendation

### Model1 - Popularity
- Suggest items based on the popularity rank of the item in the store
- e.g. Suggest the articels what everyone is reading/liking on nytimes
- But it lacks personalization

### Model2 - Classification
- Take features such as product features, user purchase history, user information like age etc and put into classifier
- Works well and personalization is also achieved
- But features may not be available for all users and all products
- Collaborative filtering works more better in such situations

### People who bought this also bought that
- We build a Cooccurence matrix
- Simple example: When user purchases baby diapers, he sometimes also purchase baby wipes
- C Matrix is Items X Items matrix where c[i][j] represents the number of people who purchase both item i and item j
- When an item is purchased, simply update this matrix using his purchase history
- This is a symmetric matrix across the diagonal
- When we need to recommend something to user, just search his recent puchase, look for that item in C matrix, sort it and recommend the items

#### Problem with this approach
- What is there is a very popular item like diapers which has very high count
- This approach tends more towards popularity than personalization so we need to normalize this effect

#### Normalization
- Very similar to what we did with popular words in text classification
- We used tf-idf to normalize the popular words and important words
- We use jaccard similarity here

    JC = user purchased i and j / user purchased i or j

#### Limitations
- This approach takes only current page into picture. Users who bought this also bought these items. But "this" is known here.
- What if we want to use this to suggest recommendations to a user and we do not know "this item"
- We may need to check his browsing history, calculate weighted average of each product w.r.t other items and recommend a product from it.
- Still this approach does not consider
    1. Context (Time of day, event etc)
    2. User Info
    3. Product features
- Cold start problem: Recommendations to new users

### Solution3: Matrix Factorization
- Predict user ratings for movies he has not watched yet i.e. Given some user,movie ratings predict the ratings for other movies
- We have a sparse matrix M(i,j) = X which represents user i gave X rating to movie j
- Now, we generate two matrix R and L such R.L = M
- We use RSS to generate model parameters R and L are model parameters here
- We have certain data points and rest of the points need to be predicted like regression model
- There are efficient algorithms for matrix factorization
- This model also can't handle cold start problem

#### Blending of models
- In netflix competition, winner blended over 100 models
- To solve cold start problem, we can begin with some user features like age and generate product, user features
- Once we have more information about user, we can add more information and provide better recommendation

### Measuring prection/recommendation
- Recall and Precision are good values to measure the predicted values when classes are highly imbalanced
- Precison is a measure of result relevancy
- Recall is a measure of number of relevant results that are returned

    Precision = (liked & shown)/shown
    Recall = (liked & shown)/liked

- One recommender: Recommend everything but we can show only X (say 10)

    Precision will be low and recall is also low. (Bad recommender)

- Optimal recommender: Show only those are liked

    Precision = 1
    Recall = 1

#### How to calculate which algorithm works better in preciting items to be recommended ?
- Area under precision recall curve
- Threshold is number of items recommended
- As we increase threshold in optimal recommender, recall increases while precision = 1
- Practical recommenders follow different curves

