import { combineReducers } from 'redux';
import BooksReducer from './BookListReducer';


const rootReducer = combineReducers({
  books: BooksReducer
});

export default rootReducer;
