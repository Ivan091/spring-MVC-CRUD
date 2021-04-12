import React, {useCallback, useEffect, useState} from 'react'
import {Container, FormControl, MenuItem} from "@material-ui/core";
import {Form, reduxForm} from "redux-form";
import TextFieldFormItem from "../form/TextFieldFormItem";
import DateFieldFormItem from "../form/DateFieldFormItem";
import {connect, useDispatch} from "react-redux";
import {Redirect, useHistory, withRouter} from "react-router";
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
                    <SelectFormItem defaultValue="" name={"directorId"} label={"Director"}
                                    children={generatedMenuItems}/>
                </FormControl>
                <CancelSubmitButtonPair cancelLink={"/titles"}/>
            </Form>
        </Container>
    )
}

const TitleFormRedux = reduxForm({form: 'titleForm', enableReinitialize: true})(TitleForm)

const TitleUpdateReduxFormContainer = (props) => {

    const dispatch = useDispatch()
    const findById = useCallback((id) => dispatch(titleThunkCreator.findById(id)), [titleThunkCreator.findById])
    const findAllDirectors = useCallback(() => dispatch(directorThunkCreator.find()), [directorThunkCreator.find])
    const submit = useCallback((formData) => dispatch(titleThunkCreator.update(formData)), [titleThunkCreator.add])

    const initId = Number(props.match.params.id)
    const [submitted, setSubmitted] = useState(false);
    const [initValues, setInitValue] = useState({})
    const [directors, setDirectors] = useState([])

    useEffect(() => findById(initId).then(obj => setInitValue(obj)), [findById, initId])
    useEffect(() => findAllDirectors().then(obj => setDirectors(obj)), [findAllDirectors, directors])

    const onSubmit = (formData) => {
        formData.titleId = initId
        submit(formData)
        setSubmitted(true)
    }

    if (submitted) {
        return <Redirect to={"/titles"}/>
    }

    return (
        <TitleFormRedux initialValues={initValues} directors={directors} onSubmit={onSubmit}/>
    )
}

const TitleAddFormReduxContainer = (props) => {

    const findAllDirectorsProps = props.findAllDirectors
    const findAllDirectors = useCallback(() => findAllDirectorsProps(), [findAllDirectorsProps])

    const [submitted, setSubmitted] = useState(false);
    const [directors, setDirectors] = useState([])

    useEffect(() => {
            findAllDirectors().then(obj => setDirectors(obj))
        }, [findAllDirectors, directors]
    )

    let history = useHistory()

    const onSubmit = (formData) => {
        props.onSubmit({...formData, titleId: 0})
        setSubmitted(true)
    }


    if (submitted) {
        history.push("/titles")
    }

    return (
        <TitleFormRedux initialValues={directors} onSubmit={onSubmit}/>
    )
}

export const TitleUpdateFormContainer = compose(
    withRouter,
    connect(null, {
        onSubmit: titleThunkCreator.update,
        findAllDirectors: directorThunkCreator.find
    })
)(TitleUpdateReduxFormContainer)

export const TitleAddFormContainer = compose(
    withRouter,
)(TitleAddFormReduxContainer)
