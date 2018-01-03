package com.acc.service;

import java.util.List;

import com.acc.dto.InfoDTO;
import com.acc.dto.LoginDTO;
import com.acc.dto.PinCodeDTO;

public interface UserInfoServiceInf {

	public abstract List<InfoDTO> getAllUsers() throws Exception;

	public abstract InfoDTO getMeetingById(int id) throws Exception;

	public abstract PinCodeDTO getPincodeById(int id) throws Exception;

	public abstract Integer addUser(InfoDTO dto) throws Exception;

	public abstract Integer updateUser(InfoDTO dto) throws Exception;

	public abstract void deleteUser(int uid);

	public abstract Boolean findUserById(int id);

	public abstract Boolean isUserExist(InfoDTO dto);

	public abstract Boolean isUserExistById(InfoDTO dto);

	public abstract InfoDTO login(LoginDTO loginDTO) throws Exception;

	public abstract boolean isUserActive(int userId);

}