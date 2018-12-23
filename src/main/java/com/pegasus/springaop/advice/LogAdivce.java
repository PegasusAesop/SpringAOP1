package com.pegasus.springaop.advice;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

import org.springframework.aop.MethodBeforeAdvice;
//import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;
//import org.springframework.aop.framework.ProxyFactoryBean;

public class LogAdivce implements MethodBeforeAdvice{

	//NameMatchMethodPointcutAdvisor
	//ProxyFactoryBean
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		
		System.out.println(method.getName()+" is launching:["+new Date().getTime()+"]"+Arrays.toString(args));
		
		
	}

}
