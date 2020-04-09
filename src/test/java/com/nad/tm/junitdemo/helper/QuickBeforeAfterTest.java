package com.nad.tm.junitdemo.helper;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class QuickBeforeAfterTest {

	private static StringHelper helper = null;
	
	@BeforeClass
	public static void runOnlyOnce() {
		helper = new StringHelper();
		System.out.println("before class");
	}
	
	@Before
	public void setUp() {
		System.out.println("Before");
	}
	
	@Test
	public void test1() {
		System.out.println("test1");
	}
	
	@Test
	public void test2() {
		System.out.println("test2");
	}
	
	@After
	public void tearDown() {
		System.out.println("after");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("after class");
	}
}
