import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import {BrowserRouter} from "react-router-dom";
import store from "./redux/store";
import {Provider} from "react-redux";
import {MuiThemeProvider} from "@material-ui/core";
import theme from "./theme/theme";


let renderEntireTree = (state) => {
    ReactDOM.render(
        <BrowserRouter>
            <Provider store={store}>
                <MuiThemeProvider theme={theme}>
                    <App/>
                </MuiThemeProvider>
            </Provider>
        </BrowserRouter>, document.getElementById('root')
    );
}
renderEntireTree(store.getState())

store.subscribe(renderEntireTree)
