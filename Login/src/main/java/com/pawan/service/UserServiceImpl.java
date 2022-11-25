package com.pawan.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pawan.dto.UserDTO;
import com.pawan.dto.UserLoginDTO;
import com.pawan.model.Role;
import com.pawan.model.User;
import com.pawan.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(UserDTO userdto) {
		User myuser = userRepository.findByEmail(userdto.getEmail());
		if(myuser !=null) {
			return null;
		}
		User user = new User(userdto.getFirstName(), userdto.getLastName(), userdto.getEmail(), userdto.getPassword(), Arrays.asList(new Role("UserRole")));
		return userRepository.save(user);
	}

	@Override
	public User UserLoggin(UserLoginDTO user) {
		User myuser = userRepository.findByEmail(user.getEmail());
		
		if(myuser != null) {
			if(user.getPassword().equals(myuser.getPassword())) {
				return myuser;
			}
			return null;
		}
		return null;
		
	}
	
	
	
	

}
