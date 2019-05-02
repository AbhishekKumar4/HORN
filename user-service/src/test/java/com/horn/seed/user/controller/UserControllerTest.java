package com.horn.seed.user.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.horn.user.controller.UserController;
import com.horn.user.domain.User;
import com.horn.user.service.UserService;

@RunWith(SpringRunner.class)
// Doesnot start entire spring boot application, only starts the needed
// components
@WebMvcTest(UserController.class)
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService userService;

	@Test
	public void getUserDetailsTest() throws Exception {

		User userMock = new User();
		userMock.setId(101L);
		userMock.setEmail("something@email.com");
		userMock.setName("abhishek");

		Mockito.when(userService.getUserDetails(Mockito.anyLong())).thenReturn(userMock);

		mockMvc.perform(get("/getUserDetails?userId=101")).andExpect(status().isOk())
				.andExpect(jsonPath("name").value("abhishek"))
				.andExpect(jsonPath("email").value("something@email.com"));
	}

	@Test
	public void registerUserTest() throws Exception {
		User user = new User();
		user.setName("abhishek");
		user.setEmail("something@email.com");

		mockMvc.perform(post("/registerUser").contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
				.andExpect(status().isOk());

		Mockito.verify(userService, Mockito.times(1)).registerUser(Mockito.any(User.class));
	}

	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
