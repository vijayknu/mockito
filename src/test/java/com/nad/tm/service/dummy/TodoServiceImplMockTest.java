package com.nad.tm.service.dummy;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

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
		
		when(todoService.findTodos("Spring")).thenReturn(todosList);
		
		List<String> filteredTodos = todoServiceImpl.filterTodos("Spring");
		assertEquals(2, filteredTodos.size());
	}

	@Test
	public void testFilterTodos_BDDMock() {
		
		//Given
		TodoService todoService = Mockito.mock(TodoService.class);
		TodoServiceImpl todoServiceImpl = new TodoServiceImpl(todoService);
		List<String> todosList = Arrays.asList("Learn Spring MVC","","Learn Java", "Learn Spring Boot");
		given(todoService.findTodos("Spring")).willReturn(todosList);
		
		//When
		List<String> filteredTodos = todoServiceImpl.filterTodos("Spring");
		
		//Then
		assertThat(filteredTodos.size(), is(2));
		
	}
}
