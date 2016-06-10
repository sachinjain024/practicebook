Learn and Understand ReactJs
----------------------------

Links:
- Github: https://github.com/StephenGrider/ReactCasts
- Github: https://github.com/StephenGrider/ReactStarter
- Course: https://www.udemy.com/learn-and-understand-reactjs
- Author Email: ste.grider@gmail.com
- Github Fetch Library: github.com/github/fetch

Demos:
1. React Composition: https://plnkr.co/edit/V0Jj7Ixn2tn82GkxvTEl?p=preview
2. React Multiple JSX Templates: https://plnkr.co/edit/CeTe5Uab3hy0Hebqk5Z4
3. Rendering List: http://plnkr.co/edit/fNbrJWC1Yz97Z4O0IYeL
4. React Mixins: http://plnkr.co/edit/iSkeOYAwUXPPZw1ceqE2?p=info

- JSX Transformer convers script type=text/jsx to native JS
- React Class - compaison with Cookie Cutter. Needs instantiation and properties
- React.createClass
- React.createElement(someReactClass) and you can call render on it

Three Steps:
1. var helloWorld = React.createClass({}); // Defining a class
2. var element = React.createElement(helloWorld, {}); // Instantiaing a class with different props
3. ReactDOM.render(element, document.body);

React DOM:
- Rendering a component in actual DOM
- class attribute has to be renamed to className in JSX Template

Customizing Templates:
- Use this.props in template
- Pass an object as second argument to createELement

React Components
- We can not pass event handlers (like onClick) on React components like Badge in example below.
We can only pass it set of properties which React Class can use to define its markup. So Instead of saying onClick we should say whenClicked ot something like that.
- getInitialState is called when component is rendered first time
- We should always make changes to state by using setState method instead of directly changing values on state. Becasue React re-renders the view after state is changed.

Building a list
- Three Approaches to build a list in React
1. External List Class and external ListItem Class
2. <ul>{list}</ul> and list referes to an array of external ListItem class
3. Defining an external list and listItem is encapsulated into it.
- Depending upon use, we should use one the above approaches. But in most scenarios #2 seems to be used. 

Mixins
- A mixin is a group of methods sitting on one object but can be copied to another object
- We can specify mixins in React component by specifying: mixins as the key and array as the value
- After that we can access any mixin method say fetch like this.fetch.
- e.g. ReactFire provides bindAsObject and we access that by this.state.something later 

React is very helpful and good for reusing markup/components. However, the same is not an easy job in Handlebars templating.

Exercises:
1. Building a dropdown
- Create a button and list (bootstrap)
- Initialize state and when state is open dropdown should be open and vice-versa.
- Clicking on listItem should be updated in dropdown button
- Reopening dropdown should select the active listItem

Questions:
- Usually we have large templates written in separate files like editor.hbs. Is there a way I can separate out the JSX templates into separate files.
- Nesting of Views

var Badge = React.create({
	render: function() { }
})

var Form = React.createClass({
  render: function() {
    return <div>
      <Badge title={this.props.title} />
    </div>;
  }
})

Q: How does Form's render identify Badge tagName is the Badge class. Variable Name ? JSX Funtionality ?