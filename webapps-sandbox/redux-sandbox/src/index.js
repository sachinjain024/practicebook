import React, {Component} from 'react';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux';
import { createStore, applyMiddleware } from 'redux';
import { BrowserRouter , Route} from 'react-router-dom';

import BooksApp from './components/BooksApp';
import reducers from './reducers';

const createStoreWithMiddleware = applyMiddleware()(createStore);

class RoutesIndex extends Component {
  render() {
    return (
      <div>
        Here is a list of existing routes
        <ul>
          <li>
            <a href="/booksApp">Books App</a>
          </li>
          <li>
            <a href="/postsApp">Posts App</a>
          </li>
        </ul>
      </div>
    );
  }
}

class PostsApp extends Component {
  render() {
    return <div>PostApp will be rendered here</div>
  }
}

ReactDOM.render(
  <Provider store={createStoreWithMiddleware(reducers)}>
    <BrowserRouter>
      <div>
        <Route exact path="/" component={RoutesIndex} />
        <Route path="/booksApp" component={BooksApp} />
        <Route path="/postsApp" component={PostsApp} />
      </div>
    </BrowserRouter>
  </Provider>,
  document.querySelector('.container')
);
