package com.pegasus.springaop.controller;

import com.pegasus.springaop.service.IUserService;
import com.pegasus.springaop.service.proxy.UserServiceProxyUpdate;

public class TestProxyUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IUserService userService=new UserServiceProxyUpdate();
		userService.login("PegausUpdate", "11123");
		System.out.println(userService.logout());
	}

}
