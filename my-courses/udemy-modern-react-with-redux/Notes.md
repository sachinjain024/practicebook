Notes
-----

## Introduction to React
- Functional Component
- Class Based Component

## Youtube Layout Example
- React follows downward data flow principle. This means the top most component should fetch the data and pass it to other components
- ES6 import convention

    import React, {Component} from 'react'

    is equivalent to

    import React from 'react'
    const Component = React.Component

- When we define class based component, we have to define constructor and call super as the first line

    class A extends Component {
    	constructor(props) {
   			super(props);

   			// Fetch all other data here and set state
    	}
    	render() {
    		return <div>sfdsa</div>
    	}
	}
- We use className in jsx which translates to class otherwise there will be conflict
- Parent component can pass data to child component via props

    <StudentsList items={this.state.studentsList}></StudentsList>

- We have to specify `key` in list items so that it can uniquely identify the list item
- ES6 convention

    const A = ({a,b}) => {
    	...
	}

	is equivalent to 

	const A = (props) => {
		const a = props.a
		const b = props.b

	}

- Suppose a child has to tell the parent on what to do for a paritcular event, this is implemented by passing callback as prop from parent all the way to child.

## Redux

- https://github.com/sachinjain024/ReduxSimpleStarter
- reduxjs.org
- Predicatable state container for JS applications
- Centralized Single JS Object containing application state
- In react, we looked at component level state. With redux we manage application level state
- Redux is different from backbone as backbone maintains kinda component level state via collections and models and In redux we manage application level state.

### Counter Example
- State: Current Count
- Views: Current Number, Increment and Decrement Operations View

### Tinder Example
- Views
	- Image View (Image of user to be reviewed)
	- Operations View (Like or Dislike)
	- ChatItemView
	- ChatsView
	- UsersInteractedListView
	- UsersInteractedItemView
- State
	- List of users to be reviewd
	- Current User
	- List of users interacted recently
	- Chats with current selected users

### Book Application to build
- Views
	- BookList
	- Currently Reading Book
- State
	- List of Books
	- Currently Reading Book

### Reducers
- Returns piece of application state
- react-redux library connects redux and react
- Components -> Containers when they use redux
- An application state can have multiple pieces for example bookList, currentBook etc
- So we create one reducer each for piece of app state
- We try to create container at the most parent level which deals with redux
- Not necessarily app component becomes container. If it needs to interact with reducer only then it becomes container otherwise not
- In container, we implement a method to mapStateToProps and it returns an object which becomes props for this component/container
- And we export connect(mapStateToProps)(class) e.g. export default connect(map...)(BookList) inside BookList container
- Container re-renders itself whenever state is changed.

### Actions & ActionCreators
- Action creators can be called by direct user action like click, hover, dropdown selection etc and indirectly like page load, ajax call complete etc.
- Action creators produce actions
- Actions are consumed by reducers and update state based on the actions
- In redux, an action is sent to every reducer and it's upto reducers which can update it's state based on the action
- Whenever peice of state (reducer state) is changed, corresponding component re-renders itself
- It is acutally similar to Backbone View -> Model binding. User action on views updates the model and when model is changed, view is re-rendered.
- Just like we connect reducer using react-redux, we connect action creators using redux library
- Every reducer gets two args (state, action). Based on action, reducer can update the state and return new state object.
