package com.nhom1.userservice.query.projection;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nhom1.userservice.command.data.Role;
import com.nhom1.userservice.command.data.RoleRepository;
import com.nhom1.userservice.query.model.RoleResponseModel;
import com.nhom1.userservice.query.queries.GetAllRoleQuery;
import com.nhom1.userservice.query.queries.GetRoleByIdQuery;


@Component
public class RoleProjection {
	@Autowired
	private RoleRepository roleRepository;
	
	@QueryHandler
	public RoleResponseModel handle(GetRoleByIdQuery getRolebyIdQuery) {
		RoleResponseModel model = new RoleResponseModel();
		Role entity = roleRepository.getById(getRolebyIdQuery.getId());
		BeanUtils.copyProperties(entity, model);
		
		return model;
	}
	
	@QueryHandler
	public List<RoleResponseModel> handle(GetAllRoleQuery getAllRoleQuery) {
		List<Role> listEntity = roleRepository.findAll();
		List<RoleResponseModel> listRole = new ArrayList<>();
		
		listEntity.forEach(s -> {
			RoleResponseModel model = new RoleResponseModel();
			BeanUtils.copyProperties(s, model);
			listRole.add(model);
		});
		return listRole;
	}
}
