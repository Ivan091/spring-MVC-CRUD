import React, {useEffect, useState} from 'react'
import {Container} from "@material-ui/core";
import {Form, reduxForm} from "redux-form";
import TextFieldFormItem from "../form-items/TextFieldFormItem";
import DateFieldFormItem from "../form-items/DateFieldFormItem";
import {connect} from "react-redux";
import {directorThunkCreator} from "../../redux/reducers/directors-reducer";
import {useHistory, withRouter} from "react-router";
import {compose} from "redux";
import CancelSubmitButtonPair from "../buttons/CancelSubmitButtonPair";

const DirectorForm = (props) => {
    return (
        <Container maxWidth="xl">
            <Form
                onSubmit={props.handleSubmit}
                style={{justifyContent: "end"}}>
                <TextFieldFormItem name={"name"} label={"Name"}/>
                <TextFieldFormItem name={"surname"} label={"Surname"}/>
                <DateFieldFormItem name={"birthDate"} label={"Birth Date"}/>
                <CancelSubmitButtonPair cancelLink={"/directors"}/>
            </Form>
        </Container>
    )
}

const DirectorFormRedux = reduxForm({form: 'directorForm', enableReinitialize: true})(DirectorForm)

const DirectorUpdateReduxFormContainer = (props) => {

    const [submitted, setSubmitted] = useState(false);
    const [initValues, setInitValue] = useState({})
    let initId = props.match.params.id
    useEffect(() => {
        props.findById(initId).then(obj => setInitValue(obj))
    }, [])

    let history = useHistory()
    const onSubmit = (formData) => {
        formData.id = initId
        props.onSubmit(formData)
        setSubmitted(true)
    }

    if (submitted) {
        history.push("/directors")
    }

    return (
        <DirectorFormRedux initialValues={initValues} onSubmit={onSubmit}/>
    )
}

const DirectorAddFormReduxContainer = (props) => {

    const [submitted, setSubmitted] = useState(false);

    let history = useHistory()
    debugger
    const onSubmit = (formData) => {
        formData.id = 1
        props.onSubmit({...formData, id: 1})
        setSubmitted(true)
    }

    if (submitted) {
        history.push("/directors")
    }

    return (
        <DirectorFormRedux onSubmit={onSubmit}/>
    )
}

export const DirectorUpdateFormContainer = compose(
    withRouter,
    connect(() => {
    }, {
        onSubmit: directorThunkCreator.update,
        findById: directorThunkCreator.findById
    })
)(DirectorUpdateReduxFormContainer)

export const DirectorAddFormContainer = compose(
    withRouter,
    connect(() => {
    }, {
        onSubmit: directorThunkCreator.add,
    })
)(DirectorAddFormReduxContainer)
