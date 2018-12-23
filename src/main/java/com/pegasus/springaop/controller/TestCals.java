package com.pegasus.springaop.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pegasus.springaop.service.ICalcService;

public class TestCals {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext ac=new ClassPathXmlApplicationContext("./spring-aop/applicationContext_calc.xml");
		ICalcService calcService = (ICalcService) ac.getBean("calcService");
		
		System.out.println(calcService.add(1, 2));
		System.out.println(calcService.add(1, 2));
		System.out.println(calcService.add(1, 1));
		System.out.println(calcService.minus(1, 2));
		System.out.println(calcService.minus(1, 2));
		System.out.println(calcService.add(1, 1));
		
		
		
	}

}
