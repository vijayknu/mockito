package com.nad.tm.service.dummy;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.nad.tm.api.dummy.TodoService;
import com.nad.tm.api.dummy.TodoServiceStub;

public class TodoServiceImplStubTest {

	@Test
	public void testFilterTodos_Stub() {
		TodoService todoServiceStub = new TodoServiceStub();
		TodoServiceImpl todoServiceImpl = new TodoServiceImpl(todoServiceStub);
		List<String> filteredTodos = todoServiceImpl.filterTodos("Dummy");
		assertEquals(2, filteredTodos.size());
	}
	
	@Test
	public void testFilterTodos_Stub_2() {
		TodoServiceImpl todoServiceImpl = new TodoServiceImpl(new TodoServiceStub());
		List<String> filteredTodos = todoServiceImpl.filterTodos("Spring");
		assertEquals(true, containsString(filteredTodos, "Spring"));
			
	}

	private boolean containsString(List<String> filteredTodos, String filterText) {
		for(String todo : filteredTodos) {
			if(todo.contains(filterText))
				return true;
		}
		return false;
	}

}
