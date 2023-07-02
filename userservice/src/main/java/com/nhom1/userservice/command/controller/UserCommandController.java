package com.nhom1.userservice.command.controller;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nhom1.userservice.command.command.CreateUserCommand;
import com.nhom1.userservice.command.command.DeleteUserCommand;
import com.nhom1.userservice.command.model.UserRequestModel;

@RestController
@RequestMapping("/api/v1/user")
public class UserCommandController {
	@Autowired 
	private  CommandGateway commandGateway;
	
	@PostMapping
	public String addUser(@RequestBody UserRequestModel model) {
		CreateUserCommand command = 
			new CreateUserCommand(UUID.randomUUID().toString(), model.getEmail(), model.getFullname(), model.getPswd(), 
					model.getDOB(), model.getPhone(), model.getAddress(), model.getRoleID(), model.getGender(), model.getTotalInvoices(), model.getIsDeleted());
		
		commandGateway.sendAndWait(command);
		return "User added";
	}
	
	@DeleteMapping("/{userID}")
	public String deleteUser(@PathVariable String userID) {
		System.out.print("run delete mapping");
		DeleteUserCommand command = new DeleteUserCommand(userID);
		commandGateway.sendAndWait(command);
		return "user deleted";
	}
}
