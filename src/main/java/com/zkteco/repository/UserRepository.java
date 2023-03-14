package com.zkteco.repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zkteco.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

	public User findByEmail(String email);
	
	public User findByPhone(String phone);
	
	@Query("select u from User u where u.userId=?1 or u.email=?2 or u.phone=?3")
	public User findByIdOrEmailOrPhone(String userId, String email, String phone);
	
	@Query("select x from User x where x.createDate between ?1 and ?2")
	public List<User> findByCreateDateBetween(LocalDate Date1, LocalDate Date2);
}
