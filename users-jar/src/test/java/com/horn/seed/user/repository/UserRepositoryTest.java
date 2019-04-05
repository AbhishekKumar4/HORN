package com.horn.seed.user.repository;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.horn.seed.user.domain.User;

@RunWith(SpringRunner.class)
@DataJpaTest
// wont load any other web context what web mvc was doing
public class UserRepositoryTest {

	private UserRepository userRepository;

	@Test
	public void getUserDetailsTest() throws Exception {
		//User userDetails = userRepository.findById((long) 101);
		//Assertions.assertThat(userDetails.getName()).isEqualTo("abhishek");
		//Assertions.assertThat(userDetails.getEmail()).isEqualTo("something@email.com");
	}
}
