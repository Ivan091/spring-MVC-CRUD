import {applyMiddleware, combineReducers, createStore} from "redux";
import directorsReducer from "./reducers/directors-reducer";
import thunk from "redux-thunk";

let reducers = combineReducers({
    directorsPage: directorsReducer,
})

let store = createStore(reducers, applyMiddleware(thunk))

window.store = store

export default store;