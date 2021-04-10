import React from 'react'
import {IconButton, Tooltip} from "@material-ui/core";
import {DeleteSharp} from "@material-ui/icons";

const ButtonDelete = (props) => {

    let deleteDirector = () => {
        props.deleteDirector(props.id)
    }

    return (
        <Tooltip title={"Delete"}>
            <IconButton onClick={deleteDirector}>
                <DeleteSharp/>
            </IconButton>
        </Tooltip>
    )
}

export default ButtonDelete
