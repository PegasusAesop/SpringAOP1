package com.pegasus.springaop.controller;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

import com.pegasus.springaop.service.IUserService;
import com.pegasus.springaop.service.impl.UserServiceImpl;

public class TestProxyDynamic {

	public static void main(String[] args) {
		
		//IUserService target=new UserServiceImpl();
		//0调用Proxy类的newProxyInstance()方法动态的生成代理类和实例；
		IUserService userService=(IUserService) Proxy.newProxyInstance(
				UserServiceImpl.class.getClassLoader(), //1目标类的类加载器；
				new Class[] {IUserService.class}, //2目标类的接口列表；
				new InvocationHandler() {  //3交叉来务逻辑实现

					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						//1前置增强工作-打印日志；
						System.out.println(method.getName()+" is start:"+new Date().getTime());
						//2执行业务方法；
						Object result=null;
						System.out.println("开启事务....");
						try {
							result = method.invoke(new UserServiceImpl(), args);
							//int x=5/0;
							//System.out.println(x);
							System.out.println("提交事务....");
							
						}catch(Exception e) {
							System.out.println("回滚事务...");
							
							throw e;//1此处一定要抛出异常而不是处理异常！！！
						}
						
						return result;
					}
					
				});
				/*
		IUserService userService=(IUserService) Proxy.newProxyInstance(
				target.getClass().getClassLoader(), //1目标类的类加载器；
				target.getClass().getInterfaces(), //2目标类的接口列表；
				//3Lambda expression;InvocationHandler类即交叉来务逻辑实现；
				(proxy,method,params) -> {
					//1前置增强工作-打印日志；
					System.out.println(method.getName()+" is start:"+new Date().getTime());
					//2执行业务方法；
					Object result = method.invoke(target, params);
					return result;
					
				});*/
				
		
		userService.login("Pegasus", "888");
		System.out.println("------------------------------");
		
		String message=userService.logout();
		System.out.println(message);
		
		System.out.println(userService.getClass());
	}

}
