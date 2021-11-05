import React from "react";
import {compose} from "redux";
import {Redirect, withRouter} from "react-router";
import {connect} from "react-redux";
import {loginThunkCreator} from "../../redux/reducers/login-reducer";
import LoginFormRedux from "./LoginForm";

const Login = ({doLogin, isLogged}) => {

    const onSubmit = (formData) => {
        doLogin(formData.login, formData.password)
    }

    if(isLogged){
        return (<Redirect to={"/"}/>)
    } else {
        return (
            <LoginFormRedux onSubmit={onSubmit}/>
        )
    }
}

let mapState = (state, ownProps) => {
    return{
        isLogged: state.login.isLogged
    }
}

const LoginContainer = compose(
    withRouter,
    connect(mapState, {
        doLogin: loginThunkCreator.doLogin,
    })
)(Login)

export default LoginContainer;