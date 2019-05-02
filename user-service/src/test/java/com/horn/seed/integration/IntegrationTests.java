package com.horn.seed.integration;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.horn.user.domain.User;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	// @Test
	public void testGetUser() {
		// arrange
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "101");
		// act
		ResponseEntity<User> response = restTemplate.getForEntity("/getUser", User.class, params);

		// assert
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getName()).isEqualTo("abhishek");
		assertThat(response.getBody().getEmail()).isEqualTo("something@email.com");

	}

}
