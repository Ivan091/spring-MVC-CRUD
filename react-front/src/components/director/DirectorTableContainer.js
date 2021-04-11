import {connect} from "react-redux";
import DirectorTable from "./DirectorTable";
import React from "react"
import {directorThunkCreator} from "../../redux/reducers/directors-reducer";


class directorTableContainer extends React.Component {
    componentDidMount() {
        this.props.findAll();
    }

    render() {
        return (
            <DirectorTable directors={this.props.directors}/>
        )
    }
}

let mapStateToProps = (state) => {
    return {
        directors: state.directorsPage.directors
    }
}


export default connect(mapStateToProps, {
        findAll: directorThunkCreator.findAll
    }
)(directorTableContainer)