package com.pegasus.springaop.advice;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.aop.AfterReturningAdvice;

public class GoodbyeAdvice implements AfterReturningAdvice{

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		
		System.out.println("GoodbyAdvice,target: "+target
				+",method:"+method.getName()+",args:"
		+Arrays.toString(args)+",returnValue: +"+returnValue);
	}

}
