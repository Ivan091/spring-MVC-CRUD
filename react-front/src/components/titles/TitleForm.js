import React, {useCallback, useEffect, useState} from 'react'
import {Container, FormControl, MenuItem} from "@material-ui/core";
import {Form, reduxForm} from "redux-form";
import TextFieldFormItem from "../form/TextFieldFormItem";
import DateFieldFormItem from "../form/DateFieldFormItem";
import {connect} from "react-redux";
import {Redirect} from "react-router";
import {compose} from "redux";
import {titleThunkCreator} from "../../redux/reducers/titles-reducer";
import {directorThunkCreator} from "../../redux/reducers/directors-reducer";
import SelectFormItem from "../form/SelectFormItem";
import CancelSubmitButtonPair from "../buttons/CancelSubmitButtonPair";

const TitleForm = (props) => {

    const generatedMenuItems = props.directors.map(director =>
        <MenuItem key={director.directorId}
                  value={director.directorId}>{`${director.name} ${director.surname}`}</MenuItem>
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
                    <SelectFormItem name={"directorId"} label={"Director"}
                                    children={generatedMenuItems}/>
                </FormControl>
                <CancelSubmitButtonPair cancelLink={"/titles"}/>
            </Form>
        </Container>
    )
}

const TitleFormRedux = reduxForm({form: 'titleForm', enableReinitialize: true})(TitleForm)

const TitleUpdateReduxFormContainer = ({onSubmit, findById, findAllDirectors, ...props}) => {

    const findByIdCallBack = useCallback((id) => findById(id), [findById])
    const findAllDirectorsCallBack = useCallback(() => findAllDirectors(), [findAllDirectors])
    const onSubmitCallBack = useCallback((formData) => onSubmit(formData), [onSubmit])

    const initId = Number(props.match.params.id)
    const [submitted, setSubmitted] = useState(false);
    const [initValues, setInitValue] = useState({})
    const [directors, setDirectors] = useState([])

    useEffect(() => findByIdCallBack(initId).then(obj => setInitValue(obj)), [findByIdCallBack, initId])
    useEffect(() => findAllDirectorsCallBack().then(obj => setDirectors(obj)), [findAllDirectorsCallBack, directors])

    const onFormSubmit = (formData) => {
        formData.titleId = initId
        onSubmitCallBack(formData)
        setSubmitted(true)
    }

    if (submitted) {
        return <Redirect to={"/titles"}/>
    }

    return (
        <TitleFormRedux initialValues={initValues} directors={directors} onSubmit={onFormSubmit}/>
    )
}

const TitleAddFormReduxContainer = ({onSubmit, findAllDirectors}) => {

    const findAllDirectorsCallBack = useCallback(() => findAllDirectors(), [findAllDirectors])
    const onSubmitCallBack = useCallback((title) => onSubmit(title), [onSubmit])

    const [submitted, setSubmitted] = useState(false);
    const [directors, setDirectors] = useState([])

    useEffect(() => findAllDirectorsCallBack().then(obj => setDirectors(obj)), [findAllDirectorsCallBack, directors])

    const onFormSubmit = (formData) => {
        formData.titleId = 0
        onSubmitCallBack(formData)
        setSubmitted(true)
    }

    if (submitted) {
        return <Redirect to={"/titles"}/>
    }

    return (
        <TitleFormRedux directors={directors} onSubmit={onFormSubmit}/>
    )
}

export const TitleUpdateFormContainer = compose(
    connect(null, {
        onSubmit: titleThunkCreator.update,
        findById: titleThunkCreator.findById,
        findAllDirectors: directorThunkCreator.findAll
    })
)(TitleUpdateReduxFormContainer)

export const TitleAddFormContainer = compose(
    connect(null, {
        onSubmit: titleThunkCreator.add,
        findAllDirectors: directorThunkCreator.findAll
    })
)(TitleAddFormReduxContainer)
