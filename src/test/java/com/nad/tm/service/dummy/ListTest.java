package com.nad.tm.service.dummy;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

public class ListTest {

	@Test
	public void testGetSize() {
		List listMock = Mockito.mock(List.class);
		Mockito.when(listMock.size()).thenReturn(2);
		assertEquals(2, listMock.size());
	}
	
	@Test
	public void testGetSizeWithMultipleReturnValues() {
		List listMock = Mockito.mock(List.class);
		Mockito.when(listMock.size()).thenReturn(10, 5, 0);
		assertEquals(10, listMock.size());
		assertEquals(5, listMock.size());
		assertEquals(0, listMock.size());
	}
	
	@Test
	public void testGet() {
		List listMock = Mockito.mock(List.class);
		Mockito.when(listMock.get(Mockito.anyInt())).thenReturn("One");
		assertEquals("One", listMock.get(0));
		assertEquals("One", listMock.get(1));
	}

	@Test(expected = RuntimeException.class)
	public void testGetException() {
		List listMock = Mockito.mock(List.class);
		Mockito.when(listMock.get(Mockito.anyInt())).thenReturn("One")
			.thenThrow(new RuntimeException("IndexOutOfBounds"));
		listMock.get(0);
		listMock.get(1);
	}
}
