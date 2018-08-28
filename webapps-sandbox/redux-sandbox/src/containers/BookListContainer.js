import React, {Component} from 'react';
import {connect} from 'react-redux';

class BookListContainer extends Component {
  renderBooks() {
    return this.props.books.map((book) => {
      return (
        <li key={book.title} className="list-group-item ">{book.title}</li>
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

export default connect(mapStateToProps)(BookListContainer);
