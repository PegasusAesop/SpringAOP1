package com.pegasus.springaop.service.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

import com.pegasus.springaop.service.IUserService;
import com.pegasus.springaop.service.impl.UserServiceImpl;

public class UserServiceProxyUpdate implements IUserService{

	IUserService userService=new UserServiceImpl();
	
	@Override
	public void login(String name, String password) {
		
		//System.out.println("login is start:"+new Date().getTime());
		//userService.login(name, password);
		//System.out.println("-------------------------");
		try {
			
			Method method=userService.getClass().getMethod("login",String.class,String.class);
			invoke(method,name,password);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public String logout() {
		//System.out.println("logout is start:"+new Date().getTime());
		//return userService.logout();

		try {
			return invoke(userService.getClass().getMethod("logout")).toString();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}
	//0封装一个公共方法中，统一入口，模块化；
	public Object invoke(Method method,Object ...args) {
		//1前置增强工作
		System.out.println(method.getName()+" is start:"+new Date().getTime());
		
		//2业务方法调用；
		try {
			
			return method.invoke(userService, args);
			
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	
}
