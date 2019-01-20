package com.caen;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@RestController
@SpringBootApplication
public class SeguridadApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeguridadApplication.class, args);
	}
	
	@Autowired
	private OAuth2ClientContext context;
	
	@GetMapping("/access_token")
	private String getToken() {
		String token=context.getAccessToken().getValue();
		System.out.println("Token:" +token);
		return token;
	}
	
	@GetMapping("/user")
	public Principal getUser(Principal user) {
		return user;
	}

}

