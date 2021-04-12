import React from 'react'
import {Provider} from "react-redux";
import store from "../redux/store";
import {MuiThemeProvider} from "@material-ui/core";
import theme from "../theme/theme";
import {BrowserRouter} from "react-router-dom";

const AppProvider = ({children}) => {
    return (
        <BrowserRouter>
            <Provider store={store}>
                <MuiThemeProvider theme={theme}>
                    {children}
                </MuiThemeProvider>
            </Provider>
        </BrowserRouter>
    )
}

export default AppProvider
