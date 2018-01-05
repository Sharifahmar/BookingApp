/*package com.acc.test;

import java.util.Date;






import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.acc.dto.InfoDTO;

*//**
 * 
 * @author s.nemalikonda
 *
 *//*
@Transactional
public class AddTest extends AbstractControllerTestClass{

	protected MockMvc mockMvc;
	
	@Before
	public void mySetup() {
		System.out.println("Setting up mock request.....");
		super.mySetup();
		
	}
	
	*//**
	 * Testing GetAll users
	 * @throws Exception
	 *//*

	@Test
	public void testGetAllUsers() throws Exception{

		String uri ="/usercontroller/getAllUsers";

		MockHttpServletRequestBuilder request= MockMvcRequestBuilders.get(uri);

		ResultActions rest= mockMVC.perform(request);

		MvcResult mvcREsult= rest.andReturn();

		String result= mvcREsult.getResponse().getContentAsString();

		List<InfoDTO> list= super.covertFromJsonToObject2(result, List.class);

		logger.info("testGetAllUsers positive"+list);
		Assert.assertTrue(list!=null);
	}
	
	*//**
	 * Testing GetPincodeById
	 * Positive test case
	 * @throws Exception
	 *//*
	
	@Test
	public void testGetPincodeById() throws Exception{
		String uri ="/user/controller/getPincodeByPincode/{pin}";

		MockHttpServletRequestBuilder request= MockMvcRequestBuilders.get(uri,485);

		ResultActions rest= mockMVC.perform(request);

		MvcResult mvcREsult= rest.andReturn();

		String result= mvcREsult.getResponse().getContentAsString();

		List<InfoDTO> list= super.covertFromJsonToObject2(result, List.class);

		logger.info("testGetAllUsers positive"+list);
		Assert.assertTrue(list!=null);
	}
	@Test
	public void testAddPizza() throws Exception{

		String uri ="/pizza/controller/addPizza";


		InfoDTO pizzaBean = new PizzaOrderDTO(0, "TEST", 4, 999, "9999999999");
		String pizzaJson =  super.covertFromObjectToJson(pizzaBean);
		MockHttpServletRequestBuilder request= MockMvcRequestBuilders.post(uri)
				.accept(MediaType.APPLICATION_JSON)
				.content(pizzaJson)
				.contentType(MediaType.APPLICATION_JSON);

		ResultActions rest= mockMVC.perform(request);

		MvcResult mvcREsult= rest.andReturn();

		String result= mvcREsult.getResponse().getContentAsString();

		logger.info("testAddPizza"+result);
		Assert.assertTrue(result!=null);
	}
	

}
*/