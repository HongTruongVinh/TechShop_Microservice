package com.nhom1.invoiceservice.command.aggergate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.nhom1.invoiceservice.command.command.CreateInvoiceCommand;
import com.nhom1.invoiceservice.command.event.InvoiceCreateEvent;

@Aggregate
public class InvoiceAggergate {
	@AggregateIdentifier
	private int invoiceID;
	
	private int userID;
	private int totalCost;
	private String invoiceDate;
	private String shippingDate;
	private String note;
	private boolean otherShippingAddress;
	private String statusInvoice= "PENDING";
	private String userInvoiceIndex;
	
	public InvoiceAggergate() {}
	
	@CommandHandler
	public InvoiceAggergate(CreateInvoiceCommand command) {
		InvoiceCreateEvent event = new InvoiceCreateEvent();
		BeanUtils.copyProperties(command, event);
		AggregateLifecycle.apply(event);
	}
	
	@EventSourcingHandler
	public void on(InvoiceCreateEvent event) {
		this.invoiceID = event.getInvoiceID();
		this.userID = event.getUserID();
		this.totalCost = event.getTotalCost();
		this.invoiceDate = event.getInvoiceDate();
		this.shippingDate = event.getShippingDate();
		this.note = event.getNote();
		this.otherShippingAddress = event.isOtherShippingAddress();
		this.userInvoiceIndex = event.getUserInvoiceIndex();
	}
}
