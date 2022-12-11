package com.microservice.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.microservice.entities.UserEntity;
import com.microservice.repo.UserRepo;
import com.microservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserEntity addUser(UserEntity user) {
		
		UserEntity newUser = new UserEntity();
		
		newUser.setId(user.getId());
		newUser.setName(user.getName());
		newUser.setAddress(user.getAddress());
		newUser.setMobile(user.getMobile());
		
		return this.userRepo.save(newUser);
	}

	@Override
	public List<UserEntity> getAllUsers() {
		return this.userRepo.findAll(); 
	}

	@Override
	public UserEntity getUserById(long id) throws Exception {
		return this.userRepo.findById(id).orElseThrow(()-> new Exception("User Not Found on Given Id "+id));
	}
	
//	@Override
//	public List<UserEntity> getUserByName(String name) {
//		
//		List<UserEntity> getName = this.userRepo.findByName(name);
//		
//		return getName;
//	}
//	
//	@Override
//	public List<UserEntity> getUserByName(List<UserEntity> users) {
//		return users;
//	}

	@Override
	public UserEntity editUserById(long id, UserEntity user) throws Exception {
		
		UserEntity updateUser = this.userRepo.findById(id).orElseThrow(()-> new Exception("User Not Found on Given Id "+id));
				
		updateUser.setId(user.getId());
		updateUser.setName(user.getName());
		updateUser.setAddress(user.getAddress());
		updateUser.setMobile(user.getMobile());
		
		return this.userRepo.save(updateUser);
	}

	@Override
	public void deleteUserById(long id) {
		this.userRepo.deleteById(id);
	}

	@Override
	public List<UserEntity> getUserByName(String name) {
		
		return this.userRepo.findByNameContainingIgnoreCase(name);
	}

}
