import React from 'react'
import {Box, Table, TableBody, TableCell, TableHead, TableRow} from "@material-ui/core";
import ButtonDeleteContainer from "./ButtonDeleteDirectorContainer";
import ButtonNavLinkContainer from "../buttons/ButtonNavLinkContainer";
import {AddCircleOutlined, EditSharp} from "@material-ui/icons";

const lastColumnConfig = {
    width: "10%",
}

const DirectorTable = (props) => {
    let tableHead = (
        <TableHead>
            <TableCell>Name</TableCell>
            <TableCell>Surname</TableCell>
            <TableCell>Birth Date</TableCell>
            <TableCell>Profit Average</TableCell>
            <TableCell>Profit Multiplier</TableCell>
            <TableCell style={lastColumnConfig}>
                <ButtonNavLinkContainer
                    title={"Add"}
                    inner={<AddCircleOutlined color={"primary"}/>}
                    url={"directors/add"}/>
            </TableCell>
        </TableHead>
    )

    let tableBody = props.directors.map(director =>
        <TableBody>
            <TableRow>
                <TableCell>{director.name}</TableCell>
                <TableCell>{director.surname}</TableCell>
                <TableCell>{director.birthDate}</TableCell>
                <TableCell>{director.profitAverage}</TableCell>
                <TableCell>{director.profitMultiplier}</TableCell>
                <TableCell style={lastColumnConfig}>
                    <ButtonNavLinkContainer
                        title={"Edit"}
                        inner={<EditSharp/>}
                        url={`directors/${director.directorId}`}/>
                    <ButtonDeleteContainer id={director.directorId}/>
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

export default DirectorTable
