package com.nhom1.userservice.query.projection;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nhom1.userservice.command.data.User;
import com.nhom1.userservice.command.data.UserRepository;
import com.nhom1.userservice.query.model.UserResponseModel;
import com.nhom1.userservice.query.queries.GetAllUserQuery;
import com.nhom1.userservice.query.queries.GetUserByIdQuery;

@Component
public class UserProjection {
	@Autowired
	private UserRepository userRepository;
	
	@QueryHandler
	public UserResponseModel handle(GetUserByIdQuery getUserByIdQuery) {
		UserResponseModel model = new UserResponseModel();
		User entity = userRepository.findById(getUserByIdQuery.getId()).get();
		BeanUtils.copyProperties(entity, model);
		
		return model;
	}
	
	@QueryHandler
	public List<UserResponseModel> handle(GetAllUserQuery getAllUserquery){
		List<User> listEntity = userRepository.findAll();
		List<UserResponseModel> listUser = new ArrayList<>();
		
		listEntity.forEach(s -> {
			UserResponseModel model = new UserResponseModel();
			BeanUtils.copyProperties(s, model);
			listUser.add(model);
		});
		return listUser;
	}
}
