import {applyMiddleware, combineReducers, createStore} from "redux";
import directorsReducer from "./reducers/directors-reducer";
import thunk from "redux-thunk";
import {reducer as formReducer} from 'redux-form'

let reducers = combineReducers({
    directorsPage: directorsReducer,
    form: formReducer
})

let store = createStore(reducers, applyMiddleware(thunk))

window.store = store

export default store;