package com.nhom1.userservice.command.aggregate;

import java.util.Date;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.nhom1.userservice.command.command.CreateUserCommand;
import com.nhom1.userservice.command.command.DeleteUserCommand;
import com.nhom1.userservice.command.event.UserCreatedEvent;
import com.nhom1.userservice.command.event.UserDeletedEvent;

@Aggregate
public class UserAggregate {
	@AggregateIdentifier
	private String userID;
	
	private String email;
	private String fullname;
	private String pswd;
	private Date DOB;
	private String phone;
	private String address;
	private String roleID;
	private String gender;
	private int totalInvoices;
	private short isDeleted;
	
	public UserAggregate() {}
	
	@CommandHandler
	public UserAggregate(CreateUserCommand command) {
		UserCreatedEvent event = new UserCreatedEvent();
		BeanUtils.copyProperties(command, event);
		AggregateLifecycle.apply(event);
	}
	
	@CommandHandler
	public void handle(DeleteUserCommand command) {
		System.out.print("run handle delete");
		UserDeletedEvent event = new UserDeletedEvent();
		event.setEmployeeId(command.getUserId());
		AggregateLifecycle.apply(event);
	}
	
	@EventSourcingHandler
	public void on(UserCreatedEvent event) {
		this.userID = event.getUserID();
		this.email = event.getEmail();
		this.fullname = event.getFullname();
		this.pswd = event.getPswd();
		this.DOB = event.getDOB();
		this.phone = event.getPhone();
		this.address = event.getAddress();
		this.roleID = event.getAddress();
		this.gender = event.getGender();
		this.totalInvoices = event.getTotalInvoices();
		this.isDeleted = event.getIsDeleted();
	}
	
	@EventSourcingHandler
	public void on(UserDeletedEvent event) {
		this.userID = event.getUserId();
	}
}
