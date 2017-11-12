# Machine Learning - Classification

- https://github.com/learnml/machine-learning-specialization

## Maximum likelihood estimation

In order to classify an input point, we extract features and compute the coefficients of the features. 
Based on sum of their products, we calculate the probability of input point belonging to which class.

    e.g. Sushi is awesome - everyone must try it.

Features are: #awesome, #must, #aweful etc.

Similarly, we have N input points, how do we compute weights for all the features which satisfy all input points.

We define likelihood estimation as:

    P(y1|x1,w).P(y2|x2,w)....P(yn|xn,w)
    l(w) = for i -> [1, N] ∏ P(yi | xi,w) for N data points
    
We want to choose `w` such that our likelihood is maximum.




