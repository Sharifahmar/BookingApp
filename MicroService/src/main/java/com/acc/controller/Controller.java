package com.acc.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

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
import com.acc.dto.PriorityDTO;
import com.acc.entity.PriorityEntity;
import com.acc.service.AddressInfoServiceImpl;
import com.acc.service.MeetingInfoServiceImpl;
import com.acc.service.PincodeInfoServiceImpl;
import com.acc.service.PriorityServiceImpl;
import com.acc.service.UserInfoServiceImpl;
import com.acc.wrapper.DateIdWrapper;

@CrossOrigin
@RestController
/**
 * Controller is a restcontroller class 
 * contacting multiple services for the process and 
 * sending response to the client
 * 
 * @author sangita.a.mohanty
 *
 */
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

	@Autowired
	private PriorityServiceImpl priorityServiceImpl;

	private CustomResponse response = null;

	/**
	 * This method is used to mapped the url for getting all users details
	 *
	 * @return List of DTO
	 * @throws UserInfoNotFound
	 * @throws Exception
	 */
	@ApiOperation(httpMethod = "GET", value = "getAllUsers", nickname = "getAllUsers")
	@ApiImplicitParams({ @ApiImplicitParam(name = "none", value = "none", required = false, dataType = "none", paramType = "none", defaultValue = "none") })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = ResponseEntity.class),
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Failure") })
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
	@ApiOperation(httpMethod = "GET", value = "getPincodeById(@PathVariable(\"pin\") int pin)", nickname = "getPincodeById(@PathVariable(\"pin\") int pin)")
	@ApiImplicitParams({ @ApiImplicitParam(name = "Integer", value = "an object", required = true, dataType = "Integer", paramType = "query param", defaultValue = "none") })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = ResponseEntity.class),
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Failure") })
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
	@ApiOperation(httpMethod = "POST", value = "addUser(@RequestBody InfoDTO dto)", nickname = "addUser(@RequestBody InfoDTO dto)")
	@ApiImplicitParams({ @ApiImplicitParam(name = "addUser", value = "an object", required = true, dataType = "InfoDTO", paramType = "query param", defaultValue = "none") })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = ResponseEntity.class),
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Failure") })
	@RequestMapping(value = UrlConstant.ADD_USER, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addUser(@RequestBody InfoDTO dto)
			throws UserInfoNotFound, Exception {

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

	@ApiOperation(httpMethod = "PUT", value = "updateUser(@RequestBody InfoDTO dto)", nickname = "updateUser(@RequestBody InfoDTO dto)")
	@ApiImplicitParams({ @ApiImplicitParam(name = "updateUser", value = "an object", required = true, dataType = "InfoDTO", paramType = "query param", defaultValue = "none") })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = ResponseEntity.class),
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Failure") })
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

	@ApiOperation(httpMethod = "DELETE", value = "deleteUser(@PathVariable(\"id\") int id)", nickname = "deleteUser(@PathVariable(\"id\") int id)")
	@ApiImplicitParams({ @ApiImplicitParam(name = "Integer", value = "an object", required = true, dataType = "Integer", paramType = "query param", defaultValue = "none") })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = ResponseEntity.class),
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Failure") })
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

	/**
	 * This method is used to map user to add user details in table
	 * 
	 * @param dto
	 * @return
	 * @throws MeetingException
	 */

	@ApiOperation(httpMethod = "POST", value = "addMeeting(@RequestBody InfoDTO dto)", nickname = "addMeeting(@RequestBody InfoDTO dto)")
	@ApiImplicitParams({ @ApiImplicitParam(name = "addMeeting", value = "an object", required = true, dataType = "InfoDTO", paramType = "query param", defaultValue = "none") })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = ResponseEntity.class),
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Failure") })
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
	 * This method is used for processing login process of user
	 *
	 * @param dto
	 * @return
	 * @throws UserInfoNotFound
	 * @throws Exception
	 */
	@ApiOperation(httpMethod = "POST", value = "login(@RequestBody LoginDTO loginDTO)", nickname = "login(@RequestBody LoginDTO loginDTO)")
	@ApiImplicitParams({ @ApiImplicitParam(name = "login", value = "an object", required = true, dataType = "InfoDTO", paramType = "query param", defaultValue = "none") })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = ResponseEntity.class),
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Failure") })
	@RequestMapping(value = UrlConstant.USER_LOGIN, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO)
			throws UserInfoNotFound, Exception {

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
	 * This method is used for updating the meeting details
	 * 
	 * @param infoDTO
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(httpMethod = "PUT", value = "updateMeeting(@RequestBody InfoDTO infoDTO)", nickname = "updateMeeting(@RequestBody InfoDTO infoDTO)")
	@ApiImplicitParams({ @ApiImplicitParam(name = "employee", value = "an object", required = true, dataType = "InfoDTO", paramType = "query param", defaultValue = "none") })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = ResponseEntity.class),
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Failure") })
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
	@ApiOperation(httpMethod = "PUT", value = "cancelMeeting(@RequestBody DateIdWrapper wrapper)", nickname = "cancelMeeting(@RequestBody DateIdWrapper wrapper)")
	@ApiImplicitParams({ @ApiImplicitParam(name = "wrapper", value = "an object", required = true, dataType = "wrapper", paramType = "query param", defaultValue = "none") })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = ResponseEntity.class),
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Failure") })
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

	/**
	 * This method is used to get all priority details
	 * 
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(httpMethod = "GET", value = "getAllUsers", nickname = "getAllUsers")
	@ApiImplicitParams({ @ApiImplicitParam(name = "none", value = "none", required = false, dataType = "none", paramType = "none", defaultValue = "none") })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = ResponseEntity.class),
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Failure") })
	@RequestMapping(value = UrlConstant.GET_ALL_PRIORITY, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllPriority() throws Exception {
		List<PriorityDTO> list = priorityServiceImpl.getAllDetails();
		if (list.isEmpty()) {
			response = new CustomResponse();
			response.setMessage("Error while fetching priority data list");
			response.setSuccess(false);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);

	}

	/**
	 * This method is used to add priority details
	 * 
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(httpMethod = "POST", value = "addPriority(@RequestBody PriorityDTO dto)", nickname = "addPriority(@RequestBody PriorityDTO dto)")
	@ApiImplicitParams({ @ApiImplicitParam(name = "addPriority", value = "an object", required = true, dataType = "PriorityDTO", paramType = "query param", defaultValue = "none") })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = ResponseEntity.class),
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Failure") })
	@RequestMapping(value = UrlConstant.ADD_PRIORITY, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addPriority(@RequestBody PriorityDTO dto)
			throws Exception {
		response = new CustomResponse();
		int pid2 = priorityServiceImpl.addPriority(dto);
		response.setMessage("Add Priority Successfully " + pid2);
		response.setSuccess(true);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/**
	 * This method is used to update priority details
	 * 
	 * @param dto
	 * @return
	 * @throws Exception
	 */

	@ApiOperation(httpMethod = "PUT", value = "updatePriority(@RequestBody InfoDTO dto)", nickname = "updatePriority(@RequestBody InfoDTO dto)")
	@ApiImplicitParams({ @ApiImplicitParam(name = "updatePriority", value = "an object", required = true, dataType = "InfoDTO", paramType = "query param", defaultValue = "none") })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = ResponseEntity.class),
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Failure") })
	@RequestMapping(value = UrlConstant.UPDATE_PRIORITY, method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updatePriority(@RequestBody PriorityDTO dto)
			throws Exception {
		Integer dto1 = priorityServiceImpl.updatePriority(dto);
		response = new CustomResponse();
		if (dto1 == 1) {
			response.setMessage("Successfully updated");
			response.setSuccess(true);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setMessage("Error while updating priority data");
			response.setSuccess(false);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}

	}

	/**
	 * This method is used to update priority details
	 * 
	 * @param dto
	 * @return
	 * @throws Exception
	 */

	@ApiOperation(httpMethod = "DELETE", value = "deletePriority(@PathVariable(\"id\") int id)", nickname = "deletePriority(@PathVariable(\"id\") int id)")
	@ApiImplicitParams({ @ApiImplicitParam(name = "Integer", value = "an object", required = true, dataType = "Integer", paramType = "query param", defaultValue = "none") })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = ResponseEntity.class),
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Failure") })
	@RequestMapping(value = UrlConstant.DELETE_PRIORTIY, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deletePriority(@PathVariable("id") int id) {
		response = new CustomResponse();
		// Boolean bool = priorityServiceImpl.findByPid(id);
		PriorityEntity entity = priorityServiceImpl.findByStatus(id);
		if (entity != null) {
			if (entity.getStatus().equalsIgnoreCase("draft")) {
				priorityServiceImpl.hardDeletePriority(id);
				response.setMessage("Successfully Hard Deleted Priority");
				response.setSuccess(true);
				return new ResponseEntity<>(response, HttpStatus.OK);
			} else if (entity.getStatus().equalsIgnoreCase("save")) {
				priorityServiceImpl.deletePriority(id);
				response.setMessage("Successfully Deleted Priority");
				response.setSuccess(true);
				return new ResponseEntity<>(response, HttpStatus.OK);
			} else if (entity.getStatus().equalsIgnoreCase("publish")) {
				response.setMessage("Unable to delete Priority with the given id because it is published");
				response.setSuccess(false);
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
			response.setMessage("something went wrong");
			response.setSuccess(false);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		} else {
			response.setMessage("User is not exist with given id");
			response.setSuccess(false);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * This method is used to get all details by id for PDF.
	 * 
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(httpMethod = "GET", value = "getPriorityById(@PathVariable(\"empId\") int empId)", nickname = "getPriorityById(@PathVariable(\"empId\") int empId)")
	@ApiImplicitParams({ @ApiImplicitParam(name = "Integer", value = "an object", required = true, dataType = "Integer", paramType = "query param", defaultValue = "none") })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = ResponseEntity.class),
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Failure") })
	@RequestMapping(value = UrlConstant.GET_PRIORITY_ID, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getPriorityById(@PathVariable("id") int id)
			throws Exception {

		PriorityDTO priorityDTO = priorityServiceImpl.getPriorityById(id);
		if (priorityDTO == null) {
			response = new CustomResponse();
			response.setMessage("Error while fetching priority data list");
			response.setSuccess(false);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(priorityDTO, HttpStatus.OK);

	}
}
