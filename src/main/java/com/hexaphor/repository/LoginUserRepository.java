package com.hexaphor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hexaphor.model.LoginUser;


public interface LoginUserRepository extends JpaRepository<LoginUser, String> {

	@Query("select lu.loginID from LoginUser lu where lu.loginName=:loginName and lu.password=:password ")
	 String  user_login(String loginName ,String password);
	
	@Query("select count(loginName) from LoginUser  where loginName=:loginName")
	Integer countLoginName(String loginName);
}
