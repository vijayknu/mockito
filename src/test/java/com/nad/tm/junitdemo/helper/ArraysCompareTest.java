package com.nad.tm.junitdemo.helper;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ArraysCompareTest {

	@Test
	public void testArray_TC_001() {
		int[] numbers = new int[] {12, 3, 5, 9};
		int[] sortedNumbers = new int[] {3, 5, 9, 12};
		Arrays.sort(numbers);
		assertArrayEquals(sortedNumbers, numbers);
	}
	
	@Test(expected = NullPointerException.class)
	public void testArray_TC_002() {
		int[] numbers = null;
		Arrays.sort(numbers);
	}
	
	@Test(timeout = 10)
	public void testArray_TC_003() {
		int[] array = new int[] {12, 23, 4};
		for(int i=0; i<=1000000; i++) {
			array[0] = i;
			Arrays.sort(array);
		}
	}

}
