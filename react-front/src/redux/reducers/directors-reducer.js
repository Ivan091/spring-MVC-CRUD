import {directorAPI} from "../../api/director";

const EDIT = "EDIT"
const DELETE = 'DELETE'
const FIND_ALL = 'FIND_ALL'

let initState = {
    directors: [
        {
            "name": "John",
            "surname": "Smith",
            "birthDate": "1960-07-25",
            "id": 1,
            "profitMultiplier": 2,
            "profitAverage": 50
        },
        {
            "name": "Steven",
            "surname": "Spielberg",
            "birthDate": "1976-01-06",
            "id": 2,
            "profitMultiplier": 3.5,
            "profitAverage": 500
        },
        {
            "name": "Quentin",
            "surname": "Tarantino",
            "birthDate": "1963-03-27",
            "id": 3,
            "profitMultiplier": 3.607143,
            "profitAverage": 492.85715
        },
        {
            "name": "Quentin",
            "surname": "Tarantino",
            "birthDate": "1963-03-27",
            "id": 4,
            "profitMultiplier": 0,
            "profitAverage": 0
        },
    ],
    updatingDirector: null,
}

const directorsReducer = (state = initState, action) => {
    switch (action.type) {
        case FIND_ALL: {
            return {...state, directors: action.directors}
        }
        case DELETE: {
            debugger
            return {...state, directors: state.directors.filter(x => x.id !== action.id)}
        }
        case EDIT: {
            state.updatingDirector = state.directors.find(x => x.id === action.id)
            return {...state, updatingDirector: state.directors.find(x => x.id === action.id)};
        }
        default :
            return state
    }
}

export const directorActionCreator = {
    delete: (id) => ({type: DELETE, id: id}),
    update: (id) => ({type: EDIT, id: id}),
    findAll: (directors) => ({type: FIND_ALL, directors: directors}),
}

export const directorThunkCreator = {
    findAll: () => (dispatch) => directorAPI.findAll().then(data =>
        dispatch(directorActionCreator.findAll(data))
    ),
    delete: (id) => (dispatch) => {
        debugger
        directorAPI.delete(id).then(r => r)
        dispatch(directorActionCreator.delete(id))
    }
}


export default directorsReducer