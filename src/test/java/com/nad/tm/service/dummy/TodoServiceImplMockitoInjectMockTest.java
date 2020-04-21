package com.nad.tm.service.dummy;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.nad.tm.api.dummy.TodoService;

//@RunWith(MockitoJUnitRunner.class)
public class TodoServiceImplMockitoInjectMockTest {

	@Rule
	public MockitoRule rule = MockitoJUnit.rule();
	
	@Mock
	private TodoService todoService;
	
	@InjectMocks
	private TodoServiceImpl todoServiceImpl;

	@Captor
	private ArgumentCaptor<String> argCaptr;
	
	@Test
	public void testFilterTodos_Mock() {
		
		List<String> todosList = Arrays.asList("Learn Spring MVC","","Learn Java", "Learn Spring Boot");
		
		when(todoService.findTodos("Spring")).thenReturn(todosList);
		
		List<String> filteredTodos = todoServiceImpl.filterTodos("Spring");
		assertEquals(2, filteredTodos.size());
	}

	@Test
	public void testFilterTodos_BDDMock() {
		
		//Given
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
		
		//Given
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
