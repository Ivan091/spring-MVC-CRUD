package edu.titles.service;

import edu.titles.api.TitleDto;
import edu.titles.repo.TitleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public final class TitleService {

    @Autowired
    TitleRepo titleRepo;

    public List<TitleDto.WithDirectorFullName> findAllWithDirectorFullName() {
        return titleRepo.findWithAverageParams()
                .parallelStream()
                .map(TitleDto.WithDirectorFullName::of)
                .collect(Collectors.toList());
    }

    public List<TitleDto.WithDirectorFullName> findAllWithDirectorFullNameBetween(LocalDate startDate, LocalDate endDate) {
        return titleRepo.findWithAverageParamsBetween(startDate, endDate)
                .parallelStream()
                .map(TitleDto.WithDirectorFullName::of)
                .collect(Collectors.toList());
    }

    public Boolean update(TitleDto.Base title) {
        if (titleRepo.existsById(title.getTitleId())) {
            titleRepo.save(title.to());
            return true;
        }
        return false;
    }

    public void create(TitleDto.Base title) {
        titleRepo.save(title.to().withTitleId(null));
    }

    public Optional<TitleDto.Base> findById(Integer titleId) {
        return titleRepo.findById(titleId).map(TitleDto.Base::of);
    }

    public void delete(Integer titleId) {
        titleRepo.deleteById(titleId);
    }
}
