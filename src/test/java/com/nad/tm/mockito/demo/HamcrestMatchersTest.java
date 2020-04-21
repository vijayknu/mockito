package com.nad.tm.mockito.demo;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class HamcrestMatchersTest {

	/**
	 * https://stackoverflow.com/questions/9651784/hamcrest-tests-always-fail
	 * I just removed JUnit library from my project configuration
	 */
	@Test
	public void test() {
		List<Integer> scores = Arrays.asList(12, 13, 14, 15);
		assertThat(scores, hasSize(4));
		assertThat(scores, hasItems(12));
		
		assertThat(scores, everyItem(greaterThan(10)));
		assertThat(scores, everyItem(lessThan(20)));
	}

}
