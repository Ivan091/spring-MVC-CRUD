import React from 'react'
import {NavLink} from "react-router-dom";
import {AppBar, Button, Toolbar, Typography} from "@material-ui/core";

const NavBar = (props) => {
    return (
        <AppBar position="sticky">
            <Toolbar>
                <Button component={NavLink} to={"/directors"} color={"inherit"}>
                    <Typography variant={"h4"}>
                        Directors
                    </Typography>
                </Button>
                <Button component={NavLink} to={"/titles"} color={"inherit"}>
                    <Typography variant={"h4"}>
                        Titles
                    </Typography>
                </Button>
            </Toolbar>
        </AppBar>
    )
}

export default NavBar
