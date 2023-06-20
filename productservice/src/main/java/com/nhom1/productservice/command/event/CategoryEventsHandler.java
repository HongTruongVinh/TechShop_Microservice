package com.nhom1.productservice.command.event;


import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nhom1.productservice.command.data.Category;
import com.nhom1.productservice.command.data.CategoryRepository;

@Component
public class CategoryEventsHandler {
	@Autowired
	private CategoryRepository categoryRepository;
	
	@EventHandler
	public void on(CategoryCreatedEvent event) {
		Category category = new Category();
		BeanUtils.copyProperties(event, category);
		categoryRepository.save(category);
		
	}
	
	@EventHandler
	public void on(CategoryUpdateEvent event) {
		Category category = categoryRepository.getById(event.getId()); 
		category.setName(event.getName());
		category.setSlug(event.getSlug()); 
		category.setExact(event.getExact());
		category.setIsDelete(event.getIsDelete()); 
		categoryRepository.save(category);
	}
	
	@EventHandler
	public void on(CategoryDeleteEvent event) { 
		Category category = categoryRepository.getById(event.getId()); 
		category.setIsDelete((short) 1);
		categoryRepository.save(category);
	}
	 
}
