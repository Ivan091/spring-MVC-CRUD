import React from 'react'
import {Button} from "@material-ui/core";

const SubmitButton = (props) => {
    return (
        <Button type={"submit"}  {...props} color={"primary"}>
            Submit
        </Button>
    )
}

export default SubmitButton
