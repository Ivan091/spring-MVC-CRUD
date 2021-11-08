import React from 'react'
import {Button} from "@material-ui/core";

const SubmitButton = ({props, message = "Submit"}) => {
    return (
        <Button type={"submit"}  {...props} color={"primary"}>
            {message}
        </Button>
    )
}

export default SubmitButton
