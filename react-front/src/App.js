import React from "react";
import NavBar from "./components/NavBar";
import PageSwitcher from "./components/PageSwitcher";
import AppProvider from "./components/AppProvider";


const App = (props) => {
    return (
        <AppProvider>
            <NavBar/>
            <PageSwitcher/>
        </AppProvider>
    )
}

export default App
