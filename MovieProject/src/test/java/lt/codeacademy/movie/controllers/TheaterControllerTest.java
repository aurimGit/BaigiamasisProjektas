package lt.codeacademy.movie.controllers;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import lt.codeacademy.movie.repositories.MovieRepository;
import lt.codeacademy.movie.repositories.TheaterRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class TheaterControllerTest {
	
	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieRepository movieRepos;

    @MockBean
    private TheaterRepository theaterRepos;
    
    @Test
	public void shouldReadTheaterById() throws Exception {
		this.mockMvc
			.perform(post("/reading/theater/{id}", 1L).with(csrf()))
			.andExpect(status().isFound())
			.andExpect(redirectedUrl("/theaterlist"));
	}
    
    
    @WithMockUser(username="Admin")
	@Test
	public void shouldShowTheaterPostForm() throws Exception {
		this.mockMvc
		.perform(get("/theaterpost"))
		.andExpect(view().name("add-theater"))
        .andExpect(status().isOk());
	}
	
	@Test
	public void shouldReturnAllTheaters() throws Exception {
		this.mockMvc
	      .perform(get("/theaterlist"))
	      .andExpect(status().isOk())
	      .andExpect(view().name("theater-list"))
	      .andExpect(model().attributeExists("theaters"));
	}
	
	@WithMockUser(username="Admin")
	@Test
	public void shouldAddTheater() throws Exception {
		this.mockMvc
	      .perform(post("/addtheater").secure(true).with(csrf()))
	      .andExpect(status().isFound())
	      .andExpect(redirectedUrl("/theaterlist"));
	}
	
	@WithMockUser(username="Admin")
	@Test
	public void shouldUpdateTheaterById() throws Exception {
		this.mockMvc
			.perform(post("/update/theater/{id}", 1L).secure(true).with(csrf()))
			.andExpect(status().isFound())
			.andExpect(redirectedUrl("/theaterlist"));
	}
	
//	@WithMockUser(username="Admin")
//	@Test
//	public void shouldDeleteTheater() throws Exception {
//
//		Theater theater = new Theater();
//	    theater.setCity("New theater");
//	    theaterRepos.save(theater);
//
//	    this.mockMvc
//	        .perform(post("/delete/theater/{id}", theater.getId()).secure(true).with(csrf()))
//	        .andExpect(status().isFound())
//	        .andExpect(redirectedUrl("/theaterlist"));
//
//	    Movie deletedMovie = movieRepos.getById(theater);
//
//	    assertNull(deletedMovie);
//	}
	
	
	
	
	
}
