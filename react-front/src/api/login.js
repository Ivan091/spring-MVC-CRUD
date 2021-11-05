import axios from "axios";

const axiosInstance = axios.create({
    baseURL: `http://localhost:8080/`
})

export const loginAPI = {
    doLogin: async (login, password) => {
        const response = await axiosInstance.post(`login`, {login, password})
        return response.status === 200;
    },
}