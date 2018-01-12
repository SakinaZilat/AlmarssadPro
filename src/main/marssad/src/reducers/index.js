import { combineReducers } from 'redux';
import PlayerReducer from './reducer_player';


const rootReducer = combineReducers({

players:PlayerReducer
});
export default rootReducer;
