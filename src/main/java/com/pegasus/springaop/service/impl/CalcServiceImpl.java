package com.pegasus.springaop.service.impl;

import com.pegasus.springaop.service.ICalcService;

public class CalcServiceImpl implements ICalcService {

	@Override
	public int add(int a, int b) {
		System.out.println("CalcServiceImpl.add()");
		return a+b;
	}

	@Override
	public double minus(double a, double b) {
		System.out.println("CalcServiceImpl.minus()");
		return a-b;
	}

}
