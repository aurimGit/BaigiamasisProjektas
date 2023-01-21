package lt.codeacademy.movie.controllers;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import lt.codeacademy.movie.entities.Movie;
import lt.codeacademy.movie.repositories.MovieRepository;
import lt.codeacademy.movie.repositories.TheaterRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class MovieControllerTest {
	
	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieRepository movieRepos;

    @MockBean
    private TheaterRepository theaterRepos;
    
    @Test
	public void shouldReadMovieById() throws Exception {
		this.mockMvc
			.perform(post("/reading/movie/{id}", 1L).with(csrf()))
			.andExpect(status().isFound())
			.andExpect(redirectedUrl("/movielist"));
	}
    
    
    @WithMockUser(username="Admin")
	@Test
	public void shouldShowMoviePostForm() throws Exception {
		this.mockMvc
			.perform(get("/moviepost"))
			.andExpect(view().name("add-movie"))
	        .andExpect(status().isOk());
	}
	
	@Test
	public void shouldReturnAllMovies() throws Exception {
		this.mockMvc
		    .perform(get("/movielist"))
		    .andExpect(status().isOk())
		    .andExpect(view().name("movie-list"))
		    .andExpect(model().attributeExists("movies"));
	}
	
	@WithMockUser(username="Admin")
	@Test
	public void shouldAddMovie() throws Exception {
		this.mockMvc
		    .perform(post("/addmovie").secure(true).with(csrf()))
		    .andExpect(status().isFound())
		    .andExpect(redirectedUrl("/movielist"));
	}
	
	@WithMockUser(username="Admin")
	@Test
	public void shouldUpdateMovieById() throws Exception {
		this.mockMvc
			.perform(post("/update/movie/{id}", 1L).secure(true).with(csrf()))
			.andExpect(status().isFound())
			.andExpect(redirectedUrl("/movielist"));
	}
	
	@WithMockUser(username="Admin")
	@Test
	public void testDeleteMovie() throws Exception {

	    Movie testMovie = new Movie();
	    testMovie.setId(1);
	    testMovie.setTitle("Test Movie");
	    movieRepos.save(testMovie);


	    mockMvc.perform(delete("/delete/movie/1"))
	    	.andExpect(status().isOk())
	        .andExpect(redirectedUrl("/movielist"));


	    Optional<Movie> deletedMovie = movieRepos.findById((long) 1);
	    assertFalse(deletedMovie.isPresent());
	}
	
	
	
	
	
}
