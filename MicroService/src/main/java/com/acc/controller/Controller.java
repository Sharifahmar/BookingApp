package com.acc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acc.constant.UrlConstant;
import com.acc.customexception.CancelMeetingException;
import com.acc.customexception.MeetingException;
import com.acc.customexception.PinCodeNotFoundException;
import com.acc.customexception.UpdateMeetingException;
import com.acc.customexception.UserInfoNotFound;
import com.acc.customresponse.CustomResponse;
import com.acc.dto.InfoDTO;
import com.acc.dto.LoginDTO;
import com.acc.dto.PinCodeDTO;
import com.acc.service.AddressInfoServiceImpl;
import com.acc.service.MeetingInfoServiceImpl;
import com.acc.service.PincodeInfoServiceImpl;
import com.acc.service.UserInfoServiceImpl;
import com.acc.wrapper.DateIdWrapper;

@CrossOrigin
@RestController
public class Controller {

	/**
	 * Autowiring userInfoServ and injecting it
	 */
	@Autowired
	private UserInfoServiceImpl userInfoServImpl;

	@Autowired
	private MeetingInfoServiceImpl meetingInfoServiceImpl;

	@Autowired
	private PincodeInfoServiceImpl pincodeInfoServiceImpl;

	@Autowired
	private AddressInfoServiceImpl addressInfoServiceImpl;

	private CustomResponse response = null;

	/**
	 * This method is used to mapped the url for getting all users details
	 *
	 * @return List of DTO
	 * @throws UserInfoNotFound
	 * @throws Exception
	 */

	@RequestMapping(value = UrlConstant.GET_ALL_USERS, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllUsers() throws UserInfoNotFound {

		List<InfoDTO> list = userInfoServImpl.getAllUsers();
		if (list.isEmpty()) {
			response = new CustomResponse();
			response.setMessage("Error while fetching data list");
			response.setSuccess(false);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);

	}

	/**
	 * This method is used to map getPincodeById for getting Pincode table
	 * result based on Id
	 *
	 * @param pin
	 * @return DTO
	 * @throws Exception
	 */

	@RequestMapping(value = UrlConstant.GET_BY_PINCODE_ID, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getPincodeById(@PathVariable("pin") int pin)
			throws PinCodeNotFoundException {

		PinCodeDTO dto = pincodeInfoServiceImpl.getPincodeById(pin);
		if (dto == null) {
			response = new CustomResponse();
			response.setMessage("Error while fetching data by pincode");
			response.setSuccess(false);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(dto, HttpStatus.OK);

	}

	/**
	 * This method is used to map user to add user details in table
	 *
	 * @param dto
	 * @return
	 * @throws PinCodeNotFoundException
	 * @throws UserInfoNotFound
	 * @throws Exception
	 */
	@RequestMapping(value = UrlConstant.ADD_USER, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addUser(@RequestBody InfoDTO dto)
			throws UserInfoNotFound {

		response = new CustomResponse();
		if (userInfoServImpl.isUserExist(dto)) {
			response.setMessage("Unable to add User, User is already Exist");
			response.setSuccess(false);
			return new ResponseEntity<>(response, HttpStatus.CONFLICT);

		} else {
			int uid = userInfoServImpl.addUser(dto);
			response.setMessage("Add User Successfully " + uid);
			response.setSuccess(true);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}

	/**
	 * This method is used to map user to update user details in table
	 *
	 * @param dto
	 * @return
	 * @throws UserInfoNotFound
	 * @throws Exception
	 */
	@RequestMapping(value = UrlConstant.UPDATE_USER, method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateUser(@RequestBody InfoDTO dto)
			throws UserInfoNotFound {

		Integer dto1 = userInfoServImpl.updateUser(dto);
		response = new CustomResponse();
		if (dto1 == 1) {
			response.setMessage("Successfully updated");
			response.setSuccess(true);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response = new CustomResponse();
			response.setMessage("Error while updating data");
			response.setSuccess(false);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}

	}

	/**
	 * This method is used to map delete method through there Id in table
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping(value = UrlConstant.DELETE_USER, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {

		response = new CustomResponse();
		Boolean bool = userInfoServImpl.findUserById(id);
		if (!bool) {

			response.setMessage("Unable to delete User with the given id");
			response.setSuccess(false);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		userInfoServImpl.deleteUser(id);
		response.setMessage("Successfully Deleted User");
		response.setSuccess(true);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@RequestMapping(value = UrlConstant.ADD_MEETING, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addMeeting(@RequestBody InfoDTO dto)
			throws MeetingException {

		response = new CustomResponse();
		if (userInfoServImpl.isUserExistById(dto)) {
			int uid = meetingInfoServiceImpl.addMeeting(dto);

			response.setMessage("Add Meeting Successfully " + uid);
			response.setSuccess(true);

			return new ResponseEntity<>(response, HttpStatus.OK);

		} else {
			response.setMessage("Unable to add Meeting, User is not Exist");
			response.setSuccess(false);
			return new ResponseEntity<>(response, HttpStatus.CONFLICT);

		}
	}

	/**
	 * login
	 *
	 * @param dto
	 * @return
	 * @throws UserInfoNotFound
	 * @throws Exception
	 */
	@RequestMapping(value = UrlConstant.USER_LOGIN, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO)
			throws UserInfoNotFound {

		response = new CustomResponse();
		InfoDTO dto = userInfoServImpl.login(loginDTO);
		if (dto != null) {
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} else {
			response.setMessage("Invalid Credentials");
			response.setSuccess(false);
			return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
		}

	}

	/**
	 *
	 * @param infoDTO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = UrlConstant.UPDATE_MEETING, method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateMeeting(@RequestBody InfoDTO infoDTO)
			throws UpdateMeetingException {

		response = new CustomResponse();
		InfoDTO dto = meetingInfoServiceImpl.updateMeeting(infoDTO);
		if (dto != null) {
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} else {
			response.setMessage("Not Updated");
			response.setSuccess(false);
			return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
		}

	}

	/**
	 * Controller call to the meeting cancellation service.
	 *
	 * @param wrapper
	 * @return
	 */
	@RequestMapping(value = UrlConstant.CANCEL_MEETING, method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> cancelMeeting(@RequestBody DateIdWrapper wrapper)
			throws CancelMeetingException {

		response = new CustomResponse();

		int res = meetingInfoServiceImpl.cancelMeetingServiceImpl(wrapper
				.getDateId());

		if (res != 0) {

			response.setMessage("Cancel Meeting Successfully " + res);
			response.setSuccess(true);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {

			response.setMessage("Meeting Not get cancelled ,Something bad happens");
			response.setSuccess(false);
			return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
		}

	}

}
