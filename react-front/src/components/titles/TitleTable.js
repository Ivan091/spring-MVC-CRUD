import React from 'react'
import TableGeneric from "../table/TableGeneric";
import ButtonNavLinkContainer from "../buttons/ButtonNavLinkContainer";
import {AddCircleOutlined, EditSharp} from "@material-ui/icons";
import ButtonDeleteTitleContainer from "./ButtonDeleteTitleContainer";
import {Box} from "@material-ui/core";

const TitleTable = ({titles}) => {
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
                        <ButtonDeleteTitleContainer key={titleId + "deleteButton"} id={titleId}/>
                    </>
                )}
            />
        </Box>
    )
}

export default TitleTable
