import { combineReducers } from 'redux';
import BooksReducer from './BookListReducer';
import ActiveBookReducer from './ActiveBookReducer';

const rootReducer = combineReducers({
  books: BooksReducer,
  activeBook: ActiveBookReducer
});

export default rootReducer;
