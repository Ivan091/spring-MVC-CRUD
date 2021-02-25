package dao;

import model.Director;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.IntStream;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath*:test-db.xml", "classpath*:test-dao.xml"})
class DirectorDaoTest {

    @Autowired
    private Dao<Director> directorDao;

    @Test
    void findAll() {
        var result = directorDao.findAll();
        Assertions.assertEquals(3, result.size());
    }

    @Test
    void delete() {
        IntStream.range(1, 4).forEach(i -> {
            Assertions.assertTrue(directorDao.findById(i).isPresent());
            directorDao.delete(i);
            Assertions.assertTrue(directorDao.findById(i).isEmpty());
        });
    }
}