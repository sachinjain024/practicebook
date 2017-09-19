# Deep learning and Neural networks

## Neural networks
- Every set of data cannot be represented by linear classifiers
- For example XOR cannot be represented linearly
- A XOR B = (A and Not B) or (Not A and B)
- Deep learning means learning features of the model
- Features of the core part of the model and it is difficult to learn them.

### Representation of OR as neural network (Single level)

    y = w0 + w1x1 + w2x2

    if y > 0 class1 else class2

    w0 = -0.5
    w1 = 1
    w2 = 1

- XOR is 2-level network
- Deep network trains itself on given dataset

## Deep learning and deep features
- Initially, image features were defined manually (also known as sift features)
- But this is very challenging
- While with deep learning, these features can be extracted
- But we need lots of data and lots of computation power to generate the features/weights at different layers

### Imagenet competition 2012
- Imagenet: Site of labelled images
- Winner used 8 layers with 60m features (SuperVision) with 0.15% error rate

### Applications
- Text analysis
- Image classification
- Image generation

### Challenges
- Need lots of data to train the intermediate layers
- Huge computation power is required
- Hard to tune the parameters

### Transfer learning
- Learn features from specific dataset and use it on other dataset
- For example: Learn features from huge dataset of cats and dogs
- N-2,3 layers learn quite generic features
- With very small dataset of newer categories you can use this trained network to classify other 100 categories

### Compology
- Company which tries to reduce the way trash is collected
- Optimizes the trucks route by looking at the amount of trash in bins
