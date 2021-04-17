import {connect} from "react-redux";
import React, {useCallback, useEffect} from "react"
import {directorThunkCreator} from "../../redux/reducers/directors-reducer";
import TableGeneric from "../table/TableGeneric";
import {Box} from "@material-ui/core";
import ButtonNavLinkContainer from "../buttons/ButtonNavLinkContainer";
import {AddCircleOutlined, EditSharp} from "@material-ui/icons";
import ButtonDeleteDirectorContainer from "./ButtonDeleteDirectorContainer";


const DirectorTableContainer = ({requestAll, directors}) => {
    const request = useCallback(() => requestAll(), [requestAll])
    useEffect(() => {
        request()
    }, [request])
    return (
        <Box m={5}>
            <TableGeneric
                items={directors}
                keyOfItem={(item) => item.directorId}
                headers={[
                    {fieldName: "name", label: "Name"},
                    {fieldName: "surname", label: "Surname"},
                    {fieldName: "birthDate", label: "Birth Date"},
                    {fieldName: "profitAverage", label: "Average Profit"},
                    {fieldName: "profitMultiplier", label: "Profit Multiplier"},
                ]}
                generateLastColumnHeader={(headers) =>
                    <ButtonNavLinkContainer
                        title={"Add"}
                        inner={<AddCircleOutlined color={"primary"}/>}
                        url={"directors/add"}/>
                }
                generateLastColumnBody={({directorId}) => (
                    <>
                        <ButtonNavLinkContainer
                            key={directorId + "editButton"}
                            title={"Edit"}
                            inner={<EditSharp/>}
                            url={`directors/${directorId}`}/>
                        <ButtonDeleteDirectorContainer key={directorId + "deleteButton"} id={directorId}/>
                    </>
                )}
            />
        </Box>
    )
}

let mapStateToProps = (state) => {
    return {
        directors: state.directorsPage.directors
    }
}

export default connect(mapStateToProps, {
    requestAll: directorThunkCreator.requestAll
})(DirectorTableContainer)