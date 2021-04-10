import {connect} from "react-redux";
import {updateDirector} from "../../redux/reducers/directors-reducer";
import ButtonUpdate from "./ButtonUpdate";


let mapState = (state, ownProps) => {
    return {
        id: ownProps.director
    }
}

const ButtonUpdateContainer = connect(mapState, {updateDirector})(ButtonUpdate)

export default ButtonUpdateContainer