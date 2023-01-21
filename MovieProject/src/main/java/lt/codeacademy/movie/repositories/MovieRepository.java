package lt.codeacademy.movie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.codeacademy.movie.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
