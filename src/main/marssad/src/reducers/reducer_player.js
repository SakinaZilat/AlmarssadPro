import {FETCH_LISTING} from '../actions/index' ;

// A reducer is a function that accepts a state
// and a value and returns a new state.
export default function(state =[], action) {
console.log("reducer_player ",action);
  switch(action.type)
  {
    case FETCH_LISTING:
    console.log("reducer_player.payload ",action.payload.data);
      return action.payload.data;
    default:
        return state;
  }


}
