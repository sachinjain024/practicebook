// You can not return undefined state in redux however null is allowed so using default value for state argument
// Every reducer takes two args, current state and the action
// Based on the action, state can be modified. Remember to return a new object and not to modify the existing state object
export default function(state = null, action) {
  switch (action.type) {
    case 'BOOK_SELECTED': return action.payload;
  }

  return state;
}
