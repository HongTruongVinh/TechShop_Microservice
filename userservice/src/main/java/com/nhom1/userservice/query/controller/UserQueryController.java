package com.nhom1.userservice.query.controller;

import java.util.List;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nhom1.userservice.query.model.UserResponseModel;
import com.nhom1.userservice.query.queries.GetAllUserQuery;
import com.nhom1.userservice.query.queries.GetUserByIdQuery;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

@RestController
@RequestMapping("/api/v1/user")
public class UserQueryController {
	@Autowired
	private QueryGateway queryGateway;
	
	@GetMapping("/{id}")
	public UserResponseModel getUserDetail(@PathVariable String id) {
		GetUserByIdQuery getUserByIdQuery = new GetUserByIdQuery();
		getUserByIdQuery.setId(id);
		
		UserResponseModel ProductResponseModel = queryGateway.query(getUserByIdQuery, 
				ResponseTypes.instanceOf(UserResponseModel.class)).join();
		
		return ProductResponseModel;
	}
	
	@GetMapping()
	public List<UserResponseModel> getAllProductDetail() {
		GetAllUserQuery getAllUserQuery = new GetAllUserQuery();


		List<UserResponseModel> list = queryGateway.query(getAllUserQuery, 
				ResponseTypes.multipleInstancesOf(UserResponseModel.class)).join();
		
		return list;
	}
	
	@GetMapping("/usersession") 
	public User getUserSession(){
		try {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			User userDetails = (User)auth.getPrincipal();
			return userDetails;
			
		} catch (Exception e) {
			return null;
		} 
	}
}
