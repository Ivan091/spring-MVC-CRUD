import axios from "axios";

const axiosInstance = axios.create({
    baseURL: `http://localhost:8080/api/`
})

export const directorAPI = {
    findAll: () => axiosInstance.get('directors').then(result => result.data),
    delete: (id) => axiosInstance.delete(`directors/${id}`).then(result => result.data),
}