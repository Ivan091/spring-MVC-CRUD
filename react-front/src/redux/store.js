import {applyMiddleware, combineReducers, createStore} from "redux";
import directorsReducer from "./reducers/directors-reducer";
import thunk from "redux-thunk";
import {reducer as formReducer} from 'redux-form'
import titlesReducer from "./reducers/titles-reducer";
import loginReducer from "./reducers/login-reducer";

const reducers = combineReducers({
    directorsPage: directorsReducer,
    titlesPage: titlesReducer,
    login: loginReducer,
    form: formReducer
})

const store = createStore(reducers, applyMiddleware(thunk))

window.store = store

export default store;