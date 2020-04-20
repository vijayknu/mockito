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
	
	public List<String> filterTodos(String user) {
		List<String> fileredList = new ArrayList<String>();
		List<String> todoList = todoService.findTodos(user);
		for(String todo : todoList) {
			if(todo.contains("Spring"))
				fileredList.add(todo);
		}
		return fileredList;
	}
	
	public void deleteTodosOtherThanSpring(String user){
		List<String> todoList = todoService.findTodos(user);
		for(String todo : todoList) {
			if(!todo.contains("Spring")) {
				todoService.deleteTodos(todo);
			}
		}
	}

}
