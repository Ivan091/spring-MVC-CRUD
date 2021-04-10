import {connect} from "react-redux";
import DirectorTable from "./DirectorTable";

let mapStateToProps = (state) => {
    return {
        directors: state.directors.directors
    }
}

const DirectorsContainer = connect(mapStateToProps)(DirectorTable)

export default DirectorsContainer