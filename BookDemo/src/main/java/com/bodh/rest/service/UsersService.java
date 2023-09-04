package com.bodh.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.bodh.rest.entity.User;
import com.bodh.rest.exception.ResourceNotModifiedException;
import com.bodh.rest.repository.UserRepository;

@Service
public class UsersService
{
	@Autowired
	UserRepository userRepository;
	@Autowired
	RestTemplate restTemplate;
	
	@Transactional(readOnly=true)
	public List<User> getAllUsers()
	{
		return userRepository.findAll();
	}

	@Transactional(readOnly=true)
	public User getUserByUserId(int userId)
	{
		Optional<User> p=userRepository.findById(userId);
		if(p.isPresent())
		{
			User user=p.get();
			
			return user;
		}
	
		return null;
	}
	@Transactional
	public void insertOrModifyUser(User user)
	{
		if(userRepository.save(user)==null)
			throw new ResourceNotModifiedException();
	}
	@Transactional
	public boolean deleteUserByUserId(int userId)
	{
		long count=userRepository.count();
		userRepository.deleteById(userId);
		return count>userRepository.count();
	}


	
	
}


