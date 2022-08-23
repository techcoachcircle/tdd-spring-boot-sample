package com.example.car;

import com.example.car.domain.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class IntegrationTests {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void getCar_WithName_ReturnsCar() {
		ResponseEntity<Car> responseEntity = this.testRestTemplate.getForEntity("/cars/{name}", Car.class, "prius");
		Car car = responseEntity.getBody();
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(car.getName()).isEqualTo("prius");
		assertThat(car.getType()).isEqualTo("hybrid");
	}

}
