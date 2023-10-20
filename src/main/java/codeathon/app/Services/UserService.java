package codeathon.app.Services;

import codeathon.app.Entities.User;
import codeathon.app.Payload.UserDto;

public interface UserService {
	
	User save (UserDto userDto);
	

}
