import React from 'react'
import {Route} from "react-router-dom";
import {DirectorAddFormContainer, DirectorUpdateFormContainer} from "./directors/DirectorForm";
import {TitleAddFormContainer, TitleUpdateFormContainer} from "./titles/TitleForm";
import TitleTableContainer from "./titles/TitleTableContainer";
import {Switch} from "react-router";
import LoginContainer from "./login/Login";
import NavBar from "./NavBar";
import DirectorTableContainer from "./directors/DirectorTableContainer";
import PrivateRoute from "./PrivateRoute";
import RegisterContainer from "./register/Register";

const PageSwitcher = () => {
    return (
        <Switch>
            <PrivateRoute exact path="/directors/add">
                <NavBar/>
                <DirectorAddFormContainer/>
            </PrivateRoute>
            <PrivateRoute exact path="/directors/:id">
                <NavBar/>
                <DirectorUpdateFormContainer/>
            </PrivateRoute>
            <PrivateRoute exact path="/directors">
                <NavBar/>
                <DirectorTableContainer/>
            </PrivateRoute>
            <PrivateRoute exact path="/titles/add">
                <NavBar/>
                <TitleAddFormContainer/>
            </PrivateRoute>
            <PrivateRoute exact path="/titles/:id">
                <NavBar/>
                <TitleUpdateFormContainer/>
            </PrivateRoute>
            <PrivateRoute exact path="/titles">
                <NavBar/>
                <TitleTableContainer/>
            </PrivateRoute>
            <Route exact path="/login">
                <LoginContainer/>
            </Route>
            <Route exact path="/register">
                <RegisterContainer/>
            </Route>
            <PrivateRoute exact path="/">
                <NavBar/>
            </PrivateRoute>
        </Switch>
    )
}

export default PageSwitcher;
