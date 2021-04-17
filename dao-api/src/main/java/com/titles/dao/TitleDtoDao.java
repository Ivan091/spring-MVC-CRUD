package com.titles.dao;

import com.titles.model.TitleWithDirectorFullNameDto;
import java.time.LocalDate;
import java.util.List;


public interface TitleDtoDao {

    List<TitleWithDirectorFullNameDto> findAllTitlesWithDirectorFullName();

    List<TitleWithDirectorFullNameDto> findAllTitlesBetween(LocalDate date1, LocalDate date2);
}
