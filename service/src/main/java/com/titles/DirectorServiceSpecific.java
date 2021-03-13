package com.titles;

import com.titles.service.DirectorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class DirectorServiceSpecific implements DirectorService {

    @Override
    public double calculateAverageProfit() {
        return 0;
    }
}
