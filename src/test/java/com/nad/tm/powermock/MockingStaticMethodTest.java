package com.nad.tm.powermock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UtilityClass.class)
public class MockingStaticMethodTest {
	
	@Mock
	private Dependency dependency;
	
	@InjectMocks
	private SystemUnderTest systemUnderTest;
	
	@Test
	public void testFilterTodos_Mock() {
		
		List<Integer> stats = Arrays.asList(1,2,3);
		
		when(dependency.retrieveAllStats()).thenReturn(stats);

		PowerMockito.mockStatic(UtilityClass.class);
		
		when(UtilityClass.staticMethod(6)).thenReturn(160);
		
		assertEquals(160, systemUnderTest.methodCallingAStaticMethod());
		
		PowerMockito.verifyStatic();
		
		UtilityClass.staticMethod(6);
		
	}
	
}
