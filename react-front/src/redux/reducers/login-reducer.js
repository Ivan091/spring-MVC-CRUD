import {loginAPI} from "../../api/login";

const login = 'login/login'

const initState = {
    isLogged: false
}

const loginReducer = (state = initState, action) => {
    switch (action.type){
        case login: {
            return {...state, isLogged: action.isLogged}
        }
        default:{
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
        const status = await loginAPI.doLogin(login, password)
        dispatch(loginActionCreator.login(status))
    }
}