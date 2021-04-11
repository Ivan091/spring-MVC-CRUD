import {connect} from "react-redux";
import {directorActionCreator} from "../../redux/reducers/directors-reducer";
import ButtonUpdate from "./ButtonUpdate";


let mapState = (state, ownProps) => {
    return {
        id: ownProps.id
    }
}

export default connect(mapState, {
        update: directorActionCreator.update
    }
)(ButtonUpdate)