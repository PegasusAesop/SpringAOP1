package com.pegasus.springaop.advice;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class TimerAdvice implements MethodInterceptor{

	private Long time;
	
	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		Method method = invocation.getMethod(); 
		//Object[] arguments = invocation.getArguments();
		//Object target = invocation.getThis();
		
		//业务方法执行前；
		long startTime=System.currentTimeMillis();
		System.out.println(method.getName()+" is start>>>");
		
		Object result = invocation.proceed(); //1执行业务逻辑，其它就是调用业务方法；
		
		//业务方法执行后；
		long endTime=System.currentTimeMillis();
		System.out.println(method.getName()+" is end>>>");
		
		long totalTime=endTime-startTime;
		System.out.println(method.getName()+" totalTime: "+totalTime);
		if(totalTime>time) {
			System.out.println("!!!! 程序执行严重超时！");
		}
		
		return result;//此返回值是业务方法返回值；
	}

}
