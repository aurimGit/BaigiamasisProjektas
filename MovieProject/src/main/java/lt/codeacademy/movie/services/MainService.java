package lt.codeacademy.movie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.codeacademy.movie.entities.Movie;
import lt.codeacademy.movie.repositories.MovieRepository;

@Service
public class MainService {

	@Autowired
	MovieRepository movieRepos;

	public List<Movie> getMovie() {
		return movieRepos.findAll();
	}

	public String saveMovie(Movie movie) {
		movieRepos.save(movie);
		return "yes";
	}
}	
