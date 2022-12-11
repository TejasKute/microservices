package com.microservice.service;

import java.util.List;
import com.microservice.entities.UserEntity;

public interface UserService {
	
	public UserEntity addUser(UserEntity user);
	
	public List<UserEntity> getAllUsers();
	
	public UserEntity getUserById(long id) throws Exception;
	
	public List<UserEntity> getUserByName(String name);
	
//	public List<UserEntity> getUserByName(String name);
//	public List<UserEntity> getUserByName(List<UserEntity> users);
	
	public UserEntity editUserById(long id, UserEntity user) throws Exception;
	
	public void deleteUserById(long id);

}
