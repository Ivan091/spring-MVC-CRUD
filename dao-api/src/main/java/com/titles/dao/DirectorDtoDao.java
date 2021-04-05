package com.titles.dao;

import com.titles.model.DirectorDto;
import java.util.List;


public interface DirectorDtoDao {

    List<DirectorDto> findAllCalculatingProfit();
}
