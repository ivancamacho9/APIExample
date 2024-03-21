package com.rest.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.api.controller.MainController;
import com.rest.api.entities.Users;
import com.rest.api.error.ErrorResponse;
import com.rest.api.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = MainController.class)
@ActiveProfiles("test")
class ApiApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService userService;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private ErrorResponse errorResponse;

	@Test
	void contextLoads() {
	}

	@Test
	void shouldGetAllUsers() throws Exception {
		this.mockMvc.perform(get("/users")).andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	void shouldSaveUser() throws Exception {
		Users users = new Users(null,"test","test");
		this.mockMvc.perform(post("/users")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(users)))
				.andExpect(status().isCreated())
				.andReturn();
	}

}
