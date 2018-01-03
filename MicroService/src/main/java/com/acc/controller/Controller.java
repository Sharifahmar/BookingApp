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

import com.acc.customresponse.CustomResponse;
import com.acc.dto.InfoDTO;
import com.acc.dto.LoginDTO;
import com.acc.dto.PinCodeDTO;
import com.acc.service.AddressInfoServiceInf;
import com.acc.service.MeetingInfoServiceInf;
import com.acc.service.PincodeInfoServiceInf;
import com.acc.service.UserInfoServiceInf;
import com.acc.wrapper.DateIdWrapper;

@CrossOrigin
@RestController
public class Controller {
	/**
	 * Autowiring userInfoServ and injecting it
	 */
	@Autowired
	UserInfoServiceInf userInfoServImpl;
	@Autowired
	MeetingInfoServiceInf meetingInfoServiceImpl;
	@Autowired
	PincodeInfoServiceInf pincodeInfoServiceImpl;
	@Autowired
	AddressInfoServiceInf addressInfoServiceImpl;
	
	
	CustomResponse response = null;
	

	/**
	 * This method is used to mapped the url for getting all users details
	 * 
	 * @return List of DTO
	 * @throws Exception
	 */

	@RequestMapping(value = "/usercontroller/getAllUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllUsers() throws Exception {
		List<InfoDTO> list = userInfoServImpl.getAllUsers();
		if (list.size() == 0) {
			response = new CustomResponse();
			response.setMessage("Error while fetching data list");
			response.setSuccess(false);
			return new ResponseEntity<CustomResponse>(response,
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<InfoDTO>>(list, HttpStatus.OK);

	}

	/**
	 * This method is used to map getPincodeById for getting Pincode table
	 * result based on Id
	 * 
	 * @param pin
	 * @return DTO
	 * @throws Exception
	 */

	@RequestMapping(value = "/user/controller/getPincodeByPincode/{pin}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getPincodeById(@PathVariable("pin") int pin)
			throws Exception {
		PinCodeDTO dto = pincodeInfoServiceImpl.getPincodeById(pin);
		if (dto == null) {
			response = new CustomResponse();
			response.setMessage("Error while fetching data by pincode");
			response.setSuccess(false);
			return new ResponseEntity<CustomResponse>(response,
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<PinCodeDTO>(dto, HttpStatus.OK);

	}

	/**
	 * This method is used to map user to add user details in table
	 * 
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/controller/User", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addUser(@RequestBody InfoDTO dto) throws Exception {
		response = new CustomResponse();
		if (userInfoServImpl.isUserExist(dto)) {
			response.setMessage("Unable to add User, User is already Exist");
			response.setSuccess(false);
			return new ResponseEntity<CustomResponse>(response,
					HttpStatus.CONFLICT);

		} else {
			int uid = userInfoServImpl.addUser(dto);
			response.setMessage("Add User Successfully " + uid);
			response.setSuccess(true);
			return new ResponseEntity<CustomResponse>(response, HttpStatus.OK);
		}
	}

	/**
	 * This method is used to map user to update user details in table
	 * 
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/controller/updateUser", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateUser(@RequestBody InfoDTO dto)
			throws Exception {
		Integer dto1 = userInfoServImpl.updateUser(dto);
		response = new CustomResponse();
		if (dto1 == 1) {
			response.setMessage("Successfully updated");
			response.setSuccess(true);
			return new ResponseEntity<CustomResponse>(response, HttpStatus.OK);
		} else {
			response = new CustomResponse();
			response.setMessage("Error while updating data");
			response.setSuccess(false);
			return new ResponseEntity<CustomResponse>(response,
					HttpStatus.NOT_FOUND);
		}

	}

	/**
	 * This method is used to map delete method through there Id in table
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/user/controller/deleteUser/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
		response = new CustomResponse();
		Boolean bool = userInfoServImpl.findUserById(id);
		if (!bool) {
			// logger.error("Unable to delete. User with id {} not found.", id);
			response.setMessage("Unable to delete User with the given id");
			response.setSuccess(false);
			return new ResponseEntity<CustomResponse>(response,
					HttpStatus.NOT_FOUND);
		}
		userInfoServImpl.deleteUser(id);
		response.setMessage("Successfully Deleted User");
		response.setSuccess(true);
		return new ResponseEntity<CustomResponse>(response, HttpStatus.OK);

	}

	@RequestMapping(value = "/user/controller/meeting", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addMeeting(@RequestBody InfoDTO dto)
			throws Exception {
		response = new CustomResponse();
		if (userInfoServImpl.isUserExistById(dto)) {
			int uid = meetingInfoServiceImpl.addMeeting(dto);
			
			response.setMessage("Add Meeting Successfully " + uid);
			response.setSuccess(true);
			
			return new ResponseEntity<CustomResponse>(response, HttpStatus.OK);
			
			/*else{
				
				response.setMessage("Meeting already exists for " + uid);
				response.setSuccess(true);
				return new ResponseEntity<CustomResponse>(response, HttpStatus.OK);
			}*/

		} else {
			response.setMessage("Unable to add Meeting, User is not Exist");
			response.setSuccess(false);
			return new ResponseEntity<CustomResponse>(response,
					HttpStatus.CONFLICT);

		}
	}

	/**
	 * login
	 * 
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/controller/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO)
			throws Exception {
		response = new CustomResponse();
		InfoDTO dto = userInfoServImpl.login(loginDTO);
		if (dto != null) {
			return new ResponseEntity<InfoDTO>(dto, HttpStatus.OK);
		} else {
			response.setMessage("Invalid Credentials");
			response.setSuccess(false);
			return new ResponseEntity<CustomResponse>(response,
					HttpStatus.UNAUTHORIZED);
		}

	}

	/**
	 * 
	 * @param infoDTO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/controller/updateMeeting", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateMeeting(@RequestBody InfoDTO infoDTO)
			throws Exception {
		response = new CustomResponse();
		InfoDTO dto = meetingInfoServiceImpl.updateMeeting(infoDTO);
		if (dto != null) {
			return new ResponseEntity<InfoDTO>(dto, HttpStatus.OK);
		} else {
			response.setMessage("Not Updated");
			response.setSuccess(false);
			return new ResponseEntity<CustomResponse>(response,
					HttpStatus.UNAUTHORIZED);
		}

	}
	
	/**
	 * Controller call to the meeting cancellation service.
	 * @param wrapper
	 * @return
	 */
	@RequestMapping(value="/user/controller/cancelMeeting",  method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> cancelMeeting(@RequestBody DateIdWrapper wrapper ) throws Exception{
		response = new CustomResponse();
		
		int res=meetingInfoServiceImpl.cancelMeetingServiceImpl(wrapper.getDateId());
		
		if(res!=0){

			response.setMessage("Cancel Meeting Successfully " + res);
			response.setSuccess(true);
			return new ResponseEntity<CustomResponse>(response, HttpStatus.OK);
		}else{
			
			response.setMessage("Meeting Not get cancelled ,Something bad happens");
			response.setSuccess(false);
			return new ResponseEntity<CustomResponse>(response,
					HttpStatus.UNAUTHORIZED);
		}
		
		
			}

}
