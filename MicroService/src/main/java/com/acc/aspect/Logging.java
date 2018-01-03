package com.acc.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
/**
 * 
 * @author s.nemalikonda
 * This class is used to put logger before and after invoking every method with its class name and method name 
 *
 */
@Component
@Aspect
public class Logging {
/**
 * The below method is log4J method
 */
	public static Logger logger = Logger.getLogger(Logging.class);
	/**
	 * AOP Around advice
	 * @param pjp
	 * @return obj
	 */
	@Around(value="execution(* com.acc..*.*(..))")
	public Object aroundTest(ProceedingJoinPoint pjp){ 
		Object obj=null;
		try {
			logger.info("@Around: Before Method in around: "+ pjp.getSignature().getName());	
			obj= pjp.proceed();		
			logger.info("@Around: Around AfterReturn here1: "+obj+" in around"+ pjp.getSignature().getName());
		}catch (Throwable e) {
			obj=12;
			logger.info("@Around: Around AfterThrow Message: "+e.getMessage() + " "+ pjp.getSignature().getName());
		}
		logger.info("@Around: Around After : "+obj+" in around"+ pjp.getSignature().getName()); //after
		return obj;
	}  
}


