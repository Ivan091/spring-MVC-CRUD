import {titleAPI} from "../../api/title";

const FIND_ALL_TITLES = 'FIND_ALL'

let initState = {
    titles: [],
}

const titlesReducer = (state = initState, action) => {
    switch (action.type) {
        case FIND_ALL_TITLES: {
            return {...state, titles: action.titles}
        }
        default :
            return state
    }
}

export const titleActionCreator = {
    findAll: (titles) => ({type: FIND_ALL_TITLES, titles: titles}),
}

export const titleThunkCreator = {
    findAll: () => (dispatch) => {
        titleAPI.findAll().then(data => {
            dispatch(titleActionCreator.findAll(data))
        })
    },
    find: () => (dispatch) => titleAPI.findAll(),

    delete: (id) => (dispatch) => {
        titleAPI.delete(id)
            .then(() => titleAPI.findAll()
                .then(x => dispatch(titleActionCreator.findAll(x))))
    },
    update: (x) => (dispatch) => {
        titleAPI.update(x)
            .then(() => titleAPI.findAll()
                .then(x => dispatch(titleActionCreator.findAll(x))))
    },
    add: (x) => (dispatch) => {
        titleAPI.add(x)
            .then(() => titleAPI.findAll()
                .then(x => dispatch(titleActionCreator.findAll(x))))
    },
    findById: (id) => (dispatch) => titleAPI.findById(id)
}


export default titlesReducer