package codeathon.app.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "todos")
@Data
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long todoId;
    private String description;
    private String dueDate;
    private String priorityLevels;
    private String taskCategories;
    private String remainders;
    
    }