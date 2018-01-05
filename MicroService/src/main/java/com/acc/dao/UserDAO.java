package com.acc.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.acc.entity.UserEntity;

@Repository
public interface UserDAO extends CrudRepository<UserEntity, Integer> {
	/**
	 * This method is used to get User details by using unique id
	 * 
	 * @param uid
	 * @return
	 */

	public UserEntity findByUniqueId(int uid);

	/**
	 * This method is used to get User details by using userid
	 * 
	 * @param uid
	 * @return
	 */

	public UserEntity findByUserId(int uid);

	/**
	 * This method is used to get user details by using user email id
	 * 
	 * @param email
	 * @return
	 */

	public UserEntity findUserByEmail(String email);

	/**
	 * This method is used to get login by user name
	 * 
	 * @param email
	 * @return
	 */
	@Query(name = "query4.findAllByEmailId")
	public UserEntity loginByUserName(String val);

}
