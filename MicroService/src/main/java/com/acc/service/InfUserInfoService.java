package com.acc.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.acc.customexception.PinCodeNotFoundException;
import com.acc.customexception.UserInfoNotFound;
import com.acc.dto.InfoDTO;
import com.acc.dto.LoginDTO;
import com.acc.dto.PinCodeDTO;

public interface InfUserInfoService {

	/*
	 * (non-Javadoc)
	 *
	 * @see com.acc.service.UserInfoServiceInf#getAllUsers()
	 */
	List<InfoDTO> getAllUsers() throws UserInfoNotFound;

	/*
	 * (non-Javadoc)
	 *
	 * @see com.acc.service.UserInfoServiceInf#getMeetingById(int)
	 */
	InfoDTO getMeetingById(int id) throws UserInfoNotFound;

	/*
	 * (non-Javadoc)
	 *
	 * @see com.acc.service.UserInfoServiceInf#getPincodeById(int)
	 */
	PinCodeDTO getPincodeById(int id) throws PinCodeNotFoundException;

	/*
	 * (non-Javadoc)
	 *
	 * @see com.acc.service.UserInfoServiceInf#addUser(com.acc.dto.InfoDTO)
	 */
	Integer addUser(InfoDTO dto) throws UserInfoNotFound,Exception;

	/*
	 * (non-Javadoc)
	 *
	 * @see com.acc.service.UserInfoServiceInf#updateUser(com.acc.dto.InfoDTO)
	 */
	Integer updateUser(InfoDTO dto) throws UserInfoNotFound;

	/*
	 * (non-Javadoc)
	 *
	 * @see com.acc.service.UserInfoServiceInf#deleteUser(int)
	 */
	void deleteUser(int uid);

	/*
	 * (non-Javadoc)
	 *
	 * @see com.acc.service.UserInfoServiceInf#findUserById(int)
	 */
	Boolean findUserById(int id);

	/*
	 * (non-Javadoc)
	 *
	 * @see com.acc.service.UserInfoServiceInf#isUserExist(com.acc.dto.InfoDTO)
	 */
	Boolean isUserExist(InfoDTO dto);

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.acc.service.UserInfoServiceInf#isUserExistById(com.acc.dto.InfoDTO)
	 */
	Boolean isUserExistById(InfoDTO dto);

	/*
	 * (non-Javadoc)
	 *
	 * @see com.acc.service.UserInfoServiceInf#login(com.acc.dto.LoginDTO)
	 */
	InfoDTO login(LoginDTO loginDTO) throws  UserInfoNotFound, NoSuchAlgorithmException;

	/*
	 * (non-Javadoc)
	 *
	 * @see com.acc.service.UserInfoServiceInf#isUserActive(int)
	 */
	boolean isUserActive(int userId);

}