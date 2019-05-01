package com.horn.seed.user.service;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.horn.seed.user.domain.User;
import com.horn.seed.user.repository.UserRepository;
import com.horn.seed.user.service.impl.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
// LIght weight unit test, so we are not going to invove spring in this because
// we are testing a very thin slice
// No involving spring at all
public class UserServiceTest {

	@Mock
	private UserRepository userRepository;

	private UserService userService;

	@Before
	public void setup() {
		userService = new UserServiceImpl(userRepository);
	}

	@Test
	public void getUserDetailsTest() {
		User userMock = new User();
		userMock.setId(101L);
		userMock.setEmail("something@email.com");
		userMock.setName("abhishek");

		Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(userMock));
		User userDetails = userService.getUserDetails(101L);
		Assertions.assertThat(userDetails.getName()).isEqualTo("abhishek");
		Assertions.assertThat(userDetails.getEmail()).isEqualTo("something@email.com");

	}
}
