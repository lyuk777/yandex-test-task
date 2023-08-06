package org.yandex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.yandex.dto.StreetsDto;
import org.yandex.exception.ResourceNotFoundException;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RestTests {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	void restTest() {
		ResponseEntity<StreetsDto> response = testRestTemplate.exchange("/api/v1/streets", HttpMethod.GET, null, StreetsDto.class);
		Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
		Assertions.assertNotNull(response.getBody());

		Assertions.assertEquals(
				testRestTemplate.exchange("/api/v1/streets?cityName=Питер", HttpMethod.GET, null, StreetsDto.class).getStatusCode(),
				HttpStatus.NOT_FOUND
		);
	}

}
