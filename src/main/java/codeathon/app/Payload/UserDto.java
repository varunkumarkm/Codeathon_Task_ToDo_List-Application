package codeathon.app.Payload;

import lombok.Data;

@Data
public class UserDto {
	
	private String email;
	private String password;
	private String role;
	private String fullname;

 }
