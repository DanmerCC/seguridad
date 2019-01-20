package com.caen.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caen.model.Application;
import com.caen.serviceImpl.UsuarioService;



@RestController(value="/user")
public class UsuarioController {
	
	@Autowired
	UsuarioService service;
	
	
	@GetMapping(value="/apps", produces =MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Application>> listar(){
		List<Application> lista=new ArrayList<>();
		try{
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (!(authentication instanceof AnonymousAuthenticationToken)) {
			    String currentUserName = authentication.getName();
			    System.out.println(currentUserName);
			}
			lista=service.appsUserByUsername(authentication.getName());
		}catch(Exception e) {
			return new ResponseEntity<List<Application>>(lista,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Application>>(lista,HttpStatus.OK);
		
	}
}
