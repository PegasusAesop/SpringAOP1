package com.pegasus.springaop.controller;

import com.pegasus.springaop.service.IUserService;
import com.pegasus.springaop.service.impl.UserServiceImpl;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IUserService userService=new UserServiceImpl();
		userService.login("aesop", "123");
		System.out.println(userService.logout());
	}

}
