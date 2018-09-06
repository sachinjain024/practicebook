import React, {Component} from 'react';
import {connect} from 'react-redux';

import { selectBookAction } from '../actions/BookSelectionAction';
import { bindActionCreators } from 'redux';

class BookListContainer extends Component {
  renderBooks() {
    return this.props.books.map((book) => {
      return (
        <li
          onClick={() => this.props.selectBookAction(book)}
          key={book.title}
          className="list-group-item">
          {book.title}
        </li>
      );
    });
  }

  render() {
    return (
      <ul className="list-group col-sm-4">
        {this.renderBooks()}
      </ul>
    )
  }
}

function mapStateToProps(state) {
  return {
    books: state.books
  };
}

function mapDispatchToProps(dispatch) {
  return bindActionCreators({
    selectBookAction: selectBookAction
  }, dispatch);
}

export default connect(mapStateToProps, mapDispatchToProps)(BookListContainer);
