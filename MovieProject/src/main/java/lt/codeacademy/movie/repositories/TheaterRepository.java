package lt.codeacademy.movie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.codeacademy.movie.entities.Theater;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Long> {

}
