package codeathon.app.Payload;

import lombok.Data;

@Data
public class TodoDTO {

	private long todoId;
    private String description;
    private String dueDate;
    private String priorityLevels;
    private String taskCategories;
    private String remainders;
}
