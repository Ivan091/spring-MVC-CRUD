import React from 'react'
import {IconButton, Tooltip} from "@material-ui/core";
import {EditSharp} from "@material-ui/icons";
import {NavLink} from "react-router-dom";

const ButtonUpdate = (props) => {

    let updateDirector = () => {
        props.updateDirector(props.director)
    }
    return (
        <Tooltip title={"Edit"}>
            <IconButton
                component={NavLink} to={"/director"}
                onClick={updateDirector}
            >
                <EditSharp/>
            </IconButton>
        </Tooltip>
    )
}

export default ButtonUpdate
