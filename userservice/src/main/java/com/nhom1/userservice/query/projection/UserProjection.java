package com.nhom1.userservice.query.projection;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nhom1.commonservice.model.UserResponeseCommonModel;
import com.nhom1.commonservice.model.UserSessionCommonModel;
import com.nhom1.commonservice.query.GetUserDetailCommonQuery;
import com.nhom1.commonservice.query.GetUserSessionCommonQuery;
import com.nhom1.userservice.command.data.User;
import com.nhom1.userservice.command.data.UserRepository;
import com.nhom1.userservice.query.model.UserResponseModel;
import com.nhom1.userservice.query.queries.GetAllUserQuery;
import com.nhom1.userservice.query.queries.GetUserByIdQuery;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.User;

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
	public UserResponeseCommonModel handle(GetUserDetailCommonQuery query) {
		UserResponeseCommonModel model = new UserResponeseCommonModel();
		User entity = userRepository.findById(query.getUserID()).get();
		BeanUtils.copyProperties(entity, model);

		return model;
	}

	@QueryHandler
	public List<UserResponseModel> handle(GetAllUserQuery getAllUserquery) {
		List<User> listEntity = userRepository.findAll();
		List<UserResponseModel> listUser = new ArrayList<>();

		listEntity.forEach(s -> {
			UserResponseModel model = new UserResponseModel();
			BeanUtils.copyProperties(s, model);
			listUser.add(model);
		});
		return listUser;
	}

	@QueryHandler
	public UserSessionCommonModel handle(GetUserSessionCommonQuery query) {
		UserSessionCommonModel model = new UserSessionCommonModel();

		try {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			User userDetails = (User) auth.getPrincipal();

			model.setUserID(userDetails.getUserID());
			model.setEmail(userDetails.getEmail());

		} catch (Exception e) {
			return null;
		}

		return model;
	}

	public UserResponseModel setUserResponseModel(User entity) {
		UserResponseModel model = new UserResponseModel();
		model.setUserID(entity.getUserID());

		return model;
	}

}
