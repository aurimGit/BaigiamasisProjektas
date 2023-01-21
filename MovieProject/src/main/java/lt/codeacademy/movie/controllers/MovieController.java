package lt.codeacademy.movie.controllers;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import lt.codeacademy.movie.entities.Movie;
import lt.codeacademy.movie.entities.Theater;
import lt.codeacademy.movie.repositories.MovieRepository;
import lt.codeacademy.movie.repositories.TheaterRepository;

@Controller
public class MovieController {
	@Autowired
	MovieRepository movieRepos;
	@Autowired
	TheaterRepository theaterRepos;

	@GetMapping("/moviepost")
	public String showMoviePostForm(Movie movie, Model model, Theater theater) {
		model.addAttribute("movies", movieRepos.findAll());
		List<Theater> teatras = theaterRepos.findAll();
		model.addAttribute("theaters", teatras);
		return "add-movie";
	}

	@PostMapping("/addmovie")
	public String addMovie(@Valid Movie movie, @Valid Theater theater, BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        return "add-movie";
	    }

	    movieRepos.save(movie);
	    theaterRepos.save(theater);
	    return "redirect:/movielist";
	}

	@GetMapping("/movielist")
	public String showMovieList(Model model) {
		model.addAttribute("movies", movieRepos.findAll());
		return "movie-list";
	}

	@PostMapping("/update/movie/{id}")
	public String updateMovie(@PathVariable("id") long id, @Valid Movie movie, BindingResult result, Model model) {
		if (result.hasErrors()) {
			movie.setId(id);
			return "update-movie";
		}

		movieRepos.save(movie);
		return "redirect:/movielist";
	}

	@GetMapping("/edit/movie/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Movie movie = movieRepos.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid blog Id:" + id));
		model.addAttribute("movie", movie);

		return "update-movie";
	}

	@PostMapping("/reading/movie/{id}")
	public String readMovie(@PathVariable("id") long id, @Valid Movie movie, BindingResult result, Model model) {
		if (result.hasErrors()) {
			movie.setId(id);
			return "read-movie";
		}

		movieRepos.save(movie);
		return "redirect:/movielist";
	}

	@GetMapping("/read/movie/{id}")
	public String showReadingForm(@PathVariable("id") long id, Model model) {
		Movie movie = movieRepos.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid movie Id:" + id));
		model.addAttribute("movie", movie);

		return "read-movie";
	}

	@GetMapping("/delete/movie/{id}")
	public String deleteMovie(@PathVariable("id") long id, Model model) {
		Movie movie = movieRepos.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid movie Id:" + id));
		movieRepos.delete(movie);
		return "redirect:/movielist";
	}

}
