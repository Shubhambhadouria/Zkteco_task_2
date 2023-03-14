package com.zkteco.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zkteco.entity.User;
import com.zkteco.exceptions.UserException;
import com.zkteco.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User saveUser(User user){
		return userRepository.save(user);
	}

	@Override
	public List<User> saveBatchUsers(List<User> users) {
		return userRepository.saveAll(users);
	}

	@Override
	public User updateUserById(String userId, User user) throws UserException {
		User user1 =  userRepository.findById(userId).get();
		if(user1!=null) {
			if(Objects.nonNull(user.getFirstName()) && 
					!"".equalsIgnoreCase(user.getFirstName())) {
					user1.setFirstName(user.getFirstName());
			}
			if(Objects.nonNull(user.getLastName()) && 
					!"".equalsIgnoreCase(user.getLastName())) {
					user1.setLastName(user.getLastName());
			}
			if(Objects.nonNull(user.getGender()) && 
					!"".equalsIgnoreCase(user.getGender())) {
					user1.setGender(user.getGender());
			}
			if(Objects.nonNull(user.getEmail()) && 
					!"".equalsIgnoreCase(user.getEmail())) {
					user1.setEmail(user.getEmail());
			}
			if(Objects.nonNull(user.getPhone()) && 
					!"".equalsIgnoreCase(user.getPhone())) {
					user1.setPhone(user.getPhone());
			}
			if(Objects.nonNull(user.getPassword()) && 
					!"".equalsIgnoreCase(user.getPassword())) {
					user1.setPassword(user.getPassword());
			}
			if(Objects.nonNull(user.getDateOfBirth())) {
					user1.setDateOfBirth(user.getDateOfBirth());
			}
			if(Objects.nonNull(user.getProfilePhoto())) {
					user1.setProfilePhoto(user.getProfilePhoto());
			}
			user1.setUpdateDate(LocalDate.now());
			return userRepository.save(user1);
			
		}else {
			throw new UserException("User is not Present with the Given Id : "+userId);
		}
	}

	@Override
	public User fetchUserByIdorEmailorPhone(String userId, String email, String phone) throws UserException {
		
		User user = userRepository.findByIdOrEmailOrPhone(userId, email, phone);
		
		if(user!=null) {
			return user;
		}else {
			throw new UserException("No Data Found with given parameters");
		}
	}

	@Override
	public List<User> fetchAllUsers() throws UserException {
		List<User> users = userRepository.findAll();
		if(users.size()!=0) {
			return users;
		}else {
			throw new UserException("No Data For Users Exist");
		}
	}

	@Override
	public List<User> fetchAllUsersBetweenDates(LocalDate startDate, LocalDate EndDate) throws UserException {
		
		List<User> users = userRepository.findByCreateDateBetween(startDate, EndDate);
		
		if(users.size()!=0) {
			return users;
		}else {
			throw new UserException("No Data For Users Exist");
		}
		
	}

	@Override
	public void deleteUserById(String userId) {
		userRepository.deleteById(userId);
	}

}
