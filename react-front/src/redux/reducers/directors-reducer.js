import {directorAPI} from "../../api/director";

const FIND_ALL_DIRECTORS = 'FIND_ALL_DIRECTORS'

let initState = {
    directors: [],
}

const directorsReducer = (state = initState, action) => {
    switch (action.type) {
        case FIND_ALL_DIRECTORS: {
            return {...state, directors: action.directors}
        }
        default :
            return state
    }
}

export const directorActionCreator = {
    findAll: (xs) => ({type: FIND_ALL_DIRECTORS, directors: xs}),
}

export const directorThunkCreator = {
    findAll: () => (dispatch) => {
        directorAPI.findAll().then(data => {
            dispatch(directorActionCreator.findAll(data))
        })
    },
    find: () => (dispatch) => directorAPI.findAll(),
    delete: (id) => (dispatch) => {
        directorAPI.delete(id)
            .then(() => directorAPI.findAll()
                .then(x => dispatch(directorActionCreator.findAll(x))))
    },
    update: (x) => (dispatch) => {
        directorAPI.update(x)
            .then(() => directorAPI.findAll()
                .then(x => dispatch(directorActionCreator.findAll(x))))
    },
    add: (x) => (dispatch) => {
        directorAPI.add(x)
            .then(() => directorAPI.findAll()
                .then(x => dispatch(directorActionCreator.findAll(x))))
    },
    findById: (id) => (dispatch) => directorAPI.findById(id)
}


export default directorsReducer