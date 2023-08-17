package com.app.Service;
import java.util.List;

import com.app.Dto.ApiResponse;
import com.app.Dto.UserDto;
import com.app.Entities.User;


public interface UserService {

	ApiResponse AddUser(UserDto user);
	
	
	User getUser(String firstName);
	
	public List getAllUsers();
}
