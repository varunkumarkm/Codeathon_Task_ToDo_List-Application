package codeathon.app.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import codeathon.app.Exception.ResourceNotFoundException;
import codeathon.app.Payload.TodoDTO;
import codeathon.app.Services.TodoServiceThymeleaf;

@Controller
public class TodoControllerThymeleaf {
	
	@Autowired
	private TodoServiceThymeleaf todoservice;

    @GetMapping("/todos_list")
    public String showTodoPage(Model model) {
    	List<TodoDTO> todos = todoservice.getAllTodos();
    	model.addAttribute("todos", todos);
        return "todos_list";
    }
    
    @GetMapping("/todos_list/{id}")
    public String showTodoById(@PathVariable long id, Model model) {
    	try {
    	TodoDTO todoDTO = todoservice.getTodoById(id);
    	model.addAttribute("todoDTO", todoDTO);
		return "todos_listById";
    	} catch (ResourceNotFoundException e) {
            return "error-page"; 
        }
    }
    
    @RequestMapping("/create_todo")
    public String createOneTodo(@ModelAttribute TodoDTO todoDto, ModelMap model) {
    	TodoDTO saveTodo = todoservice.saveTodo(todoDto);
        model.addAttribute("saveTodo", saveTodo);
        model.addAttribute("message", "Todo is saved successfully!!!");
        return "redirect:todos_list";
    }
}

