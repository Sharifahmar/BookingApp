package com.acc.test;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//this annotation is used to tell Spring to
// create a web application context instead of Standard Application Context
@WebAppConfiguration
abstract public class AbstractControllerTestClass  extends AbstractTestClass{
	
	
	//Step1
	//Simulates the http-Requests,from spring mock packages 
	protected MockMvc mockMVC;
	
	
	@Autowired
	protected WebApplicationContext webApplicationContext;
	
	
	//Step2
	public void mySetup(){
		//making the mockMVC aware of the all the application components
		mockMVC= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	//Step3: our web service end points/method produce and consumes json,
	// below are the uti;it method to convert from java to json and vice versa
	// utility methods
	protected String covertFromObjectToJson(Object obj) throws JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(obj);
	}
		
	protected Object covertFromJsonToObject1(String json, Class var) throws IOException{
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json, var);//Convert Json into object of Specific Type
	}
	
	//Generic Type Safe Method
	protected <T> T covertFromJsonToObject2(String json, Class<T> var) throws IOException{
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json, var);//Convert Json into object of Specific Type
	}
	
	public void mySetUpForMocking(Object controller){
		mockMVC = MockMvcBuilders.standaloneSetup(controller).build();
	}
}
