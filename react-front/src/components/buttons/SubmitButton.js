import React from 'react'
import {Button} from "@material-ui/core";

const SubmitButton = (props) => {
    return (
        <Button type={"submit"} color={"primary"} {...props}>
            Submit
        </Button>
    )
}

export default SubmitButton
