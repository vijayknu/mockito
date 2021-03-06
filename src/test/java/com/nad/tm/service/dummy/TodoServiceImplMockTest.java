package com.nad.tm.service.dummy;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
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
	
	@Test
	public void testDeleteTodosNotRelatedToSpring_BDD() {
		
		//Given
		TodoService todoService = mock(TodoService.class);
		TodoServiceImpl todoServiceImpl = new TodoServiceImpl(todoService);
		List<String> todosList = Arrays.asList("Learn Spring MVC","Learn Java", "Learn Spring Boot");
		given(todoService.findTodos("Dummy")).willReturn(todosList);
		
		//when
		todoServiceImpl.deleteTodosOtherThanSpring("Dummy");
		
		//then
		verify(todoService).deleteTodos("Learn Java");
		verify(todoService, never()).deleteTodos("Learn Spring MVC");
		verify(todoService, times(1)).deleteTodos("Learn Java");
		verify(todoService, atLeastOnce()).deleteTodos("Learn Java");
		
		then(todoService).should().deleteTodos("Learn Java");
		then(todoService).should(never()).deleteTodos("Learn Spring MVC");
		then(todoService).should(never()).deleteTodos("Learn Spring Boot");
	}
	
	@Test
	public void testDeleteTodosNotRelatedToSpring_BDD_captureArguments() {
		
		ArgumentCaptor<String> argCaptr = ArgumentCaptor.forClass(String.class);
		
		//Given
		TodoService todoService = mock(TodoService.class);
		TodoServiceImpl todoServiceImpl = new TodoServiceImpl(todoService);
		List<String> todosList = Arrays.asList("Learn Python", "Learn Spring MVC","Learn Java", "Learn Spring Boot");
		given(todoService.findTodos("Dummy")).willReturn(todosList);
		
		//when
		todoServiceImpl.deleteTodosOtherThanSpring("Dummy");
		
		//then
		verify(todoService).deleteTodos("Learn Java");
		verify(todoService, never()).deleteTodos("Learn Spring MVC");
		verify(todoService, times(1)).deleteTodos("Learn Java");
		verify(todoService, atLeastOnce()).deleteTodos("Learn Java");
		
		then(todoService).should().deleteTodos("Learn Java");
		then(todoService).should(never()).deleteTodos("Learn Spring MVC");
		then(todoService).should(never()).deleteTodos("Learn Spring Boot");
		
		then(todoService).should(times(2)).deleteTodos(argCaptr.capture());
		assertThat(argCaptr.getAllValues().size(), is(2));
	}
}
