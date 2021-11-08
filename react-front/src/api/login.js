import axios from "axios";

const axiosInstance = axios.create({
    baseURL: `http://localhost:8080/`
})

export const loginAPI = {
    doLogin: async (login, password) => {
        const response = await axiosInstance.put(`login`, {login, password})
        return response.status === 200;
    },
    doRegister: async (login, password) => {
        const response = await axiosInstance.post(`register`, {login, password})
        return response.status === 200;
    },
}