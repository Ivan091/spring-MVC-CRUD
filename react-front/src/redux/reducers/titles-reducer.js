import {titleAPI} from "../../api/title";

const UPDATE_ALL = 'titles/UPDATE_ALL'
const DELETE = 'titles/DELETE'
const UPDATE = 'titles/UPDATE'
const ADD = 'titles/ADD'

let initState = {
    titles: [],
}

const titlesReducer = (state = initState, action) => {
    switch (action.type) {
        case UPDATE_ALL: {
            return {...state, titles: action.titles}
        }
        case DELETE: {
            return {...state, titles: state.titles.filter(t => t.titleId !== action.titleId)}
        }
        case UPDATE: {
            const titlesCopy = [...state.titles]
            const targetIdx = state.titles.findIndex(t => t.titleId === action.title.titleId)
            titlesCopy[targetIdx] = action.title
            let a = {...state, titles: titlesCopy}
            return {...state, titles: titlesCopy}
        }
        case ADD : {
            const titlesCopy = [...state.titles]
            titlesCopy.push(action.title)
            return {...state, titles: titlesCopy}
        }
        default :
            return state
    }
}

export const titleActionCreator = {
    updateAll: (titles) => ({type: UPDATE_ALL, titles: titles}),
    delete: (titleId) => ({type: DELETE, titleId: titleId}),
    update: (title) => ({type: UPDATE, title: title}),
    add: (title) => ({type: ADD, title: title}),
}

const refresh = async (dispatch) => {
    const titles = await titleAPI.findAll()
    dispatch(titleActionCreator.updateAll(titles))
}


export const titleThunkCreator = {
    requestAll: () => async (dispatch) => {
        await refresh(dispatch)
    },
    delete: (id) => async (dispatch) => {
        await titleAPI.delete(id)
        dispatch(titleActionCreator.delete(id))
    },
    update: (title) => async (dispatch) => {
        await titleAPI.update(title)
        await refresh(dispatch)
    },
    add: (title) => async (dispatch) => {
        await titleAPI.add(title)
        await refresh(dispatch)
    },
    findById: (id) => (dispatch) => titleAPI.findById(id)
}


export default titlesReducer