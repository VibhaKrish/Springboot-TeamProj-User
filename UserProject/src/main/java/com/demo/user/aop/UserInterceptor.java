package com.demo.user.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
@Configuration
@Aspect
public class UserInterceptor {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Before("execution(* com.merc.demo.service.*.*(..))")
	public void serviceLog() {
		LOG.info("A method from a service class will be invoked.");
		
		
	}
	@After("execution(* com.merc.demo.service.*.*(..))")
	public void serviceLog1() {
		LOG.info("A method from a service class is invoked.");
	
	}
	
	@AfterThrowing("execution(* com.merc.demo.service.*.*(..))")
	
	public void serviceLog2() {
		LOG.info("Service class method is invoked.");
	
	}

}
