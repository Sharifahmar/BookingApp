package com.acc.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.acc.entity.UserEntity;

@Repository
public interface UserDAO extends CrudRepository<UserEntity, Integer>{
	
	
	public UserEntity findByUniqueId(int uid);
	
	public UserEntity findByUserId(int uid);
	
	public UserEntity findUserByEmail(String email);
	
	@Query(name="query4.findAllByEmailId")
	public UserEntity loginByUserName(String val); 

//	@Query(name="query10.getUserById")
//	public UserEntity findByUserId(@Param("val1") int userId);
}
