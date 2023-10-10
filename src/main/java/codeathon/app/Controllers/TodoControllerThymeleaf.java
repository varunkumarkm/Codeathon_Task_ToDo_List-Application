package codeathon.app.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import codeathon.app.Exception.ResourceNotFoundException;
import codeathon.app.Payload.TodoDTO;
import codeathon.app.Services.TodoServiceThymeleaf;

@Controller
public class TodoControllerThymeleaf {
	
	@Autowired
	private TodoServiceThymeleaf todoservice;

    @GetMapping("/todos_list")
    public String showTodoPage(ModelMap model) {
    	List<TodoDTO> todoDTO = todoservice.getAllTodos();
    	model.addAttribute("todoDTO", todoDTO);
        return "todos_list";
    }
    
    @GetMapping("/todos_list/{id}")
    public String showTodoById(@PathVariable long id, ModelMap model) {
    	try {
    	TodoDTO todoDTO = todoservice.getTodoById(id);
    	model.addAttribute("todoDTO", todoDTO);
		return "todos_list";
    	} catch (ResourceNotFoundException e) {
            return "error-page"; 
        }
    }
    
    @RequestMapping("/create_todo")
    public String createOneTodo(@ModelAttribute TodoDTO todoDto, ModelMap model, RedirectAttributes redirectAttributes) {
    	TodoDTO saveTodo = todoservice.saveTodo(todoDto);
        model.addAttribute("saveTodo", saveTodo);
        redirectAttributes.addFlashAttribute("message", "Todo is saved successfully!!!");
        return "redirect:todos_list";
    }
    
    @RequestMapping("/delete_todo")
    public String deleteOneTodo(@RequestParam("id") long id, ModelMap model) {
    	todoservice.deleteTodo(id);
    	List<TodoDTO> todos = todoservice.getAllTodos();
    	model.addAttribute("todos", todos);
        return "redirect:todos_list";
    }
  
    @RequestMapping("/update")
    public String updateOneTodo(@RequestParam("id") long id, ModelMap model) {
        TodoDTO existingTodo = todoservice.getTodoById(id);
        model.addAttribute("existingTodo", existingTodo);
        return "update_todo";
    }
    
    @RequestMapping("/update_todo")
    public String updateTodo(TodoDTO todoDto, ModelMap model, RedirectAttributes redirectAttributes) {
    	
    	TodoDTO existingTodo = new TodoDTO();
    	existingTodo.setId(todoDto.getId());
    	existingTodo.setUserName(todoDto.getUserName());
    	existingTodo.setDescription(todoDto.getDescription());
    	existingTodo.setDueDate(todoDto.getDueDate());
    	existingTodo.setPriorityLevels(todoDto.getPriorityLevels());
    	existingTodo.setTaskCategories(todoDto.getTaskCategories());
    	
        todoservice.updateTodo(existingTodo); 
        
        model.addAttribute("existingTodo", existingTodo);
        redirectAttributes.addFlashAttribute("message", "Todo updated successfully!!!");
        List<TodoDTO> todos = todoservice.getAllTodos();
    	model.addAttribute("todos", todos);
        return "redirect:todos_list";
    }
}





