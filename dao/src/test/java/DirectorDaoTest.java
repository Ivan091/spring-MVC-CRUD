import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;


@ContextConfiguration(locations = {"classpath*:test-db.xml", "classpath*:test-dao.xml"})
class DirectorDaoTest {

    @Autowired
    private Dao<Director> directorDao;

    @Test
    void findAll() {
        var result = directorDao.findAll();
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.size() > 0);
    }

    @Test
    void findById() {
    }

    @Test
    void update() {
    }

    @Test
    void create() {
    }

    @Test
    void delete() {
    }
}