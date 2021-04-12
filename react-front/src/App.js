import React from "react";
import {Route} from "react-router-dom";
import NavBar from "./components/NavBar";
import {Switch} from "react-router";
import {TitleAddFormContainer, TitleUpdateFormContainer} from "./components/titles/TitleForm";
import TitleTableContainer from "./components/titles/TitleTableContainer";
import {DirectorAddFormContainer, DirectorUpdateFormContainer} from "./components/directors/DirectorForm";
import DirectorTableContainer from "./components/directors/DirectorTableContainer";


const App = (props) => {
    return (
        <>
            <NavBar/>
            <Switch>
                <Route exact path="/directors/add" render={() => (<DirectorAddFormContainer/>)}/>
                <Route exact path="/directors/:id" render={() => (<DirectorUpdateFormContainer/>)}/>
                <Route exact path="/directors" render={() => (<DirectorTableContainer/>)}/>
                <Route exact path="/titles/add" render={() => (<TitleAddFormContainer/>)}/>
                <Route exact path="/titles/:id" render={() => (<TitleUpdateFormContainer/>)}/>
                <Route exact path="/titles" render={() => (<TitleTableContainer/>)}/>
                <Route path="/"/>
            </Switch>
        </>
    )
}

export default App
