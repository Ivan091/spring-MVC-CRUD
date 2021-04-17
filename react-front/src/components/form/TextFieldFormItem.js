import React from 'react'
import {TextField} from "@material-ui/core";
import {Field} from "redux-form";

const renderTextField = ({label, input, meta: {touched, invalid, error}, ...custom}) => (
    <TextField
        label={label}
        placeholder={label}
        error={touched && invalid}
        helperText={touched && error}
        margin={"normal"}
        variant={"outlined"}
        {...input}
        {...custom}
    />
)

const TextFieldFormItem = (props) => {
    return (
        <Field {...props} component={renderTextField}/>
    )
}

export default TextFieldFormItem
