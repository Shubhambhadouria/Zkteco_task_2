package com.zkteco.service;

import java.time.LocalDate;
import java.util.List;

import com.zkteco.entity.User;
import com.zkteco.exceptions.UserException;

public interface UserService {
	
	public User saveUser(User user);
	
	public List<User> saveBatchUsers(List<User> users);
	
	public User updateUserById(String userId, User user) throws UserException;
	
	public User fetchUserByIdorEmailorPhone(String userId, String email, String phone) throws UserException;
	
	public List<User> fetchAllUsers() throws UserException;
	
	public List<User> fetchAllUsersBetweenDates(LocalDate startDate, LocalDate EndDate) throws UserException;
	
	public void deleteUserById(String userId);
	
}
