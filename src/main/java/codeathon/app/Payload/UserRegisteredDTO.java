package codeathon.app.Payload;

import lombok.Data;

@Data
public class UserRegisteredDTO {

	
    private String name;
	
	private String email_id;
	
	private String password;
	
	private String role;
}
