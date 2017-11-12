# Machine Learning - Classification

- https://github.com/learnml/machine-learning-specialization
- Encoding categories into numerical features e.g. Gender, country or some other words

Implement a linear classifier end to end which takes review as input and tells if review is positive or negative

## Linear Classifiers
- Training dataset produces two vectors: Weights vector (w) and features vector (x)
- Each Input point can be written as Wt.Hx where

    Wt: Trasposed matrix of weights vector
    Hx: features of this particular input.

- Features are not always numbers so we need some mathematical expression to convert the features into numbers.
- In above example, hx is the mathematial expression which is used to convert the features into numbers. For example:

    If input is a review, then your features could be different words like awesome, aweful, good, bad etc.
    And, h(awesome) = tfidf(aweseom)

- Different features can take different h functions as well because every feature can not be weighed in similar fashion. For example,

    having aweful in review makes the review much worse than having fine in the review.

## Class Probabilities

- We define our output label based on Probability of given point.

### Conditional Probability

- What is the probability of given image as bird ? P(y = bird | Xi).
- Determining probability gives us ability to interpret/reasonging why a particular label is given to an input point.

## Logistic Regression

- In logistic regression, we map the score of our hypothesis function to probability domain.
- Probability gives us degree of sureness about certain event
- When we classify a certain input point to some class/label, assigning it a probability gives us the confidence of output
- Logistic regression is a technique to map the score to probability

    Score(xi) = w0 + w1.h(x1) + w2.h(x2) + w3.h(x3) +...
    Range(Score(xi)) = (-∞, +∞)
    Range(Prob) = [0, 1]

    Let us define a link function (prob) such that:
    score = 0 -> g(score) = 0.5
    score = +∞ -> g(score) = 1
    score = -∞ -> g(score) = 0

    g(score) = 1/(1 + e^-score)

- And we also define threshold like the

    g(score) < 0.5, y = -1
    g(score) > 0.5, y = +1 (-1, +1 are simply labels here)

- Note that for different link functions, thresholds will vary accordingly.

### Decision boundary
- In regression, we call out curve as decision boundary.
- Any point closer to decision boundary will have score near to 0 OR g(score) near to 0.5
- Any point farther from decision boundary will be much safer and carry more score

### Quality Metric
- In classifier, our quality metric is likelihood.
- More the likelyhood, more will be the better hypothesis.
- We use descendent gradient to choose the valur of weight vector

## MultiClass Classifiers

### Categorical Inputs
- Often our inputs are not numerical which we can directly use in out mathematical expressions. e.g. country, zipcode, city, gender etc.

#### One Hot encoding
- We use categorical encoding to convert these inputs into vectors. For example:

    Heading                 = [M  F] 
    Encode(Male_Person)     = [1, 0]
    Encode(Female_Person)   = [0, 1]

- This is called 1-Hot encoding where we take a vector of size equal to all possible value of the feature and all other values are 0 except 1.

#### Bag of words encoding
- We have external dictionary and we take this input and assign a vector according to that dictionary. For example

     Encode(Review) = [0, 0, 0, 4, 5, 0, 0]
     where review contains `awesome` 4 times and `fine` 5 times.

### 1 vs all technique
- This is a common technique among all possible multi class clasifiers
- Suppose you have to classify the color of ball as reg, green or blue.
- You create 3 classifiers which can identify red vs non-red, blue vs non-blue, green vs non-green
- Now when you have to classify an input point, just pass the point to all these classifiers
- Output = Max(Pred(y=red|x), Pgreen(y=green|x), Pblue(y=blue|x))
- According to maximum probability obtain, you can determine which decision boundary worked best

## Assignment Question
- 8: Are the positive words in the simple_model also positive words in the sentiment_model? (Assignment - Question 8)
