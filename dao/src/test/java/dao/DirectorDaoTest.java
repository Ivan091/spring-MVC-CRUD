package dao;

import model.Director;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Date;
import java.util.stream.IntStream;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath*:test-db.xml", "classpath*:test-dao.xml"})
class DirectorDaoTest {

    private final Director newEntity = new Director(4, "Ivan", "Karnasevich", Date.valueOf("2002-07-19"));

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
            var r = directorDao.findAll();
            Assertions.assertTrue(directorDao.findById(i).isEmpty());
        });
    }

    @Test
    void create() {
        Assertions.assertEquals(newEntity.getDirectorId(), directorDao.create(newEntity));
        Assertions.assertEquals(newEntity, directorDao.findById(newEntity.getDirectorId()).orElseThrow());
    }

    @Test
    void update() {
        directorDao.create(newEntity);
        var secondNew = new Director(newEntity.getDirectorId(), "Name", "Surname", Date.valueOf("1971-01-01"));
        directorDao.update(secondNew);
        Assertions.assertEquals(secondNew, directorDao.findById(secondNew.getDirectorId()).orElseThrow());
    }
}