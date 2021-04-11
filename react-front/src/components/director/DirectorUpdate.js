import React from 'react'
import {Box, Button, ButtonGroup, Container} from "@material-ui/core";
import {reduxForm} from "redux-form";
import TextFieldFormItem from "../form-items/TextFieldFormItem";
import DateFieldFormItem from "../form-items/DateFieldFormItem";
import {NavLink} from "react-router-dom";

const DirectorUpdate = (props) => {

    return (
        <Container maxWidth="xl">
            <form onSubmit={props.hanleSubmit} style={{justifyContent: "end"}}>
                <TextFieldFormItem name={"name"} label={"Name"}/>
                <TextFieldFormItem name={"surname"} label={"Surname"}/>
                <DateFieldFormItem name={"birthDate"} label={"Birth Date"}/>
                <Box textAlign={"end"}>
                    <ButtonGroup variant={"contained"}>
                        <Button color={"secondary"} component={NavLink} to={"/directors"}>Cancel</Button>
                        <Button color={"primary"}>Submit</Button>
                    </ButtonGroup>
                </Box>
            </form>
        </Container>
    )
}

const ReduxDirectorUpdate = reduxForm({
    form: 'updateDirectorForm'
})(DirectorUpdate)

export default ReduxDirectorUpdate
