import {useDispatch, useSelector} from "react-redux";
import React, {useCallback, useEffect} from "react"
import {Box} from "@material-ui/core";
import TableGeneric from "../table/TableGeneric";
import {AddCircleOutlined, EditSharp} from "@material-ui/icons";
import ButtonNavLinkContainer from "../buttons/ButtonNavLinkContainer";
import ButtonDeleteContainer from "./ButtonDeleteTitleContainer";
import {titleThunkCreator} from "../../redux/reducers/titles-reducer";


const TitleTableContainer = props => {
    const titles = useSelector(state => state.titlesPage.titles)
    const dispatch = useDispatch()
    const request = useCallback(() => dispatch(titleThunkCreator.requestAll()), [dispatch])

    useEffect(() => {
        request()
    }, [request])

    return (
        <Box m={5}>
            <TableGeneric
                items={titles}
                keyOfItem={(item) => item.titleId}
                headers={[
                    {fieldName: "name", label: "Name"},
                    {fieldName: "boxOffice", label: "Box Office"},
                    {fieldName: "budget", label: "Budget"},
                    {fieldName: "premiereDate", label: "Premiere Date"},
                    {fieldName: "runtime", label: "Runtime"},
                    {fieldName: "directorFullName", label: "Director Name"},
                ]
                }
                generateLastColumnHeader={(headers) =>
                    <ButtonNavLinkContainer
                        title={"Add"}
                        inner={<AddCircleOutlined color={"primary"}/>}
                        url={"titles/add"}/>
                }
                generateLastColumnBody={({titleId}) => (
                    <>
                        <ButtonNavLinkContainer
                            key={titleId + "editButton"}
                            title={"Edit"}
                            inner={<EditSharp/>}
                            url={`titles/${titleId}`}/>
                        <ButtonDeleteContainer key={titleId + "deleteButton"} id={titleId}/>
                    </>
                )}
            />
        </Box>
    )
}

export default TitleTableContainer