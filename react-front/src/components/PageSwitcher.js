import React from 'react'
import {Route} from "react-router-dom";
import {DirectorAddFormContainer, DirectorUpdateFormContainer} from "./directors/DirectorForm";
import DirectorTableContainer from "./directors/DirectorTableContainer";
import {TitleAddFormContainer, TitleUpdateFormContainer} from "./titles/TitleForm";
import TitleTableContainer from "./titles/TitleTableContainer";
import {Switch} from "react-router";

const PageSwitcher = (props) => {
    return (
        <Switch>
            <Route exact path="/directors/add" render={() => (<DirectorAddFormContainer/>)}/>
            <Route exact path="/directors/:id" render={() => (<DirectorUpdateFormContainer/>)}/>
            <Route exact path="/directors" render={() => (<DirectorTableContainer/>)}/>
            <Route exact path="/titles/add" render={() => (<TitleAddFormContainer/>)}/>
            <Route exact path="/titles/:id" render={() => (<TitleUpdateFormContainer/>)}/>
            <Route exact path="/titles" render={() => (<TitleTableContainer/>)}/>
            <Route path="/"/>
        </Switch>
    )
}

export default PageSwitcher
