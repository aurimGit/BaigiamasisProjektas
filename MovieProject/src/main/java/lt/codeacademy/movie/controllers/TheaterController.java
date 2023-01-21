package lt.codeacademy.movie.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import lt.codeacademy.movie.entities.Theater;
import lt.codeacademy.movie.repositories.TheaterRepository;

@Controller
public class TheaterController {
	@Autowired
	TheaterRepository theaterRepository;

	@GetMapping("/theaterpost")
	public String showTheaterPostForm(Theater theater) {
		return "add-theater";
	}
	
	@PostMapping("/addtheater")
	public String addTheater(@Valid Theater theater, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-theater";
		}

		theaterRepository.save(theater);
		return "redirect:/theaterlist";
	}

	@GetMapping("/theaterlist")
	public String showTheaterList(Model model) {
		model.addAttribute("theaters", theaterRepository.findAll());
		return "theater-list";
	}

	@PostMapping("/update/theater/{id}")
	public String updateTheater(@PathVariable("id") long id, @Valid Theater theater, BindingResult result, Model model) {
		if (result.hasErrors()) {
			theater.setId(id);
			return "update-theater";
		}

		theaterRepository.save(theater);
		return "redirect:/theaterlist";
	}

	@GetMapping("/edit/theater/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Theater theater = theaterRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid theater Id:" + id));
		model.addAttribute("theater", theater);

		return "update-theater";
	}

	@PostMapping("/reading/theater/{id}")
	public String readTheater(@PathVariable("id") long id, @Valid Theater theater, BindingResult result, Model model) {
		if (result.hasErrors()) {
			theater.setId(id);
			return "read-theater";
		}

		theaterRepository.save(theater);
		return "redirect:/theaterlist";
	}

	@GetMapping("/read/theater/{id}")
	public String showReadingForm(@PathVariable("id") long id, Model model) {
		Theater theater = theaterRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid theater Id:" + id));
		model.addAttribute("theater", theater);

		return "read-theater";
	}

	@GetMapping("/delete/theater/{id}")
	public String deleteTheater(@PathVariable("id") long id, Model model) {
		Theater theater = theaterRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid theater Id:" + id));
		theaterRepository.delete(theater);
		return "redirect:/theaterlist";
	}

}
