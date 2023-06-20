package com.nhom1.productservice.command.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.nhom1.productservice.command.command.CreateCategoryCommand;
import com.nhom1.productservice.command.command.DeleteCategoryCommand;
import com.nhom1.productservice.command.command.UpdateCategoryCommand;
import com.nhom1.productservice.command.event.CategoryCreatedEvent;
import com.nhom1.productservice.command.event.CategoryUpdateEvent;
import com.nhom1.productservice.command.event.CategoryDeleteEvent;

@Aggregate
public class CategoryAggregate {
	@AggregateIdentifier
	private String id;
	private String name;
	private String slug;
	private short exact;
	private short isDelete;

	public CategoryAggregate() {

	}

	@CommandHandler
	public CategoryAggregate(CreateCategoryCommand createCategoryCommand) {
		CategoryCreatedEvent categoryCreatedEvent = new CategoryCreatedEvent();
		BeanUtils.copyProperties(createCategoryCommand, categoryCreatedEvent);
		AggregateLifecycle.apply(categoryCreatedEvent);
	}

	@CommandHandler
	public void hendle(UpdateCategoryCommand updateCategoryCommand) {
		CategoryUpdateEvent categoryUpdateEvent = new CategoryUpdateEvent();
		BeanUtils.copyProperties(updateCategoryCommand, categoryUpdateEvent);
		AggregateLifecycle.apply(categoryUpdateEvent);
	}

	@CommandHandler
	public void hendle(DeleteCategoryCommand deleteCategoryCommand) {
		CategoryDeleteEvent categoryDeleteEvent = new CategoryDeleteEvent();
		BeanUtils.copyProperties(deleteCategoryCommand, categoryDeleteEvent);
		AggregateLifecycle.apply(categoryDeleteEvent);
	}

	@EventSourcingHandler
	public void on(CategoryCreatedEvent event) {
		this.id = event.getId();
		this.name = event.getName();
		this.slug = event.getSlug();
		this.exact = event.getExact();
		this.isDelete = event.getIsDelete();
	}

	@EventSourcingHandler
	public void on(CategoryUpdateEvent event) {
		this.id = event.getId();
		this.name = event.getName();
		this.slug = event.getSlug();
		this.exact = event.getExact();
		this.isDelete = event.getIsDelete();
	}

	@EventSourcingHandler
	public void on(CategoryDeleteEvent event) {
		this.id = event.getId();
	}

}
