package dao;

import com.titles.model.Director;
import com.titles.model.DirectorDto;
import java.util.Optional;


public interface DirectorDtoDao extends Dao<Director> {

    Optional<DirectorDto> findByIdCalculatingProfit(int id);
}
