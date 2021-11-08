import React, {useState} from "react";
import {compose} from "redux";
import {Redirect, withRouter} from "react-router";
import {connect} from "react-redux";
import {registerThunkCreator} from "../../redux/reducers/login-reducer";
import LoginFormRedux from "./RegisterForm";
import {Container} from "@material-ui/core";
import Alert from '@material-ui/lab/Alert';

const Register = ({doRegister, isLogged}) => {

    let [error, setError] = useState("")

    const onSubmit = async (formData) => {
        if (formData.password !== formData.confirmPassword) {
            setError("Passwords are different")
            return;
        }
        let result = await doRegister(formData.login, formData.password)
        if (result) {
            setError(result)
        }
    }

    let alert;
    if (error) {
        alert = <Alert severity="error">{error}</Alert>
    }

    if (isLogged) {
        return (<Redirect to={"/"}/>)
    } else {
        return (
            <Container maxWidth="sm">
                {alert}
                <LoginFormRedux onSubmit={onSubmit}/>
            </Container>
        )
    }
}

let mapState = (state) => {
    return {
        isLogged: state.login.isLogged
    }
}

const RegisterContainer = compose(
    withRouter,
    connect(mapState, {
        doRegister: registerThunkCreator.doRegister,
    })
)(Register)

export default RegisterContainer;