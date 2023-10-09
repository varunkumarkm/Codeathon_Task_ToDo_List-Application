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
public class TodoService {

	@Autowired
	private TodoRepository todoRepository;
	
	private ModelMapper mapper;
	
	public TodoService(ModelMapper mapper) {
		this.mapper = mapper;
	}

	public TodoDTO createTodos(TodoDTO todoDto) {
		Todo todo = mapToEntity(todoDto);
		Todo todoEntity = todoRepository.save(todo);
		TodoDTO dto = mapToDTO(todoEntity);
		return dto;
	}
	
	public List<TodoDTO> getAllTodosList() {
		List<Todo> todos = todoRepository.findAll();
		return todos.stream().map(todoList -> mapToDTO(todoList)).collect(Collectors.toList());
	}
	
	public TodoDTO getTodosById(long id) {
		Todo todo = todoRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Todo", "id", id)
				);
		TodoDTO todoDTO = mapToDTO(todo);
		return todoDTO;
		
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
