import React from 'react'
import {IconButton, Tooltip} from "@material-ui/core";
import {DeleteSharp} from "@material-ui/icons";

const ButtonDelete = (props) => {

    let deleteEntity = () => {
        props.delete(props.id)
    }

    return (
        <Tooltip title={"Delete"}>
            <IconButton onClick={deleteEntity}>
                <DeleteSharp/>
            </IconButton>
        </Tooltip>
    )
}

export default ButtonDelete
