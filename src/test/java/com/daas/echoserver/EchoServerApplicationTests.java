package com.daas.echoserver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Map;

import static java.util.Collections.singletonMap;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class EchoServerApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	public void test_echo_message() {
    webTestClient
        .get()
        .uri("/v1/echo/{message}", singletonMap("message", "Hello"))
        .exchange()
        .expectStatus()
        .isOk()
        .expectBody(new ParameterizedTypeReference<Map<String, String>>() {})
        .isEqualTo(singletonMap("message", "Echo from DaaS 360: " + "Hello"));
	}

}
