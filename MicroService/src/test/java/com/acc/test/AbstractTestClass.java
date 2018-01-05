package com.acc.test;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acc.Application;



// this abstract class will be parent 
// for all tests classes in project 

//Informs Spring to which class to use when loading/ executing unit test	
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)
/*
@ContextConfiguration(classes=Application.class)
@WebMvcTest(CarController.class)*/
//helps the startup of the SpringBootApplication for TestRunner, otherwise what TestRunner will test.
//notice that we have supplied the name of the main applciation class, 
// Test Runner will start the application, using the main application class, just it will start normally.
// here we use to put the @configuration
public abstract class AbstractTestClass {
	
	protected Logger logger = LoggerFactory.getLogger(AbstractTestClass.class);
	
}
