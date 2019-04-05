package com.horn.seed.user.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.horn.seed.user.domain.User;
import com.horn.seed.user.service.UserService;

@RunWith(SpringRunner.class)
//Doesnot start entire spring boot application, only starts the needed components
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
		
		mockMvc.perform(MockMvcRequestBuilders.get("/getUserDetails?userId=101"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("name").value("abhishek"))
		.andExpect(MockMvcResultMatchers.jsonPath("email").value("something@email.com"));
	}
}
