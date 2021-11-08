import React from "react";
import {Form, reduxForm} from "redux-form";
import {Button, ButtonGroup, FormControl} from "@material-ui/core";
import TextFieldFormItem from "../form/TextFieldFormItem";
import SubmitButton from "../buttons/SubmitButton";
import {NavLink} from "react-router-dom";

const LoginForm = ({handleSubmit}) =>
    <Form
        onSubmit={handleSubmit}
        style={{justifyContent: "end"}}>
        <FormControl variant={"outlined"} margin={"normal"} fullWidth>
            <TextFieldFormItem name={"login"} label={"Login"}/>
            <TextFieldFormItem name={"password"} label={"Password"}/>
            <ButtonGroup>
                <SubmitButton message={"Login"}/>
                <Button message={"Register"} component={NavLink} to={"/register"}>
                    Register
                </Button>
            </ButtonGroup>
        </FormControl>
    </Form>


const LoginFormRedux = reduxForm({form: 'loginForm', enableReinitialize: true})(LoginForm)
export default LoginFormRedux;