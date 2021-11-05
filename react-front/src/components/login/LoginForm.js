import React from "react";
import {Form, reduxForm} from "redux-form";
import {Container, FormControl} from "@material-ui/core";
import TextFieldFormItem from "../form/TextFieldFormItem";
import SubmitButton from "../buttons/SubmitButton";

const LoginForm = ({handleSubmit}) =>
    <Container maxWidth="sm">
        <Form
            onSubmit={handleSubmit}
            style={{justifyContent: "end"}}>
            <FormControl variant={"outlined"} margin={"normal"} fullWidth>
                <TextFieldFormItem name={"login"} label={"Login"}/>
                <TextFieldFormItem name={"password"} label={"Password"}/>
                <SubmitButton/>
            </FormControl>
        </Form>
    </Container>


const LoginFormRedux = reduxForm({form: 'loginForm', enableReinitialize: true})(LoginForm)
export default LoginFormRedux;