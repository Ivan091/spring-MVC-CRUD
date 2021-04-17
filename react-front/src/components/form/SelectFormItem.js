import React from 'react'
import {Field} from "redux-form";
import {FormControl, InputLabel, Select} from "@material-ui/core";

const renderSelectField = ({label, input, meta: {touched, invalid, error}, children, ...custom}) => (
    <FormControl variant={"outlined"} margin={"normal"}>
        <InputLabel htmlFor="select-label-id">{label}</InputLabel>
        <Select
            labelId={"select-label-id"}
            label={label}
            {...input}
            {...custom}
        >
            {children}
        </Select>
    </FormControl>
)


const SelectFormItem = (props) => {
    return (
        <Field {...props} component={renderSelectField}/>
    )
}

export default SelectFormItem
