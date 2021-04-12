import {directorAPI} from "../../api/director";

const UPDATE_ALL = 'directors/UPDATE_ALL'
const DELETE = 'directors/DELETE'

let initState = {
    directors: [],
}

const directorsReducer = (state = initState, action) => {
    switch (action.type) {
        case UPDATE_ALL: {
            return {...state, directors: action.directors}
        }
        case DELETE: {
            return {...state, directors: state.directors.filter(t => t.directorId !== action.directorId)}
        }
        default :
            return state
    }
}

export const directorActionCreator = {
    updateAll: (directors) => ({type: UPDATE_ALL, directors: directors}),
    delete: (directorId) => ({type: DELETE, directorId: directorId}),
}

const refresh = async (dispatch) => {
    const titles = await directorAPI.findAll()
    dispatch(directorActionCreator.updateAll(titles))
}

export const directorThunkCreator = {
    requestAll: () => async (dispatch) => {
        await refresh(dispatch)
    },

    delete: (id) => async (dispatch) => {
        directorAPI.delete(id)
            .then(() => directorAPI.findAll()
                .then(x => dispatch(directorActionCreator.requestAll(x))))
    },
    update: (x) => async (dispatch) => {
        await directorAPI.update(x)
        await refresh(dispatch)
    },
    add: (x) => async (dispatch) => {
        await directorAPI.add(x)
        await refresh(dispatch)
    },
    findAll: () => async (dispatch) => await directorAPI.findAll(),
    findById: (id) => async (dispatch) => await directorAPI.findById(id)
}


export default directorsReducer