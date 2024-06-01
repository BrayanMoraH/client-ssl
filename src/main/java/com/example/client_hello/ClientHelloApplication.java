package com.example.client_hello;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.File;

@AllArgsConstructor
@SpringBootApplication
public class ClientHelloApplication implements CommandLineRunner {

	private final RestTemplate restTemplate;
    public static void main(String[] args) {
		SpringApplication.run(ClientHelloApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ResponseEntity<String> forEntity = restTemplate.getForEntity("https://localhost:8443/hello", String.class);
		System.out.println(forEntity);
	}
}
