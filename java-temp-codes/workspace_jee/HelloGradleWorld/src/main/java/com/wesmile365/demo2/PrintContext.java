package com.wesmile365.demo2;

import java.lang.reflect.Field;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class PrintContext {

	@Test(enabled = true)
	public void printContext1(ITestContext ctx) {
		System.out.println("===================");
		Class clas = ctx.getClass();
		
		System.out.println("------------------- get class name.");
		System.out.println(clas.getName());
		
		System.out.println("------------------- get interfaces.");
		Class[] is = clas.getInterfaces();
		for (Class i : is) {
			System.out.println(i.getName());
		}
		
		System.out.println("------------------- get declared classes.");
		Class[] dcs = clas.getDeclaredClasses();
		for (Class dc : dcs) {
			System.out.println(dc.getName());
		}
		
		System.out.println("-------------------");
	}

	@Test(enabled = false)
	public void printContext(ITestContext ctx) {
		System.out.println(ctx.getName());
		System.out.println(ctx.getAllTestMethods()[0].getMethodName());
		System.out.println(ctx.getOutputDirectory());
		System.out.println(ctx.getSuite().getName());
		System.out.println(ctx.getSuite().getParameter("key1"));
		System.out.println(ctx.getSuite().getParameter("key2"));
	}

}
