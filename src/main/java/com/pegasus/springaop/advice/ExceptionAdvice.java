package com.pegasus.springaop.advice;

import org.springframework.aop.ThrowsAdvice;

public class ExceptionAdvice implements ThrowsAdvice{

	public void afterThrowing(Exception ex) {
		
		System.out.println("ExceptionAdvice.afterThrowing,ex"+ex);
	}
	
	public void afterThrowing(ArithmeticException ex) {
		
		System.out.println("ExceptionAdivc;e.afterThrowing(ArithmeticException ex)"+ex+":短信通知");
	}
	
	public void afterThrowing(NullPointerException ex) {
		
		System.out.println("ExceptionAdivc;e.afterThrowing(NullPointerException ex)"+ex+":邮件通知");
	}
}
