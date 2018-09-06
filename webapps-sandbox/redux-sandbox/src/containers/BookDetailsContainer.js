import React, {Component} from 'react';
import {connect} from 'react-redux';

class BookDetailsContainer extends Component {
  render() {
    if (!this.props.activeBook) {
      return <div>Select a book to see details...</div>
    }

    return (
      <div>Selected book is: {this.props.activeBook.title}</div>
    )
  }
}

function mapStateToProps(state) {
  return {
    activeBook: state.activeBook
  };
}

export default connect(mapStateToProps)(BookDetailsContainer);
