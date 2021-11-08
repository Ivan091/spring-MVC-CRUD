import {loginAPI} from "../../api/login";

const login = 'login/login'

const initState = {
    isLogged: false
}

const loginReducer = (state = initState, action) => {
    switch (action.type) {
        case login: {
            return {...state, isLogged: action.isLogged}
        }
        default: {
            return state;
        }
    }
}

export default loginReducer;

export const loginActionCreator = {
    login: (isLogged) => ({type: login, isLogged})
}

export const loginThunkCreator = {
    doLogin: (login, password) => async (dispatch) => {
        try {
            const isOk = await loginAPI.doLogin(login, password)
            dispatch(loginActionCreator.login(isOk))
        } catch (e) {
            return "Login or username is incorrect";
        }
    }
}

export const registerThunkCreator = {
    doRegister: (login, password) => async (dispatch) => {
        try {
            const isOk = await loginAPI.doRegister(login, password)
            dispatch(loginActionCreator.login(isOk))
        } catch (e) {
            return "The user is already exist";
        }
    }
}