package codeathon.app.Payload;

import lombok.Data;

@Data
public class TodoDTO {

	    private long id;
	    private String userName;
	    private String description;
	    private String dueDate;
	    private String priorityLevels;
	    private String taskCategories;
}
