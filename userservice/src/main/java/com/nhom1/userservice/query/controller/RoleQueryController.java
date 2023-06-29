package com.nhom1.userservice.query.controller;

import java.util.List;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nhom1.userservice.query.model.RoleResponseModel;
import com.nhom1.userservice.query.queries.GetAllRoleQuery;
import com.nhom1.userservice.query.queries.GetRoleByIdQuery;

@RestController
@RequestMapping("/api/v1/role")
public class RoleQueryController {
	@Autowired
	private QueryGateway queryGateway;
	
	@GetMapping("/{id}")
	public RoleResponseModel getRoleDetail(@PathVariable String id) {
		GetRoleByIdQuery getRoleByIdQuery = new GetRoleByIdQuery();
		getRoleByIdQuery.setId(id);
		
		RoleResponseModel RoleResponseModel = queryGateway.query(getRoleByIdQuery, 
				ResponseTypes.instanceOf(RoleResponseModel.class)).join();
		
		return RoleResponseModel;
	}
	
	@GetMapping()
	public List<RoleResponseModel> getAllRoleDetail() {
		GetAllRoleQuery getAllRoleQuery = new GetAllRoleQuery();


		List<RoleResponseModel> list = queryGateway.query(getAllRoleQuery, 
				ResponseTypes.multipleInstancesOf(RoleResponseModel.class)).join();
		
		return list;
	}
}
