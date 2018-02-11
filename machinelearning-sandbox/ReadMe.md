# Machine Learning Notes
------------------------

## Bias-Variance TradeOff
- Bias and Variance are two terms referred for telling the degree of underfit and overfit of a model
- If the model learns too less from training data, it is called underfit and highly biased towards training set
- If the model learns too well from training data, it is called overfit and has high variance with actual curve
- These two sources error must be minimized
- Bagging algorithms control only variance
- Boosting algorithms controls both bias as well as variance

## Decision Trees
- Can be used for regression problem (Remember kaggle house prediction problem)
- We define certain boundaries in the training data set and kinda form clusters 
- Each cluster/group gets a score ~ average of the scrore of each indivual point
- Now for test data point, we check the boundaries and based on that we reach some group defined above
- We don't need to convert categorical inputs to numerical inputs for decision trees

## Random Forests
- We create N decision trees and run the test data point on each decicion tree
- Then take the average of the score given by each decision tree

## Gradient Boosting
- Boosting is a method of parameter tuning of the model while controlling bias and variance

## HyperParameters
- Parameters that are not learned

## K-Fold Cross Validation
- Helps in model selection.

## XGBoost
- High Performance parameter tuning
- Implementation of Gradient descent with high performance and high execution speed
- High Performance means parameter tuned with XGBoost does not loose the accuracy
- Fast execution means implementation is such that it runs very fast
