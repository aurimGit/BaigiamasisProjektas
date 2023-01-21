package lt.codeacademy.movie.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import lt.codeacademy.movie.entities.User;
import lt.codeacademy.movie.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	
	User save(UserRegistrationDto registrationDto);

}
	