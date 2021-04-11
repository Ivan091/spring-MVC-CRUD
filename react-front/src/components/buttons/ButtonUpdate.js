import React from 'react'
import {IconButton, Tooltip} from "@material-ui/core";
import {EditSharp} from "@material-ui/icons";
import {NavLink} from "react-router-dom";

const ButtonUpdate = (props) => {
    return (
        <Tooltip title={"Edit"}>
            <IconButton component={NavLink} to={`/director/${props.id}`}>
                <EditSharp/>
            </IconButton>
        </Tooltip>
    )
}

export default ButtonUpdate
