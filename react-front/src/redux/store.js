import {combineReducers, createStore} from "redux";
import directorsReducer from "./reducers/directors-reducer";

let reducers = combineReducers({
    directors: directorsReducer,
})

let store = createStore(reducers)

export default store;