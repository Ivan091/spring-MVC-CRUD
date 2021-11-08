import React from "react";
import {Form, reduxForm} from "redux-form";
import {FormControl} from "@material-ui/core";
import TextFieldFormItem from "../form/TextFieldFormItem";
import SubmitButton from "../buttons/SubmitButton";

const RegisterForm = ({handleSubmit}) =>

    <Form
        onSubmit={handleSubmit}
        style={{justifyContent: "end"}}>
        <FormControl variant={"outlined"} margin={"normal"} fullWidth>
            <TextFieldFormItem name={"login"} label={"Login"}/>
            <TextFieldFormItem name={"password"} label={"Password"}/>
            <TextFieldFormItem name={"confirmPassword"} label={"Confirm password"}/>
            <SubmitButton message={"Register"}/>
        </FormControl>
    </Form>


const RegisterFormRedux = reduxForm({form: 'registerForm', enableReinitialize: true})(RegisterForm)
export default RegisterFormRedux;