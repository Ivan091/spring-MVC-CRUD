import {useDispatch, useSelector} from "react-redux";
import React, {useCallback, useEffect} from "react"
import {titleThunkCreator} from "../../redux/reducers/titles-reducer";
import TitleTable from "./TitleTable";
import TitlesBetweenForm from "./TitlesBetweenDateForm";


const TitleTableContainer = (props) => {
    const titles = useSelector(state => state.titlesPage.titles)
    const dispatch = useDispatch()
    const request = useCallback(() => dispatch(titleThunkCreator.requestAll()), [dispatch])

    useEffect(() => {
        request()
    }, [request])

    return (
        <>
            <TitlesBetweenForm/>
            <TitleTable titles={titles}/>
        </>
    )
}

export default TitleTableContainer