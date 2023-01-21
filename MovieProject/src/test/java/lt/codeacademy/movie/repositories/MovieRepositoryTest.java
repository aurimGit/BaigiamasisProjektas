package lt.codeacademy.movie.repositories;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class MovieRepositoryTest {


    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void testFindByTitle() {

}
}
