package com.w00k.rest.webservices.restwebservices.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.w00k.rest.webservices.restwebservices.domain.User;
import com.w00k.rest.webservices.restwebservices.domain.UserBadRequestException;
import com.w00k.rest.webservices.restwebservices.domain.UserDaoService;
import com.w00k.rest.webservices.restwebservices.domain.UserNotFoundException;



@RestController
public class UserController {

	@Autowired
	private UserDaoService userDaoService;
	
	@GetMapping("/users")
	public List<User> retriveAllUsers() {
		return userDaoService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public EntityModel<User> retriveUser(@PathVariable int id ) {

		User user = userDaoService.findOne(id);

		if( user == null ) throw new UserNotFoundException("id ~ " + id);

		//"all-users", SERVER_PATH + "/users"
		//retrieveAllUsers
		EntityModel<User> resource = EntityModel.of(user);
		
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retriveAllUsers());
		
		resource.add(linkTo.withRel("all-users"));
		
		//HATEOAS

		return resource;
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user ) {

		if( user.getName().length() == 0 || user.getBirthDate().toString().length() == 0) throw new UserBadRequestException("user : " + user.toString());

		User saveUser = userDaoService.save(user);
	
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/users/{id}")
	public User deleteUser(@PathVariable int id ) {

		User user = userDaoService.deleteById(id);

		if( user == null ) throw new UserNotFoundException("id ~ " + id);

		return user;
	}
	
}
