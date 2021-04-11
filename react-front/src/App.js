import React from "react";
import {Route} from "react-router-dom";
import DirectorTableContainer from "./components/director/DirectorTableContainer";
import NavBar from "./components/NavBar";
import DirectorUpdate from "./components/director/DirectorUpdate";


const App = (props) => {
    return (
        <>
            <NavBar/>
            <Route path="/directors" render={() => (<DirectorTableContainer/>)}/>
            <Route path="/director" render={() => (<DirectorUpdate/>)}/>
            <Route path="/titles"/>
            <Route path="/title"/>
            <Route path="/"/>
        </>
    )
}

export default App
