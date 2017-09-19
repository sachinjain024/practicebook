# List of Items to be analyzed further and questions

## Questions

### Week 2
- [ ] How to minimize RSS ?
- [ ] How to decide which features to use ? Am I chossing a lot more features than required ?
- [ ] In assignment Q1, how do we know the zipcode with highest average value ? 98039 ?

### Week 3
- [ ] How does Linear classifier got the words and their weights ? Who builds this ?
- [ ] Similarity between Linear classifier and linear regression ?
- [ ] Why do we need to add view = categorical in rating while not in name ?
- [ ] Filtering of products with 3 rating. Nothing gets filtered because type is float and wrong comparison is done.
- [ ] Would the result in assignments match if we have used different library like pandas instead of graphlab

### Week 4
- [ ] How to get vocabulary of all the words in Bag of words model ?
- [x] Difference between obama[['word_count']] and obama['word_count']

### Week 5
- [ ] Go to amazon.in/com and explain the different kind of recommendations it offers and how to do it.

### Prediction vs Classification vs Recommendation

#### What is difference between these terms. One problem can be stated to lie in all categories for example:
- Predict whether an email is spam or not.
- Classify an email to spam or inbox.

Prediction refers to determining a value given a set of features and trained data.
Regression can be used to determine the trend data follows and according to that trend/curve predicted value is computed.

In classification, we have only few levels of outputs/labels. While in prediction output range is continuous.
Email spam detection is a classification problem because there are only two output labels SPAM or INBOX.

In Recommendation we have two types of data and relation between them - User data and Product data and we have relation between them.

## To Explore further
- Platform where we can give an equation and variables and we can see how the curve changes when different values are changed.
- e.g. y = mx + c
- How curve changes when m and c are varied
