package ch01.service;

import java.text.Collator;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import ch01.todo.TodoDTO;

public enum TodoService {
	
		INSTANCE; // 객체의 개수 결정, 한개만 지정되었으므로 하나의 객체만 생성 o 
		// Todoservice.INSTANCE는 1개의 객체만을 가리킴
		
	public void register(TodoDTO todoDTO) {
		System.out.println("DEBUG..." + todoDTO);
	}
	
	public List<TodoDTO> getlist(){
		List<TodoDTO> todoDTOs = IntStream.range(0, 10).mapToObj(i -> {
			TodoDTO dto = new TodoDTO();
			dto.setTno((long)i);
			dto.setTitle("Todo.." + i);
			dto.setDueDate(LocalDate.now());
			return dto;
		}).collect(Collectors.toList());
		
		return todoDTOs;
	}
	
}
