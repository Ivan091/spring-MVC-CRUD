const EDIT_DIRECTOR = "EDIT_DIRECTOR"
const DELETE_DIRECTOR = 'DELETE_DIRECTOR'

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
        {
            "name": "Quentin",
            "surname": "Tarantino",
            "birthDate": "1963-03-27",
            "id": 5,
            "profitMultiplier": 0,
            "profitAverage": 0
        },
        {
            "name": "Quentin",
            "surname": "Tarantino",
            "birthDate": "1963-03-27",
            "id": 6,
            "profitMultiplier": 0,
            "profitAverage": 0
        },
        {
            "name": "Quentin",
            "surname": "Tarantino",
            "birthDate": "1963-03-27",
            "id": 7,
            "profitMultiplier": 0,
            "profitAverage": 0
        },
        {
            "name": "Quentin",
            "surname": "Tarantino",
            "birthDate": "1963-03-27",
            "id": 8,
            "profitMultiplier": 0,
            "profitAverage": 0
        },
        {
            "name": "Quentin",
            "surname": "Tarantino",
            "birthDate": "1963-03-27",
            "id": 9,
            "profitMultiplier": 0,
            "profitAverage": 0
        },
        {
            "name": "Quentin",
            "surname": "Tarantino",
            "birthDate": "1963-03-27",
            "id": 10,
            "profitMultiplier": 0,
            "profitAverage": 0
        },
        {
            "name": "Quentin",
            "surname": "Tarantino",
            "birthDate": "1963-03-27",
            "id": 11,
            "profitMultiplier": 0,
            "profitAverage": 0
        },
        {
            "name": "Quentin",
            "surname": "Tarantino",
            "birthDate": "1963-03-27",
            "id": 12,
            "profitMultiplier": 0,
            "profitAverage": 0
        },
        {
            "name": "Quentin",
            "surname": "Tarantino",
            "birthDate": "1963-03-27",
            "id": 13,
            "profitMultiplier": 0,
            "profitAverage": 0
        },
        {
            "name": "Quentin",
            "surname": "Tarantino",
            "birthDate": "1963-03-27",
            "id": 14,
            "profitMultiplier": 0,
            "profitAverage": 0
        }
    ],
    editingDirector: {},
}

const directorsReducer = (state = initState, action) => {
    switch (action.type) {
        case DELETE_DIRECTOR:
            let stateCopy = {...state}
            stateCopy.directors = stateCopy.directors.filter(x => x.id !== action.id)
            return stateCopy
        case EDIT_DIRECTOR:
            state.editingDirector = action.director
            return state;
        default :
            return state
    }
}

export const deleteDirector = (id) => ({type: DELETE_DIRECTOR, id: id})

export const updateDirector = (director) => ({type: EDIT_DIRECTOR, director: director})

export default directorsReducer