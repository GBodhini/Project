package com.UserManagement.Service;

import com.UserManagement.Model.UserDtls;

public interface UserService {
	public UserDtls createUser(UserDtls user);
	
	public boolean checkEmail(String email);
}
