package com.UserManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UserManagement.Model.UserDtls;

public interface UserRepository  extends JpaRepository<UserDtls,Integer>{

	public boolean existsByEmail(String email);
}
