package com.app.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Dto.ApiResponse;
import com.app.Dto.UserDto;
import com.app.Entities.User;
//import com.app.Repositery.PassengerRepositery;
import com.app.Repositery.UserRepositery;

@Service
@Transactional
public class UserServiceImpl implements UserService {
//	@Autowired
//	private PassengerRepositery passenger;
	@Autowired
	private UserRepositery repo;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ApiResponse AddUser(UserDto user) {
        User newUser=modelMapper.map(user,User.class);
		 repo.save(newUser);
		return  new ApiResponse("User "+newUser.getUserId() +newUser.getFirstName() + newUser.getLastName() + " Registration Successfully");
	
	}

	List<User> list= new ArrayList<User>();
	
	
//	public UserServiceImpl() {
//          list.add(new User("U001","Rahul","Jain","rjain17609@gmail.com","1234","7023666199","user",LocalDate.parse("1997-08-13")));
//          list.add(new User("U002","pankaj","chhipa","pankajchippa1997@gmail.com","1234","8562820638","user",LocalDate.parse("1997-11-08")));
//	
//	}
	//get all user
	public List getAllUsers(){
	 return this.list;
		
		
	}
	public User getUser(String firstName) {
		
		return this.list.stream().filter((User)->User.getFirstName().equals(firstName)).findAny().get();
	}
}
