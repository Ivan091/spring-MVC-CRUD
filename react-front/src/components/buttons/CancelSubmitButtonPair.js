import React from 'react'
import {Box, Button, ButtonGroup} from "@material-ui/core";
import {NavLink} from "react-router-dom";
import SubmitButton from "./SubmitButton";

const CancelSubmitButtonPair = (props) => {
    return (
        <Box textAlign={"end"}>
            <ButtonGroup variant={"contained"}>
                <Button color={"secondary"} component={NavLink} to={props.cancelLink}>
                    Cancel
                </Button>
                <SubmitButton/>
            </ButtonGroup>
        </Box>
    )
}

export default CancelSubmitButtonPair
