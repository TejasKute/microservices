package com.microservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.microservice.entities.UserEntity;
import com.microservice.repo.UserRepo;
import com.microservice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepo userRepo;

	@PostMapping("/")
	public UserEntity addUser(@RequestBody UserEntity user) {
		return this.userService.addUser(user);
	}

	@GetMapping("/")
	public List<UserEntity> getAllUsers() {
		return this.userService.getAllUsers();
	}

	@GetMapping("/{id}")
	public UserEntity getUserById(@RequestParam(value= "id") long id) throws Exception {
		return this.userService.getUserById(id);
	}
	
	@GetMapping()
	public List<UserEntity> getUserByName(@RequestParam(value="name") String name) throws Exception {
		
		return userRepo.findByNameContainingIgnoreCase(name);
	}
	
//	@GetMapping("/laptops/name")
//	public List<Laptop> getLaptopsByName(@RequestParam String name) {
//		return new List<Laptop>(lRepo.findByName(name));
//	}

	@PutMapping("/{id}")
	public UserEntity editUserById(@PathVariable(value="id") long id, @RequestBody UserEntity user) throws Exception {
		return this.userService.editUserById(id, user);
	}

	@DeleteMapping("/{id}")
	public String deleteUserById(@PathVariable(value="id") long id) {
		this.userService.deleteUserById(id);
		return "Thank You !!! \nId "+id+" Delete Sucessfully";
	}
	

}
