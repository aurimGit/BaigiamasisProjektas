package lt.codeacademy.movie.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import lt.codeacademy.movie.entities.Movie;

@Controller
public class MainController {

	@GetMapping()
	public String start() {
		return "menu";
	}

	@GetMapping("/menu")
	public String showMovieMenu(Movie movie) {
		return "menu";
	}

	@GetMapping("/contacts")
	public String showContacts() {
		return "contacts";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/tos")
	public String showTos() {
		return "tos";
	}
	
	@GetMapping("/profile")
	public String showProfile() {
		return "profile";
	}

}
