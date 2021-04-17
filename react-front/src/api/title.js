import axios from "axios";

const axiosInstance = axios.create({
    baseURL: `http://localhost:8080/`
})

export const titleAPI = {
    findAll: () => axiosInstance.get(`titles`).then(result => result.data),
    findAllBetween: (firstDate, secondDate) =>
        axiosInstance.get(`titles/between`,
            {params: {firstDate: firstDate, secondDate: secondDate}})
            .then(result => result.data)
    ,
    findById: (id) => axiosInstance.get(`titles/${id}`).then(result => result.data),
    delete: (id) => axiosInstance.delete(`titles/${id}`).then(result => result.data),
    update: (x) => axiosInstance.put(`titles`, x).then(result => result.data),
    add: (x) => axiosInstance.post(`titles`, x).then(result => result.data),
}