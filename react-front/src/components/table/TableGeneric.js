import React from 'react'
import {Table, TableBody, TableCell, TableHead, TableRow} from "@material-ui/core";


const lastColumnConfig = {
    width: "10%",
}

const TableGeneric = ({items, headers, generateLastColumnHeader, generateLastColumnBody, keyOfItem}) => {

    const generateHeaderRow = () => {

        const renderLastColumnHeader = () => {
            if (generateLastColumnHeader)
                return <TableCell style={lastColumnConfig} children={generateLastColumnHeader(headers)}/>
        }

        return (
            <TableRow>
                {headers.map((h, k) => <TableCell key={k}>{h.label}</TableCell>)}
                {renderLastColumnHeader()}
            </TableRow>
        )
    }

    const generateBodyRows = () => {

        const renderLastColumnBody = (item) => {
            if (generateLastColumnBody)
                return <TableCell style={lastColumnConfig}
                                  children={generateLastColumnBody(item)}/>
        }

        const generateBodyRow = (item) => {
            return (
                <TableRow key={keyOfItem(item)}>
                    {headers.map(h => (
                        <TableCell
                            key={keyOfItem(item) + h.fieldName}>{item[h.fieldName]}</TableCell>
                    ))}
                    {renderLastColumnBody(item)}
                </TableRow>)
        }

        return (
            items.map(i => (
                generateBodyRow(i)
            ))
        )
    }

    return (
        <Table>
            <TableHead children={generateHeaderRow()}/>
            <TableBody children={generateBodyRows()}/>
        </Table>
    )
}

export default TableGeneric
