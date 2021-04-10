import React from 'react'
import {Box, IconButton, Table, TableBody, TableCell, TableHead, TableRow, Tooltip} from "@material-ui/core";
import {AddCircleOutlined} from "@material-ui/icons";
import ButtonDeleteContainer from "../Buttons/ButtonDeleteContainer";
import ButtonUpdateContainer from "../Buttons/ButtonUpdateContainer";

const lastColumnConfig = {
    width: "10%",
}

const DirectorTable = (props) => {

    let directorRows = props.directors.map(director =>
        <TableRow>
            <TableCell>{director.name}</TableCell>
            <TableCell>{director.surname}</TableCell>
            <TableCell>{director.birthDate}</TableCell>
            <TableCell>{director.profitAverage}</TableCell>
            <TableCell>{director.profitMultiplier}</TableCell>
            <TableCell style={lastColumnConfig}>
                <ButtonUpdateContainer director={director}/>
                <ButtonDeleteContainer id={director.id}/>
            </TableCell>
        </TableRow>
    )
    return (
        <Box m={5}>
            <Table>
                <TableHead>
                    <TableCell>Name</TableCell>
                    <TableCell>Surname</TableCell>
                    <TableCell>Birth Date</TableCell>
                    <TableCell>Profit Average</TableCell>
                    <TableCell>Profit Multiplier</TableCell>
                    <TableCell style={lastColumnConfig}>
                        <Tooltip title={"Add"}>
                            <IconButton>
                                <AddCircleOutlined color={"primary"}/>
                            </IconButton>
                        </Tooltip>
                    </TableCell>
                </TableHead>
                <TableBody>
                    {directorRows}
                </TableBody>
            </Table>
        </Box>
    )
}

export default DirectorTable
