package com.wesmile365.demo;

import org.testng.annotations.Test;

public class Foo {

	public Foo() {
		System.out.println("Fool()");
	}

	@Test
	public void test1() throws Exception {
		System.out.println("Foo => 1");
	}

	@Test
	public void test3() throws Exception {
		System.out.println("Foo => 3");
	}

	@Test
	public void test5() throws Exception {
		System.out.println("Foo => 5");
	}

}
