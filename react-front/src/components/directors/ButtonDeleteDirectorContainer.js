import {connect} from "react-redux";
import {directorThunkCreator} from "../../redux/reducers/directors-reducer";
import ButtonDeleteById from "../buttons/ButtonDeleteById";


let mapState = (state, ownProps) => {
    return {
        id: ownProps.id
    }
}

export default connect(mapState,
    {
        delete: directorThunkCreator.delete
    }
)(ButtonDeleteById)