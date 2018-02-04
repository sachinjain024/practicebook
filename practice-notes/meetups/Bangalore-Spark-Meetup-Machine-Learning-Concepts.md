# Bangalore Spark Meetup - Machine Learning Concepts by IBM
---------------------------------------------------------

- UI for model for prediction
- Predict the rainfall in next year: Regression Problem
- Training: Process for finding a pattern

## Learning
- Supervised
	* Data is labelled
- Unsupervised: 
	* Association: User buys milk, butter. Probability of he buys jam ?
	* Clustering: Profling people, recommendations
- Reinforcement: 
	* An aagent is involved: Car is agent
	* Agent runs by trial and error
	* Self Driving Cars

## Classification
- Logistic Regression
- Random Forest
- Naive Bayes: Multi class classification
- K-means clustering

## ML Frameworks
- Scikit
- Spark ML
- XGBoost
- H2O
- TensorFlow
- R

## Problems

### Customer Churn Prediction
- Classification Problem using Logistic Regression

### Mortgagge Default Prediction
- Whether person can pay the loan back or not: Logistic regression

- When we get the feedback, retrain with actual data and feedback value

## Data Preparation
- Remove Data Duplication
- Fill NA/Null values
- 60% for train, 20% for test and 20% for evaluation
- If there is always a unique value for each row, then that particular row does not matter. Example could be - RollNo, TicketId, Name etc.

## Cross Validation
- Divide your dataset into K groups to remove bias in your model and get average over these iterations/groups
- Train with k-1 sets and test with other set
- Each row is included in test data once

- Scoring can be based on accuracy, area under curve (AUC) and similar other metrics

---------
## IBM DataScienceExeprience (DSX)
- Create your project
- Attach Spark Server
- Attach Storge
- Create a new notebook


## ToDo
- Explore Random Forest algorithm. In which type of problems this is used.
- How to encode a column with string values so that it can be used in ML algorithm ?