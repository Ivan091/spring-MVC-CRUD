import React from 'react'
import {Field} from "redux-form";
import {TextField} from "@material-ui/core";

const renderDateField = ({label, input, meta: {touched, invalid, error}, ...custom}) => (
    <TextField
        label={label}
        error={touched && invalid}
        helperText={touched && error}
        type={"date"}
        margin={"normal"}
        variant={"outlined"}
        InputLabelProps={{shrink: true}}
        {...input}
        {...custom}
    />
)


const DateFieldFormItem = (props) => {
    return (
        <Field {...props} component={renderDateField}/>
    )
}

export default DateFieldFormItem
