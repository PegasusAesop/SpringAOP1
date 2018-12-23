package com.pegasus.springaop.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pegasus.springaop.service.IUserService;

public class TestAOPBefore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		ApplicationContext ac=new ClassPathXmlApplicationContext("./spring-aop/applicationContext.xml");
		IUserService userService=(IUserService) ac.getBean("userService");
		System.out.println(userService.getClass());
		System.out.println("---------------------------");
		userService.login("Pegasus", "8888");
		System.out.println("---------------------------");
		
		String message = userService.logout();
		System.out.println(message);
		
		
	}

}
