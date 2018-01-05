package com.acc.service;

import java.util.List;

import com.acc.customexception.PinCodeNotFoundException;
import com.acc.customexception.UserInfoNotFound;
import com.acc.dto.InfoDTO;
import com.acc.dto.LoginDTO;
import com.acc.dto.PinCodeDTO;

public interface InfUserInfoService {

	/**
	 * This method is used to get all the users
	 * 
	 * @return
	 * @throws UserInfoNotFound
	 */
	List<InfoDTO> getAllUsers() throws UserInfoNotFound;

	/**
	 * This method is used to get all the details (user , address , meeting ,
	 * pincode ) by meeting id
	 * 
	 * @param id
	 * @return
	 * @throws UserInfoNotFound
	 */
	InfoDTO getMeetingById(int id) throws UserInfoNotFound;

	/**
	 * This method is used to get pincode details by pincode id
	 * 
	 * @param id
	 * @return
	 * @throws PinCodeNotFoundException
	 */
	PinCodeDTO getPincodeById(int id) throws PinCodeNotFoundException;

	/**
	 * This method is used to add user
	 * 
	 * @param dto
	 * @return
	 * @throws UserInfoNotFound
	 * @throws Exception
	 */
	Integer addUser(InfoDTO dto) throws UserInfoNotFound, Exception;

	/**
	 * This method is used to update user
	 * 
	 * @param dto
	 * @return
	 * @throws UserInfoNotFound
	 */
	Integer updateUser(InfoDTO dto) throws UserInfoNotFound;

	/**
	 * This method is used to delete user
	 * 
	 * @param uid
	 */
	void deleteUser(int uid);

	/**
	 * 
	 * @param id
	 * @return
	 */
	Boolean findUserById(int id);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.acc.service.UserInfoServiceInf#isUserExist(com.acc.dto.InfoDTO)
	 */
	Boolean isUserExist(InfoDTO dto);

	/**
	 * This method is used to check user is exist or not by id
	 * 
	 * @param dto
	 * @return
	 */
	Boolean isUserExistById(InfoDTO dto);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.acc.service.UserInfoServiceInf#login(com.acc.dto.LoginDTO)
	 */
	InfoDTO login(LoginDTO loginDTO) throws UserInfoNotFound, Exception;

	/**
	 * This method is used to check user is active or not
	 * 
	 * @param userId
	 * @return
	 */
	boolean isUserActive(int userId);

}