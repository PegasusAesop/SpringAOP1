package com.pegasus.springaop.controller;

import com.pegasus.springaop.service.IUserService;
import com.pegasus.springaop.service.proxy.UserServiceProxy;

public class TestProxy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IUserService userService=new UserServiceProxy();
		userService.login("aesop", "123");
		System.out.println(userService.logout());
	}

}
