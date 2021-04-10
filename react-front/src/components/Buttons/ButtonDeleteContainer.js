import {connect} from "react-redux";
import {deleteDirector} from "../../redux/reducers/directors-reducer";
import ButtonDelete from "./ButtonDelete";


let mapState = (state, ownProps) => {
    return {
        id: ownProps.id
    }
}

const ButtonDeleteContainer = connect(mapState, {deleteDirector})(ButtonDelete)

export default ButtonDeleteContainer