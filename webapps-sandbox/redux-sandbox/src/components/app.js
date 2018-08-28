import React, { Component } from 'react';
import BookList from '../containers/BookListContainer';

export default class App extends Component {
  render() {
    return (
      <div>
        <BookList></BookList>
      </div>
    );
  }
}
