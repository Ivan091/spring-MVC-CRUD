import React from "react";
import PageSwitcher from "./components/PageSwitcher";
import AppProvider from "./components/AppProvider";


const App = (props) => {
    return (
        <AppProvider>
            <PageSwitcher/>
        </AppProvider>
    )
}

export default App
