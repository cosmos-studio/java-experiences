package com.wesmile365.demo;

import org.testng.annotations.Test;

public class Bar {

	public Bar() {
		System.out.println("Bar()");
	}

	@Test
	public void test2() throws Exception {
		System.out.println("Bar => 2");
	}

	@Test
	public void test4() throws Exception {
		System.out.println("Bar => 4");
	}

	@Test
	public void test6() throws Exception {
		System.out.println("Bar => 6");
	}
}
