package lt.codeacademy.movie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.codeacademy.movie.entities.Theater;
import lt.codeacademy.movie.repositories.TheaterRepository;

@Service
public class TheaterService {

	@Autowired
	TheaterRepository theaterRepository;

	public List<Theater> getTheater() {
		return theaterRepository.findAll();
	}

	public String saveTheater(Theater theater) {
		theaterRepository.save(theater);
		return "yes";
	}

}
