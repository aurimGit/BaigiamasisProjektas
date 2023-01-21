package lt.codeacademy.movie.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class MainControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	public void testShowMenu() throws Exception {
	    mockMvc.perform(get("/menu"))
	        .andExpect(status().isOk())
	        .andExpect(view().name("menu"));
	}
	
	@Test
	public void testShowContacts() throws Exception {
	    mockMvc.perform(get("/contacts"))
	        .andExpect(status().isOk())
	        .andExpect(view().name("contacts"));
	}
	
	@Test
	public void testShowLogin() throws Exception {
	    mockMvc.perform(get("/login"))
	        .andExpect(status().isOk())
	        .andExpect(view().name("login"));
	}

	@Test
	public void testShowTos() throws Exception {
	    mockMvc.perform(get("/tos"))
	        .andExpect(status().isOk())
	        .andExpect(view().name("tos"));
	}
	
	@Test
	public void testShowStart() throws Exception {
	    mockMvc.perform(get("/"))
	        .andExpect(status().isOk())
	        .andExpect(view().name("menu"));
	}

	
	
	
}
