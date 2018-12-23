package com.pegasus.springaop.controller;

import java.lang.reflect.Method;
import java.util.Date;

import com.pegasus.springaop.domain.HelloWorld;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;

public class TestCGLIB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HelloWorld helloWorld = (HelloWorld) Enhancer.create(
				HelloWorld.class, //1目标类的类型；
				new InvocationHandler() {//2交叉业务逻辑

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						//1前置处理；
						System.out.println(method.getName()+"(CGLIB) is begin....["+new Date().getTime()+"]");
						
						Object result = method.invoke(new HelloWorld(), args);
						
						return result;
					}
					
				});
		
		helloWorld.sayHello();
		
		System.out.println(helloWorld.getClass());
	}

}
