package com.nad.tm.service.dummy;

import java.util.ArrayList;
import java.util.List;

import com.nad.tm.api.dummy.TodoService;

//SUT
//This is client of TodoService API. Just think like that.
//it's confusing to name the class like below
public class TodoServiceImpl {

	//Dependency
	private TodoService todoService;
	
	public TodoServiceImpl(TodoService todoService) {
		this.todoService = todoService;
	}
	
	public List<String> filterTodos(String searchTerm) {
		List<String> fileredList = new ArrayList<String>();
		List<String> todoList = todoService.findTodos(searchTerm);
		for(String todo : todoList) {
			if(todo.contains(searchTerm))
				fileredList.add(todo);
		}
		return fileredList;
	}

}
