import {IconButton, Tooltip} from "@material-ui/core";
import {NavLink} from "react-router-dom";
import React from "react";


const IconButtonNavLink = (props) => {
    return (
        <Tooltip title={props.title}>
            <IconButton component={NavLink} to={props.url}>
                {props.inner}
            </IconButton>
        </Tooltip>
    )
}

export default IconButtonNavLink