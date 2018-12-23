package com.pegasus.springaop.service.proxy;

import java.util.Date;

import com.pegasus.springaop.service.IUserService;
import com.pegasus.springaop.service.impl.UserServiceImpl;

public class UserServiceProxy implements IUserService{

	IUserService userService=new UserServiceImpl();
	
	@Override
	public void login(String name, String password) {
		
		System.out.println("login is start:"+new Date().getTime());
		userService.login(name, password);
		System.out.println("-------------------------");
	}

	@Override
	public String logout() {
		System.out.println("logout is start:"+new Date().getTime());
		
		return userService.logout();
		
	}

	
}
