import React from 'react'
import {Box, Table, TableBody, TableCell, TableHead, TableRow} from "@material-ui/core";
import ButtonNavLinkContainer from "../buttons/ButtonNavLinkContainer";
import ButtonDeleteContainer from "./ButtonDeleteTitleContainer";
import {AddCircleOutlined, EditSharp} from "@material-ui/icons";

const lastColumnConfig = {
    width: "10%",
}

const TitleTable = (props) => {
    let tableHead = (
        <TableHead>
            <TableCell>Name</TableCell>
            <TableCell>Box Office</TableCell>
            <TableCell>Budget</TableCell>
            <TableCell>Premiere Date</TableCell>
            <TableCell>Runtime</TableCell>
            <TableCell>Director Name</TableCell>
            <TableCell style={lastColumnConfig}>
                <ButtonNavLinkContainer
                    title={"Add"}
                    inner={<AddCircleOutlined color={"primary"}/>}
                    url={"titles/add"}/>
            </TableCell>
        </TableHead>
    )

    let tableBody = props.titles.map(title =>
        <TableBody>
            <TableRow>
                <TableCell>{title.name}</TableCell>
                <TableCell>{title.boxOffice}</TableCell>
                <TableCell>{title.budget}</TableCell>
                <TableCell>{title.premiereDate}</TableCell>
                <TableCell>{title.runtime}</TableCell>
                <TableCell>{title.directorFullName}</TableCell>
                <TableCell style={lastColumnConfig}>
                    <ButtonNavLinkContainer
                        title={"Edit"}
                        inner={<EditSharp/>}
                        url={`titles/${title.titleId}`}/>
                    <ButtonDeleteContainer id={title.titleId}/>
                </TableCell>
            </TableRow>
        </TableBody>
    )
    return (
        <Box m={5}>
            <Table>
                {tableHead}
                {tableBody}
            </Table>
        </Box>
    )
}

export default TitleTable
