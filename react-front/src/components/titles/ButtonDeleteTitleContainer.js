import {connect} from "react-redux";
import ButtonDeleteById from "../buttons/ButtonDeleteById";
import {titleThunkCreator} from "../../redux/reducers/titles-reducer";


let mapState = (state, ownProps) => {
    return {
        id: ownProps.id
    }
}

export default connect(mapState, {delete: titleThunkCreator.delete})(ButtonDeleteById)