import {connect} from "react-redux";
import ButtonNavLink from "./ButtonNavLink";


let mapState = (state, ownProps) => ({...ownProps})

export default connect(mapState)(ButtonNavLink)