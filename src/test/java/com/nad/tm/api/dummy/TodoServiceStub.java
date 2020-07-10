package com.nad.tm.api.dummy;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService {

	public List<String> findTodos(String user) {

		return Arrays.asList("Learn Spring MVC","","Learn Java", "Learn Spring Boot");
	}

	public void deleteTodos(String todo) {
		// TODO Auto-generated method stub
		
	}

}
