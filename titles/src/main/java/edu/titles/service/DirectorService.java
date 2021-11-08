package edu.titles.service;

import edu.titles.api.DirectorDto;
import edu.titles.repo.DirectorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public final class DirectorService {

    @Autowired
    DirectorRepo directorRepo;

    public List<DirectorDto.WithAverageParams> findAllCalculatingProfit() {
        return directorRepo.findDirectorCalculatingAverageParams()
                .stream()
                .map(DirectorDto.WithAverageParams::of)
                .collect(Collectors.toList());
    }

    public Optional<DirectorDto.WithId> findById(Integer id) {
        return directorRepo.findById(id).map(DirectorDto.WithId::of);
    }

    public Boolean update(DirectorDto.WithId directorDtoBase) {
        if (directorRepo.existsById(directorDtoBase.getDirectorId())) {
            directorRepo.save(directorDtoBase.to());
            return true;
        }
        return false;
    }

    public void create(DirectorDto.Base directorDtoBase) {
        directorRepo.save(directorDtoBase.to());
    }

    public void delete(Integer directorId) {
        directorRepo.deleteById(directorId);
    }
}
