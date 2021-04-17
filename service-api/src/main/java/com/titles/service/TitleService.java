package com.titles.service;

import com.titles.model.Title;
import com.titles.model.TitleWithDirectorFullNameDto;
import java.time.LocalDate;
import java.util.List;


public interface TitleService extends ServiceDao<Title> {

    List<TitleWithDirectorFullNameDto> findAllTitlesWithDirectorFullName();

    List<TitleWithDirectorFullNameDto> findAllTitlesBetween(LocalDate start, LocalDate end);
}
