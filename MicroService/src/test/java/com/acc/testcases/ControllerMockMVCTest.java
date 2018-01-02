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

import com.acc.controller.Controller;
import com.acc.customresponse.CustomResponse;
import com.acc.dto.InfoDTO;
import com.acc.dto.LoginDTO;
import com.acc.dto.PinCodeDTO;
import com.acc.test.AbstractControllerTestClass;
import com.acc.wrapper.DateIdWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;

@Transactional
public class ControllerMockMVCTest extends AbstractControllerTestClass {
	
	static Logger log=Logger.getLogger(ControllerMockMVCTest.class);
	
	

	@Before
	public void setUp() throws Exception {
		super.mySetUpForMocking(Controller.class);
	}
	
	@Ignore
	@Test
	public void testGetAllUsers() throws Exception{
		String uri="/usercontroller/getAllUsers";
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(uri);
		ResultActions result = mockMVC.perform(request);
		MvcResult res = result.andReturn();
		
		String re = res.getResponse().getContentAsString();
		int status = res.getResponse().getStatus();
		List<InfoDTO> dtoList=(List<InfoDTO>) super.covertFromJsonToObject1(re, List.class);
		Assert.assertTrue(dtoList!=null);
		Assert.assertTrue(status==HttpStatus.OK.value());
	}
	
	@Ignore
	@Test
	public void testGetPincodeById() throws Exception{
		String uri="/user/controller/getPincodeByPincode/123123";
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(uri);
		ResultActions result = mockMVC.perform(request);
		MvcResult res = result.andReturn();
		
		String re = res.getResponse().getContentAsString();
		int status = res.getResponse().getStatus();
		PinCodeDTO dto= (PinCodeDTO) super.covertFromJsonToObject1(re, PinCodeDTO.class);
		Assert.assertTrue(dto!=null);
		Assert.assertTrue(status==HttpStatus.OK.value());
	}
	
	@Ignore
	@Test
	public void testAddUser() throws Exception{
		String uri = "/user/controller/User";
		InfoDTO dto=new InfoDTO();
/*		InfoDTO dto=new InfoDTO(0, "abhi@Acc.com", "abcabc", "Abhirup",
			" ", "Debnath", "Male", "1994-11-11",
			"1234567890", "12345" ,"411441", "ASE",
			"Single", " ", 0, "L-501,Cosmos",
			"Magarpatta", 411013, "India", "Maharashtra",
			"Pune", "Hadapsar", "magarpatta", 0,
			new Date(), "12:00", new Date(), "13:25",
			"102,103", "true", "true", "true", "true");*/
		
		String jsonPizzaOrderDTO = super.covertFromObjectToJson(dto);
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.post(uri).accept(MediaType.APPLICATION_JSON)
				.content(jsonPizzaOrderDTO)
				.contentType(MediaType.APPLICATION_JSON);
		ResultActions result = mockMVC.perform(request);
		MvcResult res = result.andReturn();
		
		String re = res.getResponse().getContentAsString();
		int actualStatus = res.getResponse().getStatus();
		CustomResponse response=(CustomResponse) super.covertFromJsonToObject1(re, CustomResponse.class);
		Assert.assertTrue(response != null);
		Assert.assertTrue(actualStatus == HttpStatus.CREATED.value());
	}
	
	@Ignore
	@Test
	public void testUpdateUser() throws Exception{
		String uri = "/user/controller/updateUser";
		InfoDTO dto=new InfoDTO();
/*		InfoDTO dto=new InfoDTO(0, "abhi@Acc.com", "abcabc", "Abhirup",
			" ", "Debnath", "Male", "1994-11-11",
			"1234567890", "12345" ,"411441", "ASE",
			"Single", " ", 0, "L-501,Cosmos",
			"Magarpatta", 411013, "India", "Maharashtra",
			"Pune", "Hadapsar", "magarpatta", 0,
			new Date(), "12:00", new Date(), "13:25",
			"102,103", "true", "true", "true", "true");*/
		
		String jsonPizzaOrderDTO = super.covertFromObjectToJson(dto);
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.post(uri).accept(MediaType.APPLICATION_JSON)
				.content(jsonPizzaOrderDTO)
				.contentType(MediaType.APPLICATION_JSON);
		ResultActions result = mockMVC.perform(request);
		MvcResult res = result.andReturn();
		
		String re = res.getResponse().getContentAsString();
		int actualStatus = res.getResponse().getStatus();
		CustomResponse response=(CustomResponse) super.covertFromJsonToObject1(re, CustomResponse.class);
		Assert.assertTrue(response != null);
		Assert.assertTrue(actualStatus == HttpStatus.OK.value());
	}

	@Ignore
	@Test
	public void testDeleteUser() throws Exception{
		String uri="/user/controller/deleteUser/102";
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(uri);
		ResultActions result = mockMVC.perform(request);
		MvcResult res = result.andReturn();
		
		String re = res.getResponse().getContentAsString();
		int status = res.getResponse().getStatus();
		CustomResponse response= (CustomResponse) super.covertFromJsonToObject1(re, CustomResponse.class);
		Assert.assertTrue(response!=null);
		Assert.assertTrue(status==HttpStatus.OK.value());
	}
	
	@Ignore
	@Test
	public void testLogin() throws Exception{
		String uri = "/user/controller/login";
		LoginDTO dto=new LoginDTO("msd@acc.com", "msd");
		
		String loginDto = super.covertFromObjectToJson(dto);
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.post(uri).accept(MediaType.APPLICATION_JSON)
				.content(loginDto)
				.contentType(MediaType.APPLICATION_JSON);
		ResultActions result = mockMVC.perform(request);
		MvcResult res = result.andReturn();
		
		String re = res.getResponse().getContentAsString();
		int actualStatus = res.getResponse().getStatus();
		InfoDTO DTO=(InfoDTO) super.covertFromJsonToObject1(re, InfoDTO.class);
		Assert.assertTrue(re != null);
		Assert.assertTrue(actualStatus == HttpStatus.OK.value());
	}
	
	@Ignore
	@Test
	public void testAddMeeting() throws Exception{
		String uri = "/user/controller/meeting";
		InfoDTO dto=new InfoDTO();
/*		InfoDTO dto=new InfoDTO(0, "abhi@Acc.com", "abcabc", "Abhirup",
			" ", "Debnath", "Male", "1994-11-11",
			"1234567890", "12345" ,"411441", "ASE",
			"Single", " ", 0, "L-501,Cosmos",
			"Magarpatta", 411013, "India", "Maharashtra",
			"Pune", "Hadapsar", "magarpatta", 0,
			new Date(), "12:00", new Date(), "13:25",
			"102,103", "true", "true", "true", "true");*/
		
		String meetingJsonDto = super.covertFromObjectToJson(dto);
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.post(uri).accept(MediaType.APPLICATION_JSON)
				.content(meetingJsonDto)
				.contentType(MediaType.APPLICATION_JSON);
		ResultActions result = mockMVC.perform(request);
		MvcResult res = result.andReturn();
		
		String re = res.getResponse().getContentAsString();
		int actualStatus = res.getResponse().getStatus();
		CustomResponse response=(CustomResponse) super.covertFromJsonToObject1(re, CustomResponse.class);
		Assert.assertTrue(response != null);
		Assert.assertTrue(actualStatus == HttpStatus.OK.value());
	}
	@Ignore
	@Test
	public void testUpdateMeeting() throws Exception{
		String uri = "/user/controller/updateMeeting";
		InfoDTO dto=new InfoDTO();
/*		InfoDTO dto=new InfoDTO(0, "abhi@Acc.com", "abcabc", "Abhirup",
			" ", "Debnath", "Male", "1994-11-11",
			"1234567890", "12345" ,"411441", "ASE",
			"Single", " ", 0, "L-501,Cosmos",
			"Magarpatta", 411013, "India", "Maharashtra",
			"Pune", "Hadapsar", "magarpatta", 0,
			new Date(), "12:00", new Date(), "13:25",
			"102,103", "true", "true", "true", "true");*/
		
		String meetingJsonDto = super.covertFromObjectToJson(dto);
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.post(uri).accept(MediaType.APPLICATION_JSON)
				.content(meetingJsonDto)
				.contentType(MediaType.APPLICATION_JSON);
		ResultActions result = mockMVC.perform(request);
		MvcResult res = result.andReturn();
		
		String re = res.getResponse().getContentAsString();
		int actualStatus = res.getResponse().getStatus();
		InfoDTO dtoResponse =(InfoDTO) super.covertFromJsonToObject1(re, InfoDTO.class);
		Assert.assertTrue(dtoResponse != null);
		Assert.assertTrue(actualStatus == HttpStatus.OK.value());
	}
	
	@Ignore
	@Test
	public void testCancelMeeting() throws Exception{
		String uri = "/user/controller/cancelMeeting";
		DateIdWrapper dateId=new DateIdWrapper(4);
		
		String meetingJsonDto = super.covertFromObjectToJson(dateId);
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.post(uri).accept(MediaType.APPLICATION_JSON)
				.content(meetingJsonDto)
				.contentType(MediaType.APPLICATION_JSON);
		ResultActions result = mockMVC.perform(request);
		MvcResult res = result.andReturn();
		
		String re = res.getResponse().getContentAsString();
		int actualStatus = res.getResponse().getStatus();
		CustomResponse response=(CustomResponse) super.covertFromJsonToObject1(re, CustomResponse.class);
		Assert.assertTrue(response != null);
		Assert.assertTrue(actualStatus == HttpStatus.OK.value());
	}
}
