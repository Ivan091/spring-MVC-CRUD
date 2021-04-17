import React, {useCallback} from 'react'
import {Form, reduxForm} from "redux-form";
import DateFieldFormItem from "../form/DateFieldFormItem";
import {Box} from "@material-ui/core";
import {compose} from "redux";
import {connect} from "react-redux";
import {titleThunkCreator} from "../../redux/reducers/titles-reducer";
import SubmitButton from "../buttons/SubmitButton";


const formItem = {
    variant: "standard",
}

const box = {
    margin: 2,
    display: "flex",
    alignItems: "flex-end",
}

const TitlesBetweenForm = ({handleSubmit}) => {
    return (
        <Form onSubmit={handleSubmit}>
            <Box {...box}>
                <Box m={1}>
                    <DateFieldFormItem {...formItem} name={"firstDate"} label={"From"}/>
                </Box>
                <Box m={1}>
                    <DateFieldFormItem {...formItem} name={"secondDate"} label={"To"}/>
                </Box>
                <Box m={1} p={1}>
                    <SubmitButton variant={"outlined"} size={"small"}/>
                </Box>
            </Box>
        </Form>
    )
}

const TitlesBetweenFormRedux = reduxForm({form: 'titlesBetweenForm'})(TitlesBetweenForm)

const TitlesBetweenFormContainer = ({onSubmit}) => {

    const onSubmitCallBack = useCallback((firstDate, secondDate) => onSubmit(firstDate, secondDate), [onSubmit])

    const onFormSubmit = (formData) => {
        onSubmitCallBack(formData.firstDate, formData.secondDate)
    }

    return (
        <TitlesBetweenFormRedux onSubmit={onFormSubmit}/>
    )
}

export default compose(
    connect(null, {
            onSubmit: titleThunkCreator.findAllBetween,
        }
    )
)(TitlesBetweenFormContainer)