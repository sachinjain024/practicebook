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
    l(w) = π P(yi | xi,w) where i ≤ N for N data points
    
We want to choose `w` such that our likelihood is maximum.

## Gradient Ascent algorithm

- We can use gradient ascent algorithm to find the optimum value of w

    w(t+1) = w(t) + µ(∆l/∂w)
    where
        t = iteration number
        µ = step size
        ∆l/∂w = [∂l/∂w0 + ∂l/∂w1 + .... + ∂l/∂wD] D+1 size matrix
        
### How to compute partial derivative of l(w)

Derivative of log-likelihood

    ∂l(w)/∂wj = i∑hj(xi) (I[yi = +1] - P(y = +1 | xi, w))
    where
    hjxi: Feature value. wj is the jth weight for this feature from weight vector.
            e.g. hj(xi) can be #awesome in ith point. We weigh the diff in actual and prediction by the coefficient.
    I[yi = +1]: Indicator function. (Actual result) I = 1 when yi = +1 and I = 0 when yi = -1
    P(y = +1 | xi, w): Predicted value for y being +1
    
Different in I and P - Difference in actual and prediction and how much we should weigh it.
If the prediction and actual are same, then weight for jth feature should not contribute much 
and slope should not change much in this direction.

We use gradient ascent in this problem because we wanted to maximize the likelihood so this is hill clilmbing problem
While in regression we wanted to reduce the error so there we used gradient descent algorithm and that was hill downclimb problem.
     
### Choosing step size (µ)
- This is hill climbing problem (Gradient ascent) so imagine if a person is supposed to climb the hill
- When his step size is very small, it would take him long time to reach to the top
- When his step size is too large, he may oscillate, cross the top and go the lower part in other direction but will eventually converge
- But again very large step size may take long time
- We have to use hit and try mechanism
- Start with an approx value like 10^-5 or so and see the performance with 10^-6 and 10^-4
- Which range has better value of log likelihood
- Accordingly you can move in the direction whether you want to increase the value of your guess or find better value in the range.
- Advance step: Decrease the step size with number of iterations (µ = µ/t where t is iteration number)