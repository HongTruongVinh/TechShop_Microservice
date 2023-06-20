package com.nhom1.productservice.command.controller;

import java.util.UUID;

import org.axonframework.axonserver.connector.command.AxonServerCommandDispatchException;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nhom1.productservice.command.command.*;
import com.nhom1.productservice.command.model.CategoryRequestModel;

@RestController
@RequestMapping("/api/v1/categories")
public class CatagoryCommandController {
	@Autowired
	private CommandGateway commandGateway;

	@PostMapping
	public String addCategoryString(@RequestBody CategoryRequestModel model) {
		CreateCategoryCommand command = new CreateCategoryCommand(UUID.randomUUID().toString(), model.getName(),
				model.getSlug(), model.getExact(), model.getIsDelete());
		commandGateway.sendAndWait(command);
		return "added Category";
	}

	@PutMapping
	public String updateCategoryString(@RequestBody CategoryRequestModel model) {
		UpdateCategoryCommand command = new UpdateCategoryCommand(model.getId(), model.getName(), model.getSlug(),
				model.getExact(), model.getIsDelete());
		commandGateway.sendAndWait(command);
		return "updated Category";
	}

	@DeleteMapping("/{categoryId}")
	public String deleteBook(@PathVariable String categoryId) {
		DeleteCategoryCommand command = new DeleteCategoryCommand(categoryId);
		commandGateway.sendAndWait(command);
		return "deleted Book";
	}

}
