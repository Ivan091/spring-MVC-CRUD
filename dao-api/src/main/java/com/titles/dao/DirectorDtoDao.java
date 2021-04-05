package com.titles.dao;

import com.titles.model.DirectorDto;
import java.util.Optional;


public interface DirectorDtoDao {

    Optional<DirectorDto> findByIdCalculatingProfit(int id);
}
