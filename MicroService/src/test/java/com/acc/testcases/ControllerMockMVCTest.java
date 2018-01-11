package com.acc.testcases;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.acc.customresponse.CustomResponse;
import com.acc.dto.InfoDTO;
import com.acc.dto.LoginDTO;
import com.acc.dto.PinCodeDTO;
import com.acc.dto.PriorityDTO;
import com.acc.test.AbstractControllerTestClass;
import com.acc.wrapper.DateIdWrapper;

//@Profile("MSD_Dev_Profile")
@Transactional
public class ControllerMockMVCTest extends AbstractControllerTestClass {

	static Logger log = Logger.getLogger(ControllerMockMVCTest.class);

	@Before
	public void setUp() throws Exception {
		super.mySetup();
	}

	@Ignore
	@Test
	public void testGetAllUsers() throws Exception {
		String uri = "/usercontroller/getAllUsers";
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(uri);
		ResultActions result = mockMVC.perform(request);
		MvcResult res = result.andReturn();
		String re = res.getResponse().getContentAsString();
		int status = res.getResponse().getStatus();
		@SuppressWarnings("unchecked")
		List<InfoDTO> dtoList = (List<InfoDTO>) super.covertFromJsonToObject1(
				re, List.class);
		Assert.assertTrue(dtoList != null);
		Assert.assertTrue(status == HttpStatus.OK.value());
	}

	@Ignore
	@Test
	public void testGetPincodeById() throws Exception {
		String uri = "/user/controller/getPincodeByPincode/123123";
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(uri);
		ResultActions result = mockMVC.perform(request);
		MvcResult res = result.andReturn();

		String re = res.getResponse().getContentAsString();
		int status = res.getResponse().getStatus();
		PinCodeDTO dto = (PinCodeDTO) super.covertFromJsonToObject1(re,
				PinCodeDTO.class);
		Assert.assertTrue(dto != null);
		Assert.assertTrue(status == HttpStatus.OK.value());
	}

	@Ignore
	@Test
	public void testAddUser() throws Exception {
		String uri = "/user/controller/User/";

		InfoDTO dto = new InfoDTO(0, "abhi@test.com", "abhi", "Abhirup", "rup",
				"Debnath", "Male", "1994-11-11", "123456789", "12345", 123456,
				"ASE", "ASE", "", "true", 0, "gurgaon", "gurgaon", "true",
				44602, "India", "Telangana", "RR", "Hyd", "Ch", "true", 0,
				new Date(), "11:00", new Date(), "12:00", "107,108", "true");
		String jsonPizzaOrderDTO = super.covertFromObjectToJson(dto);
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.post(uri).accept(MediaType.APPLICATION_JSON)
				.content(jsonPizzaOrderDTO)
				.contentType(MediaType.APPLICATION_JSON);
		ResultActions result = mockMVC.perform(request);
		MvcResult res = result.andReturn();

		String re = res.getResponse().getContentAsString();
		int actualStatus = res.getResponse().getStatus();
		CustomResponse response = (CustomResponse) super
				.covertFromJsonToObject1(re, CustomResponse.class);
		Assert.assertTrue(response != null);
		Assert.assertTrue(actualStatus == HttpStatus.OK.value());
	}

	@Ignore
	@Test
	public void testUpdateUser() throws Exception {
		String uri = "/user/controller/updateUser";

		InfoDTO dto = new InfoDTO(112, "abhi@test.com", "abhi", "Abhirup",
				"rup", "Debnath", "Male", "1994-11-11", "123456789", "12345",
				123456, "ASE", "ASE", "", "true", 14, "pune", "pune", "true",
				44602, "India", "Telangana", "RR", "Hyd", "Ch", "true", 16,
				new Date(), "11:00", new Date(), "12:00", "107,108", "true");

		String jsonPizzaOrderDTO = super.covertFromObjectToJson(dto);
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.put(uri)
				.accept(MediaType.APPLICATION_JSON).content(jsonPizzaOrderDTO)
				.contentType(MediaType.APPLICATION_JSON);
		ResultActions result = mockMVC.perform(request);
		MvcResult res = result.andReturn();

		String re = res.getResponse().getContentAsString();
		int actualStatus = res.getResponse().getStatus();
		CustomResponse response = (CustomResponse) super
				.covertFromJsonToObject1(re, CustomResponse.class);
		Assert.assertTrue(response != null);
		Assert.assertTrue(actualStatus == HttpStatus.OK.value());
	}

	@Ignore
	@Test
	public void testDeleteUser() throws Exception {
		String uri = "/user/controller/deleteUser/108";
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.delete(uri);
		ResultActions result = mockMVC.perform(request);
		MvcResult res = result.andReturn();

		String re = res.getResponse().getContentAsString();
		int status = res.getResponse().getStatus();
		CustomResponse response = (CustomResponse) super
				.covertFromJsonToObject1(re, CustomResponse.class);
		Assert.assertTrue(response != null);
		Assert.assertTrue(status == HttpStatus.OK.value());
	}

	@Ignore
	@Test
	public void testLogin() throws Exception {
		String uri = "/user/controller/login";
		LoginDTO dto = new LoginDTO("shravan@acc.com", "qwerty");

		String loginDto = super.covertFromObjectToJson(dto);
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.post(uri).accept(MediaType.APPLICATION_JSON).content(loginDto)
				.contentType(MediaType.APPLICATION_JSON);
		ResultActions result = mockMVC.perform(request);
		MvcResult res = result.andReturn();

		String re = res.getResponse().getContentAsString();
		int actualStatus = res.getResponse().getStatus();
		InfoDTO DTO = (InfoDTO) super
				.covertFromJsonToObject1(re, InfoDTO.class);
		Assert.assertTrue(re != null);
		Assert.assertTrue(actualStatus == HttpStatus.OK.value());
	}

	@Ignore
	@Test
	public void testAddMeeting() throws Exception {
		String uri = "/user/controller/meeting";

		InfoDTO dto = new InfoDTO(112, "abhi@test.com", "abhi", "Abhirup",
				"rup", "Debnath", "Male", "1994-11-11", "123456789", "12345",
				123456, "ASE", "ASE", "", "true", 14, "pune", "pune", "true",
				44602, "India", "Telangana", "RR", "Hyd", "Ch", "true", 16,
				new Date(), "12:00", new Date(), "01:00", "107,108", "true");

		String meetingJsonDto = super.covertFromObjectToJson(dto);
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.post(uri).accept(MediaType.APPLICATION_JSON)
				.content(meetingJsonDto)
				.contentType(MediaType.APPLICATION_JSON);
		ResultActions result = mockMVC.perform(request);
		MvcResult res = result.andReturn();

		String re = res.getResponse().getContentAsString();
		int actualStatus = res.getResponse().getStatus();
		CustomResponse response = (CustomResponse) super
				.covertFromJsonToObject1(re, CustomResponse.class);
		Assert.assertTrue(response != null);
		Assert.assertTrue(actualStatus == HttpStatus.OK.value());
	}

	@Ignore
	@Test
	public void testUpdateMeeting() throws Exception {
		String uri = "/user/controller/updateMeeting";
		InfoDTO dto = new InfoDTO(112, "abhi@test.com", "abhi", "Abhirup",
				"rup", "Debnath", "Male", "1994-11-11", "123456789", "12345",
				123456, "ASE", "ASE", "", "true", 14, "pune", "pune", "true",
				44602, "India", "Telangana", "RR", "Hyd", "Ch", "true", 16,
				new Date(), "01:00", new Date(), "12:00", "107,108", "true");

		String meetingJsonDto = super.covertFromObjectToJson(dto);
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.put(uri)
				.accept(MediaType.APPLICATION_JSON).content(meetingJsonDto)
				.contentType(MediaType.APPLICATION_JSON);
		ResultActions result = mockMVC.perform(request);
		MvcResult res = result.andReturn();

		String re = res.getResponse().getContentAsString();
		int actualStatus = res.getResponse().getStatus();
		InfoDTO dtoResponse = (InfoDTO) super.covertFromJsonToObject1(re,
				InfoDTO.class);
		Assert.assertTrue(dtoResponse != null);
		Assert.assertTrue(actualStatus == HttpStatus.OK.value());
	}

	@Ignore
	@Test
	public void testCancelMeeting() throws Exception {
		String uri = "/user/controller/cancelMeeting";
		DateIdWrapper dateId = new DateIdWrapper(15);

		String meetingJsonDto = super.covertFromObjectToJson(dateId);
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.put(uri)
				.accept(MediaType.APPLICATION_JSON).content(meetingJsonDto)
				.contentType(MediaType.APPLICATION_JSON);
		ResultActions result = mockMVC.perform(request);
		MvcResult res = result.andReturn();

		String re = res.getResponse().getContentAsString();
		int actualStatus = res.getResponse().getStatus();
		CustomResponse response = (CustomResponse) super
				.covertFromJsonToObject1(re, CustomResponse.class);
		Assert.assertTrue(response != null);
		Assert.assertTrue(actualStatus == HttpStatus.OK.value());
	}

	@Ignore
	@Test
	public void testAllPriority() throws Exception {
		String uri = "/priority/controller/getAllPriority";
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(uri);
		ResultActions result = mockMVC.perform(request);
		MvcResult res = result.andReturn();
		String re = res.getResponse().getContentAsString();
		int status = res.getResponse().getStatus();
		@SuppressWarnings("unchecked")
		List<PriorityDTO> dtoList = (List<PriorityDTO>) super
				.covertFromJsonToObject1(re, List.class);
		Assert.assertTrue(dtoList != null);
		Assert.assertTrue(status == HttpStatus.OK.value());
	}

	@Ignore
	@Test
	public void testAddPriority() throws Exception {
		String uri = "/priority/controller/addPriority";
		PriorityDTO priorityDTO = new PriorityDTO(0, 2589, "shravan",
				new Date(), new Date(), "true", new Date(), new Date(), "save",
				0, "notes", new Date(), new Date(), "true");
		String meetingJsonDto = super.covertFromObjectToJson(priorityDTO);
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.post(uri).accept(MediaType.APPLICATION_JSON)
				.content(meetingJsonDto)
				.contentType(MediaType.APPLICATION_JSON);
		ResultActions result = mockMVC.perform(request);
		MvcResult res = result.andReturn();

		String re = res.getResponse().getContentAsString();
		int actualStatus = res.getResponse().getStatus();
		CustomResponse response = (CustomResponse) super
				.covertFromJsonToObject1(re, CustomResponse.class);
		Assert.assertTrue(response != null);
		Assert.assertTrue(actualStatus == HttpStatus.OK.value());
	}

	@Ignore
	@Test
	public void testUpdatePriority() throws Exception {
		String uri = "/priority/controller/updatePriority";
		PriorityDTO priorityDTO = new PriorityDTO(8, 32164, "shravan",
				new Date(), new Date(), "false", new Date(), new Date(),
				"save", 8, "kumar", new Date(), new Date(), "true");
		String meetingJsonDto = super.covertFromObjectToJson(priorityDTO);
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.put(uri)
				.accept(MediaType.APPLICATION_JSON).content(meetingJsonDto)
				.contentType(MediaType.APPLICATION_JSON);
		ResultActions result = mockMVC.perform(request);
		MvcResult res = result.andReturn();

		String re = res.getResponse().getContentAsString();
		int actualStatus = res.getResponse().getStatus();
		CustomResponse response = (CustomResponse) super
				.covertFromJsonToObject1(re, CustomResponse.class);
		Assert.assertTrue(response != null);
		Assert.assertTrue(actualStatus == HttpStatus.OK.value());
	}

	@Ignore
	@Test
	public void testDeletePriority() throws Exception {
		String uri = "/priority/controller/deletePriority/8";
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.delete(uri);
		ResultActions result = mockMVC.perform(request);
		MvcResult res = result.andReturn();

		String re = res.getResponse().getContentAsString();
		int status = res.getResponse().getStatus();
		CustomResponse response = (CustomResponse) super
				.covertFromJsonToObject1(re, CustomResponse.class);
		Assert.assertTrue(response != null);
		Assert.assertTrue(status == HttpStatus.OK.value());
	}

	@Ignore
	@Test
	public void testGetPriorityId() throws Exception {
		String uri = "/priority/controller/getPriority/8";
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(uri);
		ResultActions result = mockMVC.perform(request);
		MvcResult res = result.andReturn();

		String re = res.getResponse().getContentAsString();
		int status = res.getResponse().getStatus();
		PriorityDTO dto = (PriorityDTO) super.covertFromJsonToObject1(re,
				PriorityDTO.class);
		Assert.assertTrue(dto != null);
		Assert.assertTrue(status == HttpStatus.OK.value());
	}

}