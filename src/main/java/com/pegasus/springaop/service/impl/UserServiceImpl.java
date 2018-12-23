package com.pegasus.springaop.service.impl;

import com.pegasus.springaop.service.IUserService;

public class UserServiceImpl implements IUserService {
	
	@Override
	public void login(String username, String password) {
		
		System.out.println("login() is launching."+username);
		
		/*int x=5/0;
		System.out.println(x);*/
		
		/*String str=null;
		System.out.println(str.toString());*/
		
		/*try {
			Class.forName("");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public String logout() {
		
		System.out.println("logout() is launching.");
		return "Bye bye...";
	}

}
