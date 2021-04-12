import React from "react";
import NavBar from "./components/NavBar";
import PageSwitcher from "./components/PageSwitcher";


const App = (props) => {
    return (
        <AppProvider>
            <NavBar/>
            <PageSwitcher/>
        </AppProvider>
    )
}

export default App
