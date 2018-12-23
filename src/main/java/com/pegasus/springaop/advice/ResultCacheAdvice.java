package com.pegasus.springaop.advice;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.pegasus.springaop.domain.Key;

public class ResultCacheAdvice implements MethodInterceptor{

	//1定义一个cache.
	private Map<Key,Object> cache = new HashMap<>();
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		Method method = invocation.getMethod();
		Object[] args = invocation.getArguments();
		Object target = invocation.getThis();
		
		Key key=new Key();
		key.setMethod(method);
		key.setArgs(args);
		key.setTarget(target);
		//2.判断方法是否已然执先过？如果执行过，则直接返回结果；
		if(cache.containsKey(key)) {
			return cache.get(key);
		}
		//3如果未执行过，则调用执行来务方法；
		Object proceed=invocation.proceed();
		
		//4将结果添加到缓存中，以便下次直接到缓存中取得;
		cache.put(key, proceed);
		
		return proceed;
	}

}
