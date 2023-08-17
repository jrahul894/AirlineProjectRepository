package com.app.Repositery;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Dto.UserDto;
import com.app.Entities.User;

public interface UserRepositery extends JpaRepository<User, String> {

//	Optional<String> UserRegistration(UserDto user);
}
