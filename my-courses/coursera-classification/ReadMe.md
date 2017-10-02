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

