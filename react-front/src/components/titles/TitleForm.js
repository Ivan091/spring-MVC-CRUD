import React, {useEffect, useState} from 'react'
import {Container, FormControl, MenuItem} from "@material-ui/core";
import {Form, reduxForm} from "redux-form";
import TextFieldFormItem from "../form-items/TextFieldFormItem";
import DateFieldFormItem from "../form-items/DateFieldFormItem";
import {connect} from "react-redux";
import {useHistory, withRouter} from "react-router";
import {compose} from "redux";
import {titleThunkCreator} from "../../redux/reducers/titles-reducer";
import {directorThunkCreator} from "../../redux/reducers/directors-reducer";
import SelectFormItem from "../form-items/SelectFormItem";
import CancelSubmitButtonPair from "../buttons/CancelSubmitButtonPair";

const TitleForm = (props) => {

    const generatedMenuItems = props.directors.map(director =>
        <MenuItem value={director.directorId}>{`${director.name} ${director.surname}`}</MenuItem>
    )

    return (
        <Container maxWidth="xl">
            <Form
                onSubmit={props.handleSubmit}
                style={{justifyContent: "end"}}>
                <FormControl variant={"outlined"} margin={"normal"} fullWidth>
                    <TextFieldFormItem name={"name"} label={"Name"}/>
                    <TextFieldFormItem name={"boxOffice"} label={"Box Office"}/>
                    <TextFieldFormItem name={"budget"} label={"Budget"}/>
                    <DateFieldFormItem name={"premiereDate"} label={"Premiere Date"}/>
                    <TextFieldFormItem name={"runtime"} label={"Runtime"}/>
                    <SelectFormItem name={"directorId"} label={"Director"} children={generatedMenuItems}/>
                </FormControl>
                <CancelSubmitButtonPair cancelLink={"/titles"}/>
            </Form>
        </Container>
    )
}

const TitleFormRedux = reduxForm({form: 'titleForm', enableReinitialize: true})(TitleForm)

const TitleUpdateReduxFormContainer = (props) => {

    let [submitted, setSubmitted] = useState(false);
    let [initValues, setInitValue] = useState({})
    let initId = props.match.params.id
    useEffect(() => {
        props.findById(initId).then(obj => setInitValue(obj))
    }, [])
    let [directors, setDirectors] = useState([])
    useEffect(() => {
            props.findAllDirectors().then(obj => setDirectors(obj))
        }, []
    )

    let history = useHistory()
    const onSubmit = (formData) => {
        formData.titleId = initId
        props.onSubmit(formData)
        setSubmitted(true)
    }

    if (submitted) {
        history.push("/titles")
    }

    return (
        <TitleFormRedux initialValues={initValues} directors={directors} onSubmit={onSubmit}/>
    )
}

const TitleAddFormReduxContainer = (props) => {

    const [submitted, setSubmitted] = useState(false);

    let history = useHistory()
    debugger
    const onSubmit = (formData) => {
        formData.id = 1
        props.onSubmit({...formData, id: 1})
        setSubmitted(true)
    }

    let [directors, setDirectors] = useState([])
    useEffect(() => {
            props.findAllDirectors().then(obj => setDirectors(obj))
        }, []
    )

    if (submitted) {
        history.push("/titles")
    }

    return (
        <TitleFormRedux directors={directors} onSubmit={onSubmit}/>
    )
}

export const TitleUpdateFormContainer = compose(
    withRouter,
    connect(() => {
    }, {
        onSubmit: titleThunkCreator.update,
        findById: titleThunkCreator.findById,
        findAllDirectors: directorThunkCreator.find
    })
)(TitleUpdateReduxFormContainer)

export const TitleAddFormContainer = compose(
    withRouter,
    connect(() => {
    }, {
        onSubmit: titleThunkCreator.add,
        findAllDirectors: directorThunkCreator.find,
    })
)(TitleAddFormReduxContainer)
