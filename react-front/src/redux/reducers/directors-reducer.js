import {directorAPI} from "../../api/director";

const REQUEST_ALL = 'directors/REQUEST_ALL'
const DELETE = 'directors/DELETE'

let initState = {
    directors: [],
}

const directorsReducer = (state = initState, action) => {
    switch (action.type) {
        case DELETE: {

        }
        case REQUEST_ALL: {
            return {...state, directors: action.directors}
        }
        default :
            return state
    }
}

export const directorActionCreator = {
    requestAll: (xs) => ({type: REQUEST_ALL, directors: xs}),
    delete: (directorId) => ({type: REQUEST_ALL, directorId: directorId}),
}

export const directorThunkCreator = {
    findAll: () => (dispatch) => {
        directorAPI.findAll().then(data => {
            dispatch(directorActionCreator.requestAll(data))
        })
    },
    find: () => (dispatch) => directorAPI.findAll(),
    delete: (id) => (dispatch) => {
        directorAPI.delete(id)
            .then(() => directorAPI.findAll()
                .then(x => dispatch(directorActionCreator.requestAll(x))))
    },
    update: (x) => (dispatch) => {
        directorAPI.update(x)
            .then(() => directorAPI.findAll()
                .then(x => dispatch(directorActionCreator.requestAll(x))))
    },
    add: (x) => (dispatch) => {
        directorAPI.add(x)
            .then(() => directorAPI.findAll()
                .then(x => dispatch(directorActionCreator.requestAll(x))))
    },
    findById: (id) => (dispatch) => directorAPI.findById(id)
}


export default directorsReducer