package com.titles.service;

import com.titles.model.Director;
import com.titles.model.DirectorDto;
import java.util.Optional;


public interface DirectorDtoService extends ServiceDao<Director> {

    Optional<DirectorDto> findByIdCalculatingProfit(int id);
}
