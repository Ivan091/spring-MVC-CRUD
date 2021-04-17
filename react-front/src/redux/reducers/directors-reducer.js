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
    const directors = await directorAPI.findAll()
    dispatch(directorActionCreator.updateAll(directors))
}

export const directorThunkCreator = {
    requestAll: () => async (dispatch) => {
        await refresh(dispatch)
    },

    delete: (id) => async (dispatch) => {
        await directorAPI.delete(id)
        dispatch(directorActionCreator.delete(id))
    },
    update: (director) => async (dispatch) => {
        await directorAPI.update(director)
        await refresh(dispatch)
    },
    add: (director) => async (dispatch) => {
        await directorAPI.add(director)
        await refresh(dispatch)
    },
    findAll: () => async (dispatch) => await directorAPI.findAll(),
    findById: (id) => async (dispatch) => await directorAPI.findById(id)
}

export default directorsReducer