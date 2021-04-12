import {connect} from "react-redux";
import TitleTable from "./TitleTable";
import React, {useEffect} from "react"
import {titleThunkCreator} from "../../redux/reducers/titles-reducer";


let mapStateToProps = (state) => {
    return {
        titles: state.titlesPage.titles
    }
}

const TitleTableContainer = (props) => {
    useEffect(() => props.findAll(), [])
    return (
        <TitleTable titles={props.titles}/>
    )
}


export default connect(mapStateToProps, {
        findAll: titleThunkCreator.findAll
    }
)(TitleTableContainer)