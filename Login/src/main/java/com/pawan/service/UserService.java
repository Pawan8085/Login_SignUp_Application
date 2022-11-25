package com.pawan.service;

import com.pawan.dto.UserDTO;
import com.pawan.dto.UserLoginDTO;
import com.pawan.model.User;

public interface UserService {
	
	User save(UserDTO userdto);
	
	User UserLoggin(UserLoginDTO user);
	
}
