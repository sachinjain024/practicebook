// This is an ActionCreator and It must return an object (i.e. action)
// Usually it's good practice to have type property on it and use that in switch in reducer code
export function selectBookAction(book) {
  return {
    type: 'BOOK_SELECTED',
    payload: book
  };
}