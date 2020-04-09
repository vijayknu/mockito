package com.nad.tm.junitdemo.helper;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StringHelperParameterizedTest {

	private final static StringHelper stringHelper = new StringHelper();
	
	private String input;
	private String output;
	
	
	public StringHelperParameterizedTest(String input, String output) {
		this.input = input;
		this.output = output;
	}

	@Parameters
	public static Collection<String[]> testConditions() {
		String output[][] ={
					{"AACD", "CD"},
					{"ACD", "CD"}
				};
		return Arrays.asList(output);
	}
	
	@Test
	public void testTruncateAInFirst2Positions_Ainfirst2Positions() {
		assertEquals(output,stringHelper.truncateAInFirst2Positions(input));
	}
}
