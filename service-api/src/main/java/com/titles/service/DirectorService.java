package com.titles.service;

import com.titles.model.Director;
import com.titles.model.DirectorDto;
import java.util.List;


public interface DirectorService extends ServiceDao<Director> {

    List<DirectorDto> findAllCalculatingProfit();
}
