package com.bodh.book.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.bodh.rest.entity.User;
import com.bodh.rest.exception.ResourceNotModifiedException;
import com.bodh.rest.service.UsersService;

@RequestMapping("/users")
@RestController
public class UsersController 
{
	@Autowired
	UsersService usersService;
	@GetMapping()
	public ResponseEntity<List<User>> getAllUsers()
	{
		List<User> plist= usersService.getAllUsers();	
		if(plist.size()!=0)
			return new ResponseEntity<List<User>>(plist,HttpStatus.OK);
		return new ResponseEntity<List<User>>(plist,HttpStatus.NOT_FOUND);
		
	}
	@GetMapping(value="/{userId}")
	public ResponseEntity<User> getUsersByUsersId(@PathVariable int userId)
	{
		User p=usersService.getUserByUserId(userId);
		if(p!=null)
			return new ResponseEntity<User>(p,HttpStatus.OK);
		return new ResponseEntity<User>(p,HttpStatus.NOT_FOUND);
		
	}
	@PostMapping(consumes="application/json")
	public HttpStatus insertUser(@RequestBody  User user)
	{
		usersService.insertOrModifyUser(user);
			return HttpStatus.OK;
		
	}
	@PutMapping(consumes="application/json")
	public HttpStatus modifyUser(@RequestBody User  user)
	{
		usersService.insertOrModifyUser(user);
			return HttpStatus.OK;
		
		
	}
	@DeleteMapping("/{userId}")
	public HttpStatus deleteUser(@PathVariable int userId)
	{
		if(usersService.deleteUserByUserId(userId))
			return HttpStatus.OK;
		return HttpStatus.NOT_FOUND;
	}
	@ExceptionHandler(ResourceNotModifiedException.class)
	public HttpStatus notModifiedExceptionHandler()
	{
		return HttpStatus.NOT_MODIFIED;
	}
	
}
