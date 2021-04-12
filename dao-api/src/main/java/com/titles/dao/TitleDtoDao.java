package com.titles.dao;

import com.titles.model.TitleWithDirectorFullNameDto;
import java.util.List;


public interface TitleDtoDao {

    public List<TitleWithDirectorFullNameDto> findAllTitlesWithDirectorFullName();
}
