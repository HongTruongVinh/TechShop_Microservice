package com.nhom1.userservice.command.event;

import org.springframework.stereotype.Component;

import com.nhom1.userservice.command.data.User;
import com.nhom1.userservice.command.data.UserRepository;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class UserEventsHandler {
	@Autowired
	private UserRepository userRepository;
	
	@EventHandler
	public void on(UserCreatedEvent event) {
		User user = new User();
		BeanUtils.copyProperties(event, user);
		userRepository.save(user);
	}
	
	@EventHandler
	public void on(UserDeletedEvent event) {
		userRepository.deleteById(event.getUserId());
	}
}
