package codeathon.app.Services;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import codeathon.app.Entities.Todo;
import codeathon.app.Exception.ResourceNotFoundException;
import codeathon.app.Payload.TodoDTO;
import codeathon.app.Repositories.TodoRepository;


@Service
public class TodoServiceThymeleaf {

	@Autowired
	private TodoRepository todoRepository;
	
    private ModelMapper mapper;
	
	public TodoServiceThymeleaf(ModelMapper mapper) {
		this.mapper = mapper;
	}

	public List<TodoDTO> getAllTodos() {
		List<Todo> todos = todoRepository.findAll();
		return todos.stream().map(todoDto -> mapToDTO(todoDto)).collect(Collectors.toList());
	}
	
	public TodoDTO getTodoById(long todoId) {
		Todo todo = todoRepository.findById(todoId).orElseThrow(
				()-> new ResourceNotFoundException("Todo", "todoId", todoId)
				);
		TodoDTO todoDTO = mapToDTO(todo);
		return todoDTO;
	}
	
	public TodoDTO saveTodo(TodoDTO todoDto) {
		Todo todo = mapToEntity(todoDto);
		Todo todoEntity = todoRepository.save(todo);
		TodoDTO dto = mapToDTO(todoEntity);
		return dto;
	}
	
	public void deleteTodo(Long todoId) {
		todoRepository.deleteById(todoId);
	}
	
	public TodoDTO updateTodo(TodoDTO todoDto) {
		Todo todo = mapToEntity(todoDto);
		Todo todoEntity = todoRepository.save(todo);
		TodoDTO dto = mapToDTO(todoEntity);
		return dto;
	}
	
	
	
	
	public Todo mapToEntity(TodoDTO todoDto) {
		Todo todo = mapper.map(todoDto, Todo.class);
		return todo;
	}
	
	public TodoDTO mapToDTO(Todo todo) {
		TodoDTO dto = mapper.map(todo, TodoDTO.class);
		return dto;
	}

}
