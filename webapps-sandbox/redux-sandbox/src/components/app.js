import React, { Component } from 'react';
import BookList from '../containers/BookListContainer';
import BookDetails from '../containers/BookDetailsContainer';

export default class App extends Component {
  render() {
    return (
      <div>
        <BookList/>
        <BookDetails/>
      </div>
    );
  }
}
