package codeathon.app.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import codeathon.app.Payload.TodoDTO;
import codeathon.app.Services.TodoService;


@RestController
@RequestMapping("/todos")
public class TodoController {

	@Autowired
	private TodoService todoService;
	
	@PostMapping("/create")
	public ResponseEntity<TodoDTO> createTask(@RequestBody TodoDTO todoDto){
		return new ResponseEntity<TodoDTO>(todoService.createTodos(todoDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/retrive")
	public List<TodoDTO> getAllTodos(){
		return todoService.getAllTodosList();
	}
	
	@GetMapping("/retrive/{id}")
	public ResponseEntity<TodoDTO> getTodosById(@PathVariable long id){
		return ResponseEntity.ok(todoService.getTodosById(id));	
	}
}
