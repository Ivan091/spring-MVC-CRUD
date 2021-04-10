import './App.css';
import React from "react";
import {Route} from "react-router-dom";
import DirectorTableContainer from "./components/director/DirectorTableContainer";
import NavBar from "./components/NavBar";


const App = (props) => {
    return (
        <>
            <NavBar/>
            <Route path="/directors" render={() => (<DirectorTableContainer/>)}/>
            <Route path="/director"/>
            <Route path="/titles"/>
            <Route path="/title"/>
            <Route path="/"/>
        </>
    )
}

export default App
