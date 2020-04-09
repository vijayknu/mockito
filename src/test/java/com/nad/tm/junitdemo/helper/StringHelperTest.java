package com.nad.tm.junitdemo.helper;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringHelperTest {

	private final static StringHelper stringHelper = new StringHelper();
	
	@Test
	public void testTruncateAInFirst2Positions_Ainfirst2Positions() {
		assertEquals("CD",stringHelper.truncateAInFirst2Positions("AACD"));
	}
	
	@Test
	public void testTruncateAInFirst2Positions_Ainlast2Positions() {
		assertEquals("CDAA",stringHelper.truncateAInFirst2Positions("CDAA"));
	}

	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_TC_001() {
		assertTrue(stringHelper.areFirstAndLastTwoCharactersTheSame("AB"));
	}

	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_TC_002() {
		assertFalse(stringHelper.areFirstAndLastTwoCharactersTheSame("A"));
	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_TC_003() {
		assertFalse(stringHelper.areFirstAndLastTwoCharactersTheSame("ABCD"));
	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_TC_004() {
		assertTrue(stringHelper.areFirstAndLastTwoCharactersTheSame("ABAB"));
	}
}
