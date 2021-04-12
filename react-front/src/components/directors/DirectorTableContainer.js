import {connect} from "react-redux";
import React, {useEffect} from "react"
import DirectorTable from "./DirectorTable";
import {directorThunkCreator} from "../../redux/reducers/directors-reducer";


let mapStateToProps = (state) => {
    return {
        directors: state.directorsPage.directors
    }
}

const DirectorTableContainer = (props) => {
    useEffect(() => props.findAll(), [])
    return (
        <DirectorTable directors={props.directors}/>
    )
}


export default connect(mapStateToProps, {
        findAll: directorThunkCreator.findAll
    }
)(DirectorTableContainer)