package com.nad.tm.service.dummy;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import com.nad.tm.api.dummy.TodoService;

public class TodoServiceImplMockTest {

	@Test
	public void testFilterTodos_Mock() {
		//TodoService todoServiceStub = new TodoServiceStub();
		TodoService todoService = Mockito.mock(TodoService.class);
		TodoServiceImpl todoServiceImpl = new TodoServiceImpl(todoService);
		
		List<String> todosList = Arrays.asList("Learn Spring MVC","","Learn Java", "Learn Spring Boot");
		
		Mockito.when(todoService.findTodos("Dummy")).thenReturn(todosList);
		
		List<String> filteredTodos = todoServiceImpl.filterTodos("Dummy");
		assertEquals(2, filteredTodos.size());
	}

}
