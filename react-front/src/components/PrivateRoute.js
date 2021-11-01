import React from "react";
import {compose} from "redux";
import {Redirect, Route} from "react-router";
import {connect} from "react-redux";

const PrivateRoute = ({isLogged, children, ...rest}) => {
    if (isLogged){
        return (
            <Route {...rest}>
                {children}
            </Route>
        )
    } else {
        return (
            <Redirect to={'/login'}/>
        )
    }
}

const mapState = (state) => {
    return {
        isLogged: state.login.isLogged
    }
}

export default compose(
    connect(mapState)
)(PrivateRoute)